package Funkcje;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;


class RandomString {

    static String generateRandomEmail() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String email = "@test.com";
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers) + email;

        System.out.println(generatedString);
        return generatedString;
    }
}

    class RandomPassword {

        static String generateRandomPassword() {
            int length = 10;
            boolean useLetters = true;
            boolean useNumbers = false;
            String codes = "!";
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers) + codes;

            System.out.println(generatedString);
            return generatedString;
        }
    }
    class  SaveDates{

    static  String [] copyEamil(){
        Arrays.copyOf(new String[]{RandomString.generateRandomEmail()},0);
        System.out.println(copyEamil());
        return copyEamil();
    }
    static  String [] copyPassword(){
        Arrays.copyOf(new String[]{RandomPassword.generateRandomPassword()},0);
        return copyPassword();
    }
    }