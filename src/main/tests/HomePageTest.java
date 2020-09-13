package main.tests;

import main.com.mysite.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    public static Logger logger = Logger.getLogger(HomePage.class);

    @Test
    public void verifyLoginPage(){
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        homePage.login(user,password);
    }
}
