package Zadania;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class MyStoreOrderSteps {
    private WebDriver driver;

    @Given("I go to login shop")
    public void iGoToLoginShopPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
    }
    @When("I login to using  email {string} and password {string}")
    public void iLoginToUsingEmailAndPassword(String email, String password) {
        ShopCart shopCart = new ShopCart(driver);
        shopCart.loginAsUser(email, password);
        Assertions.assertEquals("Jon Smith", shopCart.getLoggedUser());
    }
    @And("I'm on shop main page")
    public void iMOnShopMainPage() {
        WebElement homePage = driver.findElement(By.cssSelector("img[class='logo img-fluid']"));
        homePage.click();
    }
    @And("I selected item {string} to cart")
    public void iSelectedItemToCart(String item) {
        WebElement items = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div[2]/article/div/div[2]/h3/a"));
        assertTrue(items.isDisplayed());
        Assertions.assertEquals(item, items.getText());
        items.click();
    }
    @And("I select Size M and Quantity")
    public void iSelectSizeMAndQuantity() {
        ShopCart shopCart = new ShopCart(driver);
        WebElement discount = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[2]"));
        String discounts = "SAVE 20%";
        Assertions.assertEquals(discounts, discount.getText());
        shopCart.sizeSelected();
        shopCart.addQtyToCart();
        shopCart.submit();
    }
    @Then("I add items to cart")
    public void iAddItemToCart() {
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        proceedToCheckout.click();
    }
    @And("I proceed to checkout to pay")
    public void iProceedToCheckoutToPay() {
        WebElement vauleCheck = driver.findElement(By.cssSelector("span[class='label js-subtotal']"));
        Assertions.assertEquals("5 items",vauleCheck.getText());
        WebElement submitItemToPayMethod = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        submitItemToPayMethod.click();
    }
    @And("I select Address,Shipping method and payment")
    public void iSelectAddressShippingMethodAndPayment() {
        ShopCart shopCart = new ShopCart(driver);
        WebElement addressSubmit = driver.findElement(By.name("confirm-addresses"));
        addressSubmit.click();
        WebElement prestaShopCarrier = driver.findElement(By.id("delivery_option_1"));
        prestaShopCarrier.isSelected();
        WebElement taxConfirmed = driver.findElement(By.name("confirmDeliveryOption"));
        taxConfirmed.click();
        WebElement payMethod = driver.findElement(By.id("payment-option-1"));
        payMethod.click();
        payMethod.isSelected();
        shopCart.checkbotClick();
        WebElement placerOderBtn = driver.findElement(By.cssSelector("button[class='btn btn-primary center-block']"));
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary center-block']")));
        if( placerOderBtn.isEnabled()){
            placerOderBtn.click();
        }else {
            Assert.fail();
        }
    }
    @And("I take ScreenShot to confirm my order")
    public void iTakeScreenShotToConfirmMyOrder() throws IOException {
        ShopCart shopCart = new ShopCart(driver);
        shopCart.getPrice();
        WebElement confimredOredr = driver.findElement(By.id("content-hook_order_confirmation"));
        String expectedOredr = "\uE876YOUR ORDER IS CONFIRMED\n" +
                "An email has been sent to the pastta@test.com address.";
        Assertions.assertEquals(expectedOredr, confimredOredr.getText());

     //  File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     //   FileUtils.copyFile(screen,new File(".\\screenshot\\screen.png"));
    }
    @And("I check my Order history and check status of order")
    public void iCheckMyOrderHistoryAndCheckStatusOfOrder() {
        ShopCart shopCart = new ShopCart(driver);
        Assertions.assertTrue(shopCart.chceckShiipment());
    }
    @And("I close the shop browsers")
    public void iCloseTheBrowser() {
        driver.manage().deleteAllCookies();
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        local.clear();
        driver.quit();
    }
}