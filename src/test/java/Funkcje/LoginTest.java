package Funkcje;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

    public class LoginTest {
        private static WebDriver driver;
        @Before
        public void SetUp(){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");

        }
        @Test

        public void testLoginWithProperCredentials() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
            Assert.assertEquals("Automated Tester", loginPage.getLoggedUsername());
        }
        @After

        public void tearDown() {
            driver.quit();
        }
    }





