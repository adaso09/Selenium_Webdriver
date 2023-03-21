package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main01_cnd {
    private static WebDriver driver;
    public  Main01_cnd(WebDriver driver) {
        this.driver = driver;
    }
    public void loginUser(){
        WebElement singInBuuton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        singInBuuton.click();
        WebElement noAccount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        noAccount.click();
        WebElement returnMyStore = driver.findElement(By.xpath("//*[@id=\"_desktop_logo\"]/a/img"));
        returnMyStore.click();
    }
   // public String getName(){
       // WebElement getNameOf = driver.findElement(By.xpath("//*[@id=\"_desktop_logo\"]/h1/a/img"));
      // return getNameOf.getText();
//    }


}
