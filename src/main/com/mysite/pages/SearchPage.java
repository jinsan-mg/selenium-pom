package main.com.mysite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class SearchPage {
    WebDriver driver;
    By searchElement = By.xpath("//div");
    By search = By.id("username");
    By incrementor = By.xpath("xpath");
    By checkout = By.id("btn_checkout");

    public static Logger logger = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCart(String strSearchItem,int orderQuantity) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated((searchElement)));
            logger.info("On the search page");
            driver.findElement(search).sendKeys(strSearchItem);
            for(int i=0; i<orderQuantity; i++){
                driver.findElement(incrementor).click();
            }
            driver.findElement(checkout).click();
            logger.info("item added to cart");
        } catch (Exception exception) {
            logger.error("Exception in the search page:" + exception);
        }
    }
}