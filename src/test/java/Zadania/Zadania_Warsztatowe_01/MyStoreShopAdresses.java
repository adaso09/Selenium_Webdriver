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
    @FindBy(className ="alert alert-success" )
    WebElement message;
    @FindBy(xpath = "//*[@id=\"address-31271\"]/div[2]/a[2]") // do zrobienia poprawny
    WebElement removeAdress;


    public MyStoreShopAdresses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addFirstAdress(){
        adress.click();
    }
    public boolean coutryInputGet(){
        // check
        return countryInput.size() >0;

    }
    public void enterNewAddressShopData(String alias, String address, String city, String postalCode, String phoneNumber){
        WebElement country  = countryInput.get(0);
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



        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);

        submitSaves.click();
    }
//    public  String getAddressDateAsText(){
//        WebElement country  = countryInput.get(0);
//        String alias = country.findElement(By.name("alias")).getText();
//        String addressText = country.findElement(By.name("address1")).getText();
//        String city = country.findElement(By.name("city")).getText();
//        String postal = country.findElement(By.name("postcode")).getText();
//        String phone = country.findElement(By.name("phone")).getText();
//    // do zrobinia
//         return  null; //String.join("\n", alias, addressText, cityAndPostal, phone);

    public String getAddressName(){
        return message.getText();
    }
    public  String getRemoveAdress(){
        // check
        return null;
    }
}
