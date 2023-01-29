package Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main03 {  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver",
            "src/main/resources/drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://javastart.pl/");
  //  driver.wait(2000);
    driver.get("https://www.samouczekprogramisty.pl/metody-w-jezyku-java/");
   /// driver.wait(2000);
    driver.navigate().back();
    driver.get("https://www.google.pl/");
    //driver.wait(2000);
    WebElement accpetCookies =driver.findElement(By.id("L2AGLb"));
    accpetCookies.click();
    WebElement findElemt = driver.findElement(By.name("q"));
    findElemt.clear();
    findElemt.sendKeys("https://www.youtube.com/watch?v=VywxIQ2ZXw4");
    findElemt.submit();
    WebElement youtubeElemrnt = driver.findElement(By.className("cHaqb"));
    youtubeElemrnt.click();
    youtubeElemrnt.wait(2000);
    WebElement kilkAll = driver.findElement(By.className("yt-spec-touch-feedback-shape__fill"));
    kilkAll.click();

    //driver.quit();

}

}
