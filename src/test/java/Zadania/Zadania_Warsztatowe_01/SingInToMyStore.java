package Zadania.Zadania_Warsztatowe_01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInToMyStore {

    private final WebDriver driver;

    @FindBy(name = "email")
    private WebElement loginInputElement;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private  WebElement signInButton;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement userName;

    public SingInToMyStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void loginAsMain(String email, String password) {
        loginInputElement.click();
        loginInputElement.clear();
        loginInputElement.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }

    public String getLoggedUsername() {
        return userName.getText();
    }
}
