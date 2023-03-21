package JavaOOP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelMainPage {

    private final WebDriver driver;

    @FindBy(className = "user_login")
    private WebElement signInBtn;
    @FindBy(name = "hotel_location")
    private WebElement hotelLocationInput;

    @FindBy(name = "check_in_time")
    private WebElement checkInDateInput;

    @FindBy(name = "check_out_time")
    private WebElement checkOutDateInput;

    @FindBy(css = "button.header-rmsearch-input")
    private WebElement selectHotelBtn;

    @FindBy(css = ".hotel_dropdown_ul .hotel_name")
    private List<WebElement> hotelList;
    @FindBy(id = "search_room_submit")
    private WebElement searchRoomsSubmitBtn;

    public HotelMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn() {
        signInBtn.click();
    }

    public HotelAuthPage signInWithPage() {
        signInBtn.click();
        return new HotelAuthPage(driver);
    }

    public void enterHotelLocation(String location) {
        hotelLocationInput.clear();
        hotelLocationInput.sendKeys(location);
    }

    public void enterCheckInDate(String date) {
        checkInDateInput.clear();
        checkInDateInput.sendKeys(date);
    }

    public void enterCheckOutDate(String date) {
        checkOutDateInput.clear();
        checkOutDateInput.sendKeys(date);
    }

    public String selectHotel() {
        selectHotelBtn.click();
        WebElement hotel = hotelList.get(0);
        String hotelName = hotel.getText();
        hotel.click();
        return hotelName;
    }

    public HotelRoomsListPage searchRooms() {
        searchRoomsSubmitBtn.click();
        return new HotelRoomsListPage(driver);

    }
}