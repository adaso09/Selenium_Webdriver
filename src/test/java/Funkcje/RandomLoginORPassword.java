package Funkcje;

import org.apache.commons.lang3.RandomStringUtils;


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
