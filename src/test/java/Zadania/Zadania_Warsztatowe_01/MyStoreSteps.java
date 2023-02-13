package Zadania.Zadania_Warsztatowe_01;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStoreSteps {
    SingInToMyStore singInToMyStore;
     WebDriver driver;


    @Given("I'm on shop main page")
        public void mainPage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");

    }


    @When("I go to login page")
    public void iGoToLoginPage() {
        SingInToMyStore singIn = new SingInToMyStore(driver);
        singIn.loginIn();

    }

    @And("I login using  email {string} and password {string}")
    public void iLoginUsingEmailAndPassword(String email, String password) {
        SingInToMyStore singInToMyStore = new SingInToMyStore(driver);
        singInToMyStore.loginAsMain("liqyvtakwrueowhjhd@bbitj.com", "qwerty123@");
    }

    @And("I go to my addresses page")
    public void iGoToMyAddressesPage() {
        MyStoreShopAdresses myStoreShopAdresses = new MyStoreShopAdresses(driver);
        myStoreShopAdresses.addFirstAdress();
    }

    @When("^I enter new address  alias (.+), address (.+), postal code (.+), City (.+), phone (.+), country$")
    public void iEnterNewAddressAliasAliasAddressAddressPostalCodePostalCodeCityCityPhonePhoneCountry(String alias, String address, String city, String postalCode, String phoneNumber) {
        MyStoreShopAdresses adresses = new MyStoreShopAdresses(driver);
        adresses.enterNewAddressData(alias,address,city,postalCode,phoneNumber);
    }
    @Then("^Then the first one should contain (.+)$")
    public void thenTheFirstOneShouldContainAliasAddressPostalCodeCityPhone() {
    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
    }


    @And("I remove the address")
    public void iRemoveTheAddress() {
    }

    @And("I can see the address was removed")
    public void iCanSeeTheAddressWasRemoved() {
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }

}