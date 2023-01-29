package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // max okno
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.google.com"); //przechodzimy do strony google
        WebElement acceptCookiesButton = driver.findElement(By.id("L2AGLb")); // akceptacja cookies
        acceptCookiesButton.click(); // klikamy elemnet
        WebElement element = driver.findElement(By.name("q")); // lokalizujemy elemnt search bar
        element.clear(); //Wyczyść pole tekstowe.
        element.sendKeys("Coderslab"); //Wpisz tekst.
        element.submit(); //Wyślij formularz.
        driver.quit(); //Zamknięcie wszystkich okien przeglądarki.
    }
}
