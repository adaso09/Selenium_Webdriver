package Zadania;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdressPage {


    private final WebDriver driver;


    @FindBy(className = "address-body")
    private List<WebElement> addresses;

    public AdressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean addresIsVisible() {
        return addresses.size() > 0;
    }

    public String getFirstAddressAsText() {
        WebElement update = driver.findElement(By.cssSelector("a[data-link-action='edit-address']"));
        update.click();
        String alias = driver.findElement(By.id("field-alias")).getAttribute("value");
        String addressText = driver.findElement(By.id("field-address1")).getAttribute("value");
        String city = driver.findElement(By.id("field-city")).getAttribute("value");
        String postalcode = driver.findElement(By.id("field-postcode")).getAttribute("value");
        String phone = driver.findElement(By.id("field-phone")).getAttribute("value");
        WebElement pushbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        pushbtn.click();
        return String.join("\n", alias, addressText, city, postalcode, phone);
    }

    public void removeTheAddress() {
        WebElement delete = driver.findElement(By.cssSelector("a[data-link-action='delete-address']"));
        delete.click();

    }
    public void removeAdressAsserction(){
        WebElement alertFail = driver.findElement(By.cssSelector("article[class='alert alert-danger']"));
        String alerted = "Could not delete the address since it is used in the shopping cart.";
        assertTrue(alertFail.isDisplayed());
        Assertions.assertEquals(alerted,alertFail.getText());
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        WebElement items = driver.findElement(By.cssSelector("h3[class='h3 product-title']"));
        items.click();
        WebElement addToCart = driver.findElement(By.cssSelector("button[class='btn btn-primary add-to-cart']"));
        addToCart.click();
        WebElement addToCart2 = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        addToCart2.click();
        WebElement addToCart3 = driver.findElement(By.cssSelector("div[class='text-sm-center']"));
        addToCart3.click();
        WebElement delete = driver.findElement(By.cssSelector("a[class='delete-address text-muted']"));
        delete.click();
        WebElement alertPass = driver.findElement(By.cssSelector("article[class='alert alert-success']"));
        assertTrue(alertPass.isDisplayed());
        String alerted2 = "Address successfully deleted!";
        Assertions.assertEquals(alerted2, alertPass.getText());

    }
    public void cleanCart(){
        WebElement cart = driver.findElement(By.cssSelector("a[class='remove-from-cart']"));
        cart.click();

    }


}
