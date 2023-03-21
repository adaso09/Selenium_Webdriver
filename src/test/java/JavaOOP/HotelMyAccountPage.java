package JavaOOP;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMyAccountPage {

    private final WebDriver driver;

    @FindBy(css = ".alert.alert-success")
    private WebElement successAlert;

    @FindBy(css = ".account_user_name")
    private WebElement userInfoElement;
    @FindBy(css = "a[title=Home]")
    private WebElement homeBtn;
    public HotelMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }

    public String getSuccessMessage() {
        return successAlert.getText();
    }

    public String getUserName() {
        return userInfoElement.getText();
    }
    public HotelMainPage goToHomePage() {
        homeBtn.click();
        return new HotelMainPage(driver);
    }
}