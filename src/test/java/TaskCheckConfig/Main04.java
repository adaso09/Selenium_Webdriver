package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main04 {
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver",
//                "src/main/resources/drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://hotel-testlab.coderslab.pl/en/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement singin = driver.findElement(By.className("hide_xs"));
//        singin.click();
//        WebElement emailAdd = driver.findElement(By.id("email_create"));
//        emailAdd.click();
//        emailAdd.sendKeys("kozalssa@test.com");
//        WebElement newUser = driver.findElement(By.id("SubmitCreate"));
//        newUser.click();
//        WebElement userName = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
//        userName.sendKeys("Rafal");
//        WebElement userSurname = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
//        userSurname.sendKeys("Kowalski");
//        WebElement password = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
//        password.sendKeys("Kowala12");
//        WebElement register = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
//        register.click();
//        driver.quit();


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
            email.sendKeys("jlen@test.com");
            passwordInput.sendKeys("mypassword");
            registerButton.click();
            driver.quit();


    }
}
