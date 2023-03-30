package Zadania;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ShopCart {
    private final WebDriver driver;
    @FindBy(name = "email")
    public WebElement loginInputElement;
    public ShopCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void loginAsUser(String email, String password) {
        loginInputElement.click();
        loginInputElement.clear();
        loginInputElement.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }
    public String getLoggedUser() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }

    public void sizeSelected() {
        WebElement size = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        size.click();
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"group_1\"]/option[2]")));
    }

    public void addQtyToCart() {
        WebElement size = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[class='material-icons touchspin-up']")));
        if (size.isSelected()) {
            for (int i = 1; i < 6; i++) {
                driver.findElement(By.cssSelector("i[class='material-icons touchspin-up']")).click();
            }
            // url rozmiar
        }
    }

    public void submit() {
        WebElement submitCart = driver.findElement(By.cssSelector("button[data-button-action='add-to-cart']"));
        submitCart.click();
    }
    public void checkbotClick() {
        WebElement termsOfServices = driver.findElement(By.cssSelector("input[name='conditions_to_approve[terms-and-conditions]']"));
        if (termsOfServices.isEnabled()) {
            termsOfServices.click();
        } else {
            Assert.fail();
        }
    }
    public void getPrice() {
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span[class='price']"),"$150.60"));
        WebElement price = driver.findElement(By.cssSelector("span[class='price']"));
        price.getText();
        System.out.println(price.getText());
    }
    public boolean chceckShiipment() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=my-account");
        WebElement history = driver.findElement(By.id("history-link"));
        history.click();
        WebElement detalis = driver.findElement(By.cssSelector("a[data-link-action='view-order-details']"));
        detalis.click();

        WebElement orderStatus = driver.findElement(By.cssSelector("span[class='label label-pill bright']"));
        WebElement orderPrice = driver.findElement(By.xpath("//*[@id=\"order-products\"]/tfoot/tr[4]/td[2]"));

        String prices = "€150.60";
        String statusAsText = "Awaiting check payment";
        Assertions.assertEquals(statusAsText, orderStatus.getText());
        Assertions.assertEquals(prices,orderPrice.getText());

        return true;
    }
}