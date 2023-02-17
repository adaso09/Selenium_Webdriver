package Zadania.Zadania_Warsztatowe_01;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStoreSteps {
    MyStoreShopAdresses myStoreShopAdresses;
    SingInToMyStore singInToMyStore;
    private WebDriver driver;


    @Given("I go to login shop page")
    public void iGoToLoginShopPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");



    }

    @When("^I login using  email (.+) and password (.+)$")
    public void iLoginToShopUsingEmailAndPassword(String email, String password) {
        singInToMyStore.loginAsMain(email,password);
        Assertions.assertEquals("Karol Muczek", singInToMyStore.getLoggedUsername());
    }

    @And("I go to my Shop addresses page")
    public void iGoToMyShopAddressesPages() {
        myStoreShopAdresses.addAdresses();
    }

    @When("^I enter new address  alias (.+), address (.+), postal code (.+), City (.+), phone (.+)$")
    public void iEnterNewAddressAliasAddressPostalCodeCityPhoneCountry(String alias, String address, String postal, String City, String phone) {

        myStoreShopAdresses.enterNewAddressShopData(alias,address,postal,City,phone);
    }
    @Then("^the first one should contain (.*)$")
    public void theFirstOneShouldContainAliasAddressPostalCodeCityPhone(String expectedText) {
        System.out.println(expectedText);
    }

    @Then("I can see new shop address")
    public void iCanSeeShopNewAddress() {

      //  Assertions.assertEquals("Address successfully added!", myStoreShopAdresses.getAddressName());
    }


    @And("I remove the shop address")
    public void iRemoveTheShopAddress() {

        //cnd
    }

    @And("I can see the address was removed at file")
    public void iCanSeeTheAddressWasRemoved() {

        //cnd
    }

    @And("I close the shop browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }


}

