package HomeWork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main01 {
    private static WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
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
