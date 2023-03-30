package Zadania;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;


public class MyStoreShopAdresses {
    private final WebDriver driver;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-phone")
    private WebElement phoneNumberInput;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement submitBtn;
    @FindBy(xpath = "//*[@id=\"field-id_country\"]/option[2]")
    private WebElement countryInput;

    @FindBy(xpath = "//*[@id=\"field-id_state\"]/option[35]")
    private  WebElement state;
    public MyStoreShopAdresses(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void enterNewAddressDataes(String alias, String address, String city, String postalCode, String phone) {
        WebElement addressInput = driver.findElement(By.name("address1"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addressInput.clear();
        addressInput.sendKeys(address);
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        cityInput.clear();
        cityInput.sendKeys(postalCode);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(city);
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
        countryInput.click();
        state.click();

        submitBtn.click();
    }

}
