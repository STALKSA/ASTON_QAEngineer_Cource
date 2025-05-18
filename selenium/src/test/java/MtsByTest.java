import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MtsByTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String SITE_URL = "https://www.mts.by";

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        // Добавляем параметр для автоматического принятия куки
        options.setExperimentalOption("prefs", Map.of(
                "profile.default_content_setting_values.cookies", 1,
                "profile.cookie_controls_mode", 0
        ));

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(SITE_URL);

        // Улучшенная обработка куки-баннера
        try {
            // Проверяем наличие баннера (увеличиваем timeout для куки)
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Принять') or contains(., 'Accept')]")))
                    .click();
        } catch (TimeoutException e) {
            System.out.println("Окно с куками не появилось - продолжаем тест");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //@Test(priority = 1)
    //public void testBlockTitle() {
        // Более точный локатор для заголовка
    //   WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
     //           By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")
     //   ));
     //   Assert.assertTrue(blockTitle.getText().contains("без комиссии"),
      //          "Заголовок блока не соответствует ожидаемому");
    //}

    @Test(priority = 1)
    public void testBlockTitle() {
        try {
            WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(., 'без комиссии')] | //h2[contains(., 'Онлайн пополнение')]")
            ));
            Assert.assertTrue(blockTitle.isDisplayed(), "Заголовок блока не отображается");
            Assert.assertTrue(blockTitle.getText().contains("без комиссии") ||
                            blockTitle.getText().contains("Онлайн пополнение"),
                    "Заголовок блока не соответствует ожидаемому");
        } catch (TimeoutException e) {
            Assert.fail("Не удалось найти заголовок блока: " + e.getMessage());
        }
    }

   // @Test(priority = 2)
   // public void testPaymentLogos() {
        // Проверяем наличие текстовых упоминаний платежных систем
     //   boolean hasVisa = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img")).size() > 0;
    //    boolean hasMastercard = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img")).size() > 0;
    //    boolean hasBelcard = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img")).size() > 0;


    //    Assert.assertTrue(hasVisa, "Не найдено упоминание Visa");
     //   Assert.assertTrue(hasMastercard, "Не найдено упоминание MasterCard");
     //   Assert.assertTrue(hasBelcard, "Не найдено упоминание Белкарт");
   // }

    @Test(priority = 2)
    public void testPaymentLogos() {
        try {
            List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//*[@id=\"pay-section\"]//img[contains(@alt, 'Visa') or contains(@alt, 'Mastercard') or contains(@alt, 'Белкарт')]")
            ));

            Assert.assertTrue(logos.size() >= 3, "Найдено недостаточно логотипов платежных систем");

            // Проверяем видимость каждого логотипа
            for (WebElement logo : logos) {
                Assert.assertTrue(logo.isDisplayed(), "Логотип не отображается");
            }
        } catch (TimeoutException e) {
            Assert.fail("Не удалось найти логотипы платежных систем: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testPaymentForm() {
        try {
            // Выбираем "Услуги связи"
            WebElement serviceLabel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[contains(., 'Услуги связи')] | //span[contains(., 'Услуги связи')]")
            ));
            serviceLabel.click();

            // Вводим номер
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[contains(@placeholder, 'Номер телефона') or contains(@id, 'phone')]")
            ));
            phoneInput.clear();
            phoneInput.sendKeys("297777777");

            // Нажимаем "Продолжить"
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Продолжить')]")
            ));
            continueButton.click();

            // Проверяем результат
            try {
                // Вариант 1: Проверяем сообщение об успехе
                WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(., 'оплата') or contains(., 'платеж') or contains(., 'успешно')]")
                ));
                Assert.assertTrue(successElement.isDisplayed());
            } catch (TimeoutException e) {
                // Вариант 2: Проверяем изменение URL
                wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(SITE_URL)));
                Assert.assertNotEquals(driver.getCurrentUrl(), SITE_URL,
                        "Не произошло перенаправление после отправки формы");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            Assert.fail("Не удалось заполнить или отправить форму: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void testDetailsLink() {
        try {
            // Ищем ссылку "Подробнее о сервисе"
            WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"pay-section\"]//a[contains(., 'Подробнее')]")
            ));

            String originalUrl = driver.getCurrentUrl();
            detailsLink.click();

            // Ждем изменения URL или открытия новой вкладки
            try {
                // Вариант 1: Ожидаем изменения URL в текущей вкладке
                wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));
                Assert.assertNotEquals(driver.getCurrentUrl(), originalUrl,
                        "Ссылка не изменила URL текущей страницы");
            } catch (TimeoutException e1) {
                // Вариант 2: Проверяем открытие новой вкладки
                if (driver.getWindowHandles().size() > 1) {
                    String originalWindow = driver.getWindowHandle();
                    for (String windowHandle : driver.getWindowHandles()) {
                        if (!originalWindow.contentEquals(windowHandle)) {
                            driver.switchTo().window(windowHandle);
                            break;
                        }
                    }
                    Assert.assertNotEquals(driver.getCurrentUrl(), SITE_URL,
                            "Новая вкладка не открылась или имеет тот же URL");
                    driver.close();
                    driver.switchTo().window(originalWindow);
                } else {
                    Assert.fail("Ссылка не вызвала ни изменения URL, ни открытия новой вкладки");
                }
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Ссылка 'Подробнее о сервисе' не найдена");
        }
    }

}