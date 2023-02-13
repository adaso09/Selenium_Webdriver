package Funkcje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {

    private static WebDriver driver;
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void createAccount(){
        WebElement loginInpute = driver.findElement(By.name("email_create"));
        loginInpute.click();
        loginInpute.clear();
        loginInpute.sendKeys(RandomString.generateRandomEmail());


        WebElement submitAccount = driver.findElement(By.name("SubmitCreate"));
        submitAccount.click();

    }
    public void personalInformationTest(String firstName, String lastName, String password){
        WebElement firstNameSet = driver.findElement(By.name("customer_firstname"));
        firstNameSet.click();
        firstNameSet.sendKeys(firstName);
        firstNameSet.click();
        WebElement lastNameSet = driver.findElement(By.name("customer_lastname"));
        lastNameSet.click();
        lastNameSet.sendKeys(lastName);
        WebElement email = driver.findElement(By.name("email"));
        email.click();
        WebElement passwordSet = driver.findElement(By.name("passwd"));
        passwordSet.click();
        passwordSet.sendKeys(password);
        WebElement register = driver.findElement(By.id("submitAccount"));
        register.click();
    }
    public String getLoggedEmail(){
        WebElement userNamed = driver.findElement(By.id("user_info_acc"));
        return userNamed.getText();
    }
}

