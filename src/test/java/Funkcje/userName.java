package Funkcje;

import java.util.*;
import java.nio.charset.*;

class RandomString {

    static String getAlphaNumericString(int n){

        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString = new String(array, Charset.forName("UTF-8"));

// tworzenie zmiennej
        StringBuffer r = new StringBuffer();

//tworzenie emaila
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }

        return r.toString() + "@test.com";
    }

    public static void main(String[] args)
    {
// rozmiar tablicy
        int n = 7;

        System.out.println(getAlphaNumericString(n));

    }
}


