package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Main03_cnd {
    private static WebDriver driver;

    public  Main03_cnd(WebDriver driver){
        this.driver = driver;
    }

    public void kartolOneTest(String firstname,String lastname, String adrss,String company,String comment){
        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        WebElement adressInput = driver.findElement(By.name("address"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement companyInput = driver.findElement(By.name("company"));
        WebElement commentInput = driver.findElement(By.name("comment"));
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        adressInput.sendKeys(adrss);
        emailInput.sendKeys(RandomString.generateRandomEmail());
        passwordInput.sendKeys(RandomPassword.generateRandomPassword());
        companyInput.sendKeys(company);
        commentInput.sendKeys(comment);

    }
    public void others(){
        WebElement birthday = driver.findElement(By.name("dob"));
        WebElement sexType = driver.findElement(By.name("gender"));
        sexType.click();
        birthday.sendKeys("11/04/1995");

    }
}
