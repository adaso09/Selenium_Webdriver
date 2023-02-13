package Zadania.Zadania_Warsztatowe_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyStoreShopAdresses {
        private final WebDriver driver;

        @FindBy(className = "material-icons")
        WebElement adress;
        @FindBy(name = "alias")
        WebElement aliasInput;
        @FindBy(name = "address1")
        WebElement adressInput;
        @FindBy(name = "postcode")
        WebElement postCodeInput;
        @FindBy(name = "city")
        WebElement cityInput;
        @FindBy(name ="id_country")
        List<WebElement> countryInput;
        @FindBy(name = "phone")
        WebElement phoneInput;

        @FindBy(name = "submitAddress")
        WebElement submitSaves;


        public MyStoreShopAdresses(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
        public void addFirstAdress(){
            adress.click();
        }
    public void enterNewAddressData(String alias, String address, String city, String postalCode, String phoneNumber){
            aliasInput.click();
            aliasInput.clear();
            aliasInput.sendKeys(alias);

            adressInput.click();
            adressInput.clear();
            adressInput.sendKeys(address);

            postCodeInput.click();
            postCodeInput.clear();
            postCodeInput.sendKeys(postalCode);

            cityInput.click();
            cityInput.clear();
            cityInput.sendKeys(city);

            countryInput.get(1);

            phoneInput.click();
            phoneInput.clear();
            phoneInput.sendKeys(phoneNumber);

            submitSaves.click();
    }
    }
