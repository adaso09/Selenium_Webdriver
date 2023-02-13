package Funkcje;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UserLoginTest {
    private static WebDriver driver;
    @Before
    public void loginUser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }

    @Test
    public void loginTest(){
        UserLoginPage userLoginPage= new UserLoginPage(driver);
        userLoginPage.loginInputed("dciFtIibnq@test.com","asadaw23");
        userLoginPage.hotelSearch("London");
        userLoginPage.bookHotel();
        userLoginPage.shoopingCart();
       // Assert.assertEquals("Room successfully added to your cart", userLoginPage.getRoomBook());
        Assert.assertEquals("Delux Rooms",userLoginPage.getHotelName());

      //  Assert.assertEquals("Your order on MyBooking is complete.", userLoginPage.getOrderMyBook());
    }
    @After
    public  void ouitProgram(){
        driver.quit();
    }
}
