package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main02 {
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver",
//                "src/main/resources/drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://hotel-testlab.coderslab.pl/en/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement location = driver.findElement(By.name("hotel_location"));
//        location.sendKeys("Warszawa");
//        WebElement searchNow = driver.findElement(By.name("search_room_submit"));
//        searchNow.click();
//        WebElement emailList = driver.findElement(By.name("newsletter-input"));
//        emailList.sendKeys("asdasda9.test@test.com");
//        WebElement subscribe = driver.findElement(By.name("submitNewsletter"));
//        subscribe.submit();

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://hotel-testlab.coderslab.pl/en/");

            WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
            WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
            WebElement newsletterInput = driver.findElement(By.name("email"));
            WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));

            hotelLocationInput.sendKeys("Warsaw");
            newsletterInput.sendKeys("test@test.com");
            //searchNowButton.submit();
            searchNowButton.click();

            driver.quit();


    }
}
