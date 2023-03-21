package JavaOOP;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelAuthPage {

    private final WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement newUserEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createNewAccountBtn;
    @FindBy(id = "email")
    private WebElement loginEmailInput;
    @FindBy(id = "passwd")
    private  WebElement loginPasswordInput;
    @FindBy(name = "SubmitLogin")
    private WebElement loginbtn;

    public HotelAuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HotelRegisterPage enterNewUserEmailAndSubmit(String email) {
        newUserEmailInput.clear();
        newUserEmailInput.sendKeys(email);

        createNewAccountBtn.click();
        return new HotelRegisterPage(driver);
    }
    public HotelMyAccountPage loginAs(String email, String password){
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);

        loginPasswordInput.clear();
        loginPasswordInput.sendKeys(password);
        loginbtn.click();
        return new HotelMyAccountPage(driver);
    }
}