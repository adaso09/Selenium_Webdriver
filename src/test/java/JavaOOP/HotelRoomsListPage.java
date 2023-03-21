package JavaOOP;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelRoomsListPage {
    private final WebDriver driver;

    @FindBy(id = "center_column")
    private WebElement roomsPanel;

    @FindBy(className = "room_cont")
    private List<WebElement> roomsList;

    @FindBy(id = "hotel_cat_name")
    private WebElement searchHotelName;

    @FindBy(id = "check_in_time")
    private WebElement checkInSearchInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutSearchInput;

    public HotelRoomsListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean roomsListIsVisible() {
        return roomsPanel.isDisplayed();
    }

    public int roomsCount() {
        return roomsList.size();
    }

    public String getSearchedHotelName() {
        return searchHotelName.getText();
    }

    public String getSearchedCheckInDate() {
        return checkInSearchInput.getAttribute("value");
    }

    public String getSearchedCheckOutDate() {
        return checkOutSearchInput.getAttribute("value");
    }
}