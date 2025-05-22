package com.mts.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class PaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"pay-section\"]//img[contains(@alt, 'Visa') or contains(@alt, 'Mastercard') or contains(@alt, 'Белкарт')]")
    private List<WebElement> paymentSystemElements;

    @FindBy(xpath = "//a[contains(text(), 'Подробнее') or contains(@href, 'details')]")
    private WebElement detailsLink;

    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[1]")
    private WebElement mobileServicesOption;

    @FindBy(xpath = "//input[contains(@placeholder, 'Номер телефона')]")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'Сумма')]")
    private WebElement amountInput;

    @FindBy(xpath = "//button[contains(., 'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span")
    private WebElement paymentAmount;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span")
    private WebElement paymentDescription;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label")
    private WebElement expiryDateLabel;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label")
    private WebElement cvcLabel;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label")
    private WebElement cardNameLabel;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div//img")
    private List<WebElement> paymentSystemIcons;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void verifyPageTitle() {
        WebElement visibleTitle = wait.until(ExpectedConditions.visibilityOf(pageTitle));
        assertTrue(visibleTitle.getText().contains("Онлайн пополнение"),
                "Заголовок блока не найден или не соответствует");
    }

    public void verifyPaymentLogos() {
        wait.until(d -> !paymentSystemElements.isEmpty());

        assertTrue(paymentSystemElements.size() >= 2,
                "Найдено недостаточно логотипов платежных систем. Найдено: " + paymentSystemElements.size());

        for (WebElement logo : paymentSystemElements) {
            assertTrue(logo.isDisplayed(), "Логотип не отображается");
        }
    }

    public void verifyServiceOptions() {
        WebElement clickableOption = wait.until(ExpectedConditions.elementToBeClickable(mobileServicesOption));
        clickableOption.click();

        assertEquals(phoneInput.getAttribute("placeholder"), "Номер телефона",
                "Неверный плейсхолдер для номера телефона");
    }

    public void fillMobilePaymentForm(String phoneNumber, String amount) {
        mobileServicesOption.click();
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void verifyPaymentModal(String expectedAmount, String expectedPhone) {
        WebElement cardForm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[2]/app-switcher-form-control/div/app-switcher/div/label")));

        assertTrue(cardNumberLabel.isDisplayed(), "Поле номера карты не отображается");
        assertTrue(expiryDateLabel.isDisplayed(), "Поле срока действия не отображается");

        WebElement amountElement = driver.findElement(
                By.xpath("//*[contains(text(), 'BYN') or contains(text(), 'руб') or contains(@class, 'amount')]"));
        assertTrue(amountElement.getText().contains(expectedAmount),
                "Сумма платежа не совпадает. Ожидалось: " + expectedAmount);
    }

    public void submitPaymentForm() {
        assertFalse(phoneInput.getAttribute("value").isEmpty());
        assertFalse(amountInput.getAttribute("value").isEmpty());

        continueButton.click();

        wait.until(ExpectedConditions.invisibilityOf(continueButton));
        // или
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'loader') or contains(@class, 'loading')]")));
    }

    public void openDetailsPage() {
        String originalWindow = driver.getWindowHandle();
        String originalUrl = driver.getCurrentUrl();

        WebElement clickableLink = wait.until(ExpectedConditions.elementToBeClickable(detailsLink));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", clickableLink);

        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.equals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    String newUrl = driver.getCurrentUrl();
                    assertNotEquals(newUrl, originalUrl,
                            "Новая вкладка имеет тот же URL, что и оригинальная");

                    driver.close();
                    driver.switchTo().window(originalWindow);
                    return;
                }
            }
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));
            String newUrl = driver.getCurrentUrl();
            assertNotEquals(newUrl, originalUrl,
                    "Ссылка не привела к изменению URL");
            return;
        }

        fail("Не удалось подтвердить открытие ссылки");
    }

}