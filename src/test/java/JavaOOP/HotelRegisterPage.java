package JavaOOP;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRegisterPage {

    private final WebDriver driver;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwdInput;

    @FindBy(name = "submitAccount")
    private WebElement submitBtn;

    public HotelRegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void provideRequiredUserData(String name, String lastname, String passwd) {
        firstNameInput.clear();
        firstNameInput.sendKeys(name);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);

        passwdInput.clear();
        passwdInput.sendKeys(passwd);
    }

    public String getEmail() {
        return emailInput.getAttribute("value");
    }

    public HotelMyAccountPage register() {
        submitBtn.click();
        return new HotelMyAccountPage(driver);
    }
}