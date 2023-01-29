package Funkcje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main01 {
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
        registerButton.isDisplayed();
        if(registerButton.isDisplayed()){  // sprawdzamy czy registerButton jest widoczny
            registerButton.click();
        }
        driver.quit();


    }
}
