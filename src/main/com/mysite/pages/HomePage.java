package main.com.mysite.pages;

import main.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import main.com.mysite.util.TestUtils;


public class HomePage {
    WebDriver driver;
    TestUtils testUtils;
    By userNameElement = By.xpath("//div");
    By userName = By.id("username");
    By password = By.id("password");
    By captcha = By.id("captcha");
    By login = By.className("btn_login");
    By invalidUserName = By.xpath("//xpath");
    By searchElement = By.xpath("xpath");
    By searchField = By.xpath("//input[@title='Search']");
    By searchBtn = By.xpath("//input[@name='btnK']");

    public Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String strUsername,String strPassword) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 100);
            wait.until(ExpectedConditions.visibilityOfElementLocated((userNameElement)));
            logger.info("On the home page");
            driver.findElement(userName).sendKeys(strUsername);
            driver.findElement(password).sendKeys(strPassword);
            //get captcha
            String strCaptcha = testUtils.getCaptchaCode();
            driver.findElement(captcha).sendKeys(strCaptcha);
            driver.findElement(login).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated((searchElement)));
            logger.info("login completed");
        } catch (Exception exception) {
            logger.error("Exception in the home page:" + exception);
        }
    }
}