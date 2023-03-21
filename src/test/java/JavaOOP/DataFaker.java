package JavaOOP;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataFaker {

    static final Faker faker = new Faker(new Locale("pl"));

    public static String createRandomEmail() {
        return String.format("test@test%s.com", System.currentTimeMillis());
    }

    public static String createRandomFirstName() {
        return faker.funnyName().name();
    }

    public static String createRandomLastName() {
        return faker.name().lastName();
    }

    public static String createRandomPassword() {
        Random r = new Random();
        int randomNumber = r.nextInt(0, 1001);
        return String.format("PAss%s%s", faker.dragonBall().character(), randomNumber);
    }

    public static String createRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String createRandomZip() {
        return faker.address().zipCode();
    }

    public static String createRandomCity() {
        return faker.address().cityName();
    }

    public static String createRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

}
