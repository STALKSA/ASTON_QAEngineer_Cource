package com.mts.tests;

import com.mts.pages.PaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected PaymentPage paymentPage;
    protected final String SITE_URL = "https://www.mts.by";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        System.setProperty("webdriver.chrome.silentOutput", "false");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", Map.of(
                "profile.default_content_setting_values.cookies", 1,
                "profile.cookie_controls_mode", 0
        ));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(SITE_URL);

        paymentPage = new PaymentPage(driver);

        try {
            driver.findElement(By.xpath("//button[contains(., 'Принять')]")).click();
        } catch (Exception e) {
            System.out.println("Куки-баннер не появился");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
