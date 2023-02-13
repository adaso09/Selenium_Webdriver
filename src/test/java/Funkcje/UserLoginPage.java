package Funkcje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserLoginPage {
    private static WebDriver driver;

    public  UserLoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void loginInputed(String email, String password) {
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.click();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        signInButton.click();

    }
    public void hotelSearch(String hotel){
        WebElement backToMain = driver.findElement(By.id("header_logo"));
        backToMain.click();
        WebElement hotelLocation = driver.findElement(By.name("hotel_location"));
        hotelLocation.click();
        hotelLocation.sendKeys(hotel);
        WebElement selectHotel = driver.findElement(By.id("hotel_cat_name"));
        selectHotel.click();
        WebElement selecHotelName =driver.findElement(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li"));
        selecHotelName.click();
        WebElement checkInData = driver.findElement(By.name("check_in_time"));
        checkInData.click();
        WebElement selectData = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[1]/a"));
        selectData.click();
        WebElement checkOutData = driver.findElement(By.name("check_out_time"));
        checkOutData.click();
        WebElement selectDataOut = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]/a"));
        selectDataOut.click();

        WebElement searchNow = driver.findElement(By.name("search_room_submit"));
        searchNow.click();

    }
    public void bookHotel(){
        WebElement addCart = driver.findElement(By.name("qty_9"));
        WebElement bookNow = driver.findElement(By.xpath("//*[@id=\"category_data_cont\"]/div[2]/div/div[2]/a/span"));
    WebElement proceedToChecout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/a"));
    addCart.sendKeys("5");
    bookNow.click();
    proceedToChecout.click();
    }
    public  void  shoopingCart(){
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[4]/div/a"));
        cart.click();
    }
    public String getHotelName() {
        WebElement hotelname = driver.findElement(By.xpath("//*[@id=\"cart_summary\"]/tbody/tr/td[2]/p"));
        return hotelname.getText();
    }
    public String getRoomBook(){
        WebElement roomSuccessfulllAdded = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
        return roomSuccessfulllAdded.getText();
    }
    public  String getOrderMyBook(){
        WebElement myBook = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p[1]"));
        return myBook.getText();
    }

}

