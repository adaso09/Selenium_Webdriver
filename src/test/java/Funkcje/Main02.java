package Funkcje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement login = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a"));
        login.click();
        // rejestracja
        WebElement signInLink = driver.findElement(By.className("user_login"));
        signInLink.click();
        WebElement emailInput = driver.findElement(By.className("account_input"));
        // Tworzenie randomowego @.
        emailInput.sendKeys(RandomString.generateRandomEmail());
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.submit();
        // Brakuje tablicy do zapisywania tworzonego @ i hasla.
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id=\"passwd\"]"));
        WebElement registerButton = driver.findElement(By.xpath("//button[@id=\"submitAccount\"]"));

        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Lennon");
        // Randomowe haslo - potrzeba tablicy
        passwordInput.sendKeys(RandomPassword.generateRandomPassword());
        registerButton.isDisplayed();
        if(registerButton.isDisplayed()){  // sprawdzamy czy registerButton jest widoczny
            registerButton.click();
        }
//        // logowanie
//        WebElement emailLogin = driver.findElement(By.id("email"));
//        WebElement password = driver.findElement(By.id("passwd"));
//        WebElement subbmitLogin = driver.findElement(By.id("SubmitLogin"));
//
//        emailLogin.sendKeys(new CharSequence[]{(CharSequence) emailInput});
//        password.sendKeys("smoczek0");
//        subbmitLogin.click();
        // zmiana danych
        WebElement myPersonalInfo = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[5]/a/span"));
        myPersonalInfo.click();
        WebElement gender = driver.findElement(By.id("uniform-id_gender1"));
        WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement lastName = driver.findElement(By.name("lastname"));
        WebElement emialChnage = driver.findElement(By.name("email"));
        WebElement passwordchnage = driver.findElement(By.name("old_passwd"));
        WebElement passwordNew = driver.findElement(By.name("passwd"));
        WebElement passwordConfirm = driver.findElement(By.name("confirmation"));
        WebElement subbmitKey = driver.findElement(By.name("submitIdentity"));

        gender.click();
        firstName.clear();
        firstName.sendKeys("Antek");
        lastName.clear();
        lastName.sendKeys("Smoczek");
        emialChnage.clear();
        emialChnage.sendKeys(RandomString.generateRandomEmail());
        passwordchnage.click();
        passwordchnage.sendKeys(SaveDates.copyPassword());
        passwordNew.sendKeys("smoczek0");
        passwordConfirm.sendKeys("smoczek0");
        subbmitKey.click();
        WebElement returnWeb = driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img"));
        returnWeb.click();

        // Booking hotel
       // WebElement hotelLocation = driver.findElement(By.id("hotel_location"));
      //  WebElement selectHotel = driver.findElement(By.id("hotel_cat_name"));
       // WebElement hotelParadis = driver.findElement(By.id("14"));
        WebElement chceckData = driver.findElement(By.id("check_in_time"));
        WebElement movePath = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));
        WebElement selectDataIn = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[5]/a"));
        WebElement selectDataOut = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[7]/a"));
        WebElement searchNow = driver.findElement(By.name("search_room_submit"));

       // hotelLocation.sendKeys("Katowice");
       // selectHotel.click();
       // hotelParadis.click();
        chceckData.click();
        movePath.click();
        selectDataIn.click();
        selectDataOut.click();
        searchNow.click();

        WebElement sortByRating = driver.findElement(By.id("gst_rating"));
        sortByRating.click();
        WebElement sorted1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[1]/div[2]/div/ul/li[1]/a"));
        WebElement sorted2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[1]/div[2]/div/ul/li[2]/a"));
        sorted1.click();
        sorted2.click();

        //testy
//        WebElement backToAccont = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a"));
//        backToAccont.click();
//        WebElement myAdress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[4]/a/i"));
//        myAdress.click();
//        WebElement newAdress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/a"));
//        newAdress.click();

    }
}
