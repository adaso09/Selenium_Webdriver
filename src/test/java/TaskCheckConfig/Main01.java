package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main01 {
//    public static void main(String[] args)  {
//        System.setProperty("webdriver.chrome.driver",
//                "src/main/resources/drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://hotel-testlab.coderslab.pl/en/");
//        driver.manage().window().fullscreen();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement idFind = driver.findElement(By.id("hotel_location"));
//        idFind.sendKeys("Warszawa");
//        idFind.click();
//        WebElement idSearchRom = driver.findElement(By.id("search_room_submit"));
//        idSearchRom.click();
//        WebElement emailList = driver.findElement(By.id("newsletter-input"));
//        emailList.click();
//        emailList.sendKeys("asos09.test@test.com");
//        WebElement klik = driver.findElement(By.name("submitNewsletter"));
//        klik.click();


        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://hotel-testlab.coderslab.pl/en/");

            WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
            WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
            WebElement newsletterInput = driver.findElement(By.id("newsletter-input"));

            hotelLocationInput.sendKeys("Warsaw");
            newsletterInput.sendKeys("test@test.com");
            driver.quit();
    }
}
