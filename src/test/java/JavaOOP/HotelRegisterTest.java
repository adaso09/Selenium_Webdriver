package JavaOOP;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class HotelRegisterTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/");
    }

    @Test
    public void testNewUserRegistration() {
        HotelMainPage mainPage = new HotelMainPage(driver);
        HotelAuthPage authPage = mainPage.signInWithPage();

        String generatedEmail = DataFaker.createRandomEmail();
        String generatedName = DataFaker.createRandomFirstName();
        HotelRegisterPage registerPage = authPage.enterNewUserEmailAndSubmit(generatedEmail);

        registerPage.provideRequiredUserData(generatedName, DataFaker.createRandomLastName(), "superPass@");
        System.out.println("Generation Email:" + generatedEmail);
        Assertions.assertEquals(generatedEmail, registerPage.getEmail());


        HotelMyAccountPage myAccountPage = registerPage.register();
        Assertions.assertTrue(myAccountPage.isSuccessAlertDisplayed());
        Assertions.assertEquals("Your account has been created.", myAccountPage.getSuccessMessage());
        Assertions.assertEquals(generatedName, myAccountPage.getUserName());
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}