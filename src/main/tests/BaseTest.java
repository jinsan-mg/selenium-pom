package main.tests;

import main.com.mysite.pages.OrderPage;
import main.com.mysite.util.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends TestUtils {
    public  WebDriver driver;

    @BeforeTest
    public  void startDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/jinsgeorge/Documents/Selenium/chromedriver");
        driver = new ChromeDriver();
        OpenBrowser();
    }

    public void OpenBrowser() {
        driver.get(getUrl());
        driver.manage().window().maximize();
    }

    public String getPagetitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public static String getUrl() {
        return prop.getProperty("url");
    }

    @AfterTest
    public  void quitDriver() {
        driver.close();
    }
}