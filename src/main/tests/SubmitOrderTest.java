package main.tests;

import main.com.mysite.pages.HomePage;
import main.com.mysite.pages.OrderPage;
import main.com.mysite.pages.SearchPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubmitOrderTest extends BaseTest {
    HomePage homePage;
    SearchPage searchPage;
    OrderPage orderPage;
    public static Logger logger = Logger.getLogger(OrderPage.class);

    @Test
    public void SubmitOrder(){
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        homePage.login(user,password);

        String pagetitle = getPagetitle();
        Assert.assertEquals(pagetitle,"Search item");
        String searchItem = prop.getProperty("searchItem");
        searchPage.addCart(searchItem,1);

        String name = prop.getProperty("name");
        String mobile = prop.getProperty("mobile");
        String address = prop.getProperty("address");

        orderPage.SubmitOrder(name,mobile,address);
        pagetitle = getPagetitle();
        Assert.assertEquals(pagetitle,"Submit order");
    }
}
