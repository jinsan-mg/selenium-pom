package main.com.mysite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import main.com.mysite.util.TestUtils;

public class OrderPage {
    WebDriver driver;
    TestUtils testUtils;

    By incrementor = By.xpath("//div");
    By btnsubmit = By.className("btn_submit");
    By btnPay = By.id("pay");
    By OTP = By.id("OTP");
    By name = By.id("name");
    By mobile = By.id("mobile");
    By address = By.id("address");
    By paymentConfirmation = By.xpath("xpath");

    public static Logger logger = Logger.getLogger(OrderPage.class);

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SubmitOrder(String strName, String strMobile, String strAddress) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 100);
            logger.info("On the submit order page page");
            driver.findElement(name).sendKeys(strName);
            driver.findElement(mobile).sendKeys(strMobile);
            driver.findElement(address).sendKeys(strAddress);
            //getOTP
            String strOTP = testUtils.getOTP();
            driver.findElement(OTP).sendKeys(strOTP);
            driver.findElement(btnPay).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated((paymentConfirmation)));
            logger.info("payment is completed");
            driver.findElement(btnsubmit).click();
            logger.info("Order is placed");
        } catch (Exception exception) {
            logger.error("Exception in the order submit page:" + exception);
        }
    }
}
