package main.tests;

import main.com.mysite.pages.OrderPage;
import main.com.mysite.util.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends TestUtils {

    @BeforeTest
    public static WebDriver startDriver() {
        WebDriver driver;
        driver = new FirefoxDriver();
        OpenBrowser(driver);
        return driver;
    }

    public static void OpenBrowser(WebDriver driver) {
        driver.get(getUrl());
        driver.manage().window().maximize();
    }

    public static String getUrl() {
        return prop.getProperty("url");
    }
    @AfterTest
    public static void quitDriver(WebDriver driver) {
        driver.close();
    }
}