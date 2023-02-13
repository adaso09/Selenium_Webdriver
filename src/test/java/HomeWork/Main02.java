package HomeWork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main02 {
    private WebDriver driver;
    @Before
    public void firefoxOpen(){
        System.setProperty("webdriver.geckodriver.exe","src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }
    @Test
    public  void singInTest(){
        Main01_cnd main01Cnd = new Main01_cnd(driver );
        main01Cnd.loginUser();
        // Assert.assertEquals("", main01Cnd.getName());
    }
    @After
    public void compareTestList(){
        driver.quit();
    }
}