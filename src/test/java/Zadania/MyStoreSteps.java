package Zadania;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import java.time.Duration;

public class MyStoreSteps {

    private   WebDriver driver;

    @Given("I go to login shop page")
    public void iGoToLoginShopPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
    }
    @When("I login using  email {string} and password {string}")
    public void iLoginToShopUsingEmailAndPassword(String email, String password) {
        SingInToMyStore singInToMyStore = new SingInToMyStore(driver);
        singInToMyStore.loginAsMain(email,password);
        Assertions.assertEquals("Jon Owen", singInToMyStore.getLoggedUsername());
        singInToMyStore.goToAdress();
    }
    @And("I go to my Shop addresses page")
    public void iGoToMyShopAddressesPages() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        // WebElement address = driver.findElement(By.cssSelector("a[id='addresses-link']"));
        //address.click();
        WebElement createNewAdress = driver.findElement(By.cssSelector("a[data-link-action ='add-address']"));
        createNewAdress.click();
    }
    @When("^I enter new address  alias (.+), address (.+), City (.+), postal code (.+), phone (.+)$")
    public void iEnterNewAddressAliasAddressPostalCodeCityPhoneCountry(String alias, String address, String City, String postal, String phone) {
        MyStoreShopAdresses myStoreShopAdresses = new MyStoreShopAdresses(driver);
        myStoreShopAdresses.enterNewAddressDataes(alias,address,postal,City,phone);
    }
    @Then("I can see new shop address")
    public void iCanSeeShopNewAddress() {
        AdressPage adressPage = new AdressPage(driver);
        Assertions.assertTrue(adressPage.addresIsVisible());
    }
    @And("^I verify created address (.+),(.+),(.+),(.+),(.+)$")
    public void iVerifyCreatedAddress(String alias, String address, String City, String postal, String phone) {
        AdressPage adressPage = new AdressPage(driver);
        String addressAsText = adressPage.getFirstAddressAsText();
        String expectedAddress = String.join("\n", alias, address,City,postal, phone);
        Assertions.assertEquals(expectedAddress, addressAsText);
    }
    @And("I remove the shop address")
    public void iRemoveTheShopAddress() {
        AdressPage adressPage = new AdressPage(driver);
        adressPage.removeTheAddress();
        adressPage.removeAdressAsserction();
        driver.navigate().back();
        driver.navigate().back();
        adressPage.cleanCart();
    }
    @And("I can see the address was removed at file")
    public void iCanSeeTheAddressWasRemoved() {
        AdressPage adressPage = new AdressPage(driver);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        Assertions.assertFalse(adressPage.addresIsVisible());
    }
    @And("I close the shop browser")
    public void iCloseTheBrowser() {
        driver.manage().deleteAllCookies();
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        local.clear();
        driver.quit();
    }
}