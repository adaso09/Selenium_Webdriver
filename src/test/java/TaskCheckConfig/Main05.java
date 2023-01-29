package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main05 {
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver",
//                "src/main/resources/drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://hotel-testlab.coderslab.pl/en/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        WebElement singin = driver.findElement(By.className("hide_xs"));
//        singin.click();
//        WebElement login = driver.findElement(By.cssSelector("input.data-validate=\"isEmail\""));
//        login.click();
//        login.sendKeys("koala@test.com");
//        WebElement password = driver.findElement(By.cssSelector("input.is_required.validate.account_input.form-control"));
//        password.click();
//        password.sendKeys("Kowala12");
//        WebElement submit = driver.findElement(By.cssSelector("button.btn.button.button-medium"));
//        submit.click();
//        driver.quit();
//    }
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://hotel-testlab.coderslab.pl/en/");

    WebElement signInLink = driver.findElement(By.className("user_login"));
    signInLink.click();
    WebElement emailInput = driver.findElement(By.className("account_input"));
    emailInput.sendKeys("random@test.com");
    WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
    createAccountButton.submit();

    WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
    WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
    WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
    WebElement passwordInput = driver.findElement(By.xpath("//input[@id=\"passwd\"]"));
    WebElement registerButton = driver.findElement(By.xpath("//button[@id=\"submitAccount\"]"));

    firstNameInput.sendKeys("John");
    lastNameInput.sendKeys("Lennon");
    email.clear();
    email.sendKeys("jlen@test.com"); // trzeba stworzyć metodę która będzie tworzyć nowego maila z każdym uruchomieniem
    passwordInput.sendKeys("mypassword");
    registerButton.click();

    WebElement myPersonalInfo = driver.findElement(By.cssSelector("[title=\"Information\"]>span"));
    WebElement myAdresses = driver.findElement(By.cssSelector("[title=\"Addresses\"]>span"));
    driver.quit();

}
}
