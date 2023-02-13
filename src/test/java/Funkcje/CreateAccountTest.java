package Funkcje;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CreateAccountTest {
    private static WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");

    }
    @Test
    public void createAccountTest(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.createAccount();
        createAccountPage.personalInformationTest("Keli","Kopfa","asadaw23");
        Assert.assertEquals("Keli",
                createAccountPage.getLoggedEmail());

    }
    @After
    public  void outOfProcess(){
        driver.close();
    }
}
