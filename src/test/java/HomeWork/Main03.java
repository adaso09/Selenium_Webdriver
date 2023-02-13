package HomeWork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main03 {
    private WebDriver driver;

    @Before
    public void setkatalon(){
        System.setProperty("webdriver.geckodriver.exe","src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }
    @Test
    public void katalonTest(){
    Main03_cnd main03Cnd = new Main03_cnd(driver);
        main03Cnd.kartolOneTest("Jan","Nowak","Lipowa 2a","Coders Guru","To jest mój pierwszy automat testowy");
    }
    @After
    public void endTask(){
        driver.quit();
    }
}
