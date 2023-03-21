package JavaOOP;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelLoginTest {
    private static WebDriver driver;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }

    @Test
    public void searchAvailableTest() {
        HotelAuthPage authPage = new HotelAuthPage(driver);
        HotelMyAccountPage myAccountPage = authPage.loginAs("test@test1676127274016.com", "superPass@");
        HotelMainPage mainPage = myAccountPage.goToHomePage();

        //Szukanie hotelu
        mainPage.enterHotelLocation("Poznan");
        String selectedHotel = mainPage.selectHotel();

        String checkInDate = LocalDate.now().format(dateTimeFormatter);
        mainPage.enterCheckInDate(checkInDate);

        String checkOutDate = LocalDate.now().plusDays(1).format(dateTimeFormatter);
        mainPage.enterCheckOutDate(checkOutDate);

        //Koszyk
        HotelRoomsListPage roomsListPage = mainPage.searchRooms();

        Assertions.assertTrue(roomsListPage.roomsListIsVisible());
        Assertions.assertTrue(roomsListPage.roomsCount() > 0);
        Assertions.assertEquals(checkInDate, roomsListPage.getSearchedCheckInDate());
        Assertions.assertEquals(checkOutDate, roomsListPage.getSearchedCheckOutDate());
        Assertions.assertEquals(selectedHotel, roomsListPage.getSearchedHotelName());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

