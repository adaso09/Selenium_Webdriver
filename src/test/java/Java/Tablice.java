package Java;

import java.util.Arrays;
import java.util.Random;

public class Tablice {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        int[] secoundNumbers = new int[10];
        int[] thirtNumbers = new int[10];

        Random r = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(101);
        }
        System.out.println("Pierwsza tablica");
        System.out.println(Arrays.toString(numbers));

        for (int j = 0; j < numbers.length; j++) {
            secoundNumbers[j] = r.nextInt(101);
        }
        System.out.println("Druga tablica");
        System.out.println(Arrays.toString(secoundNumbers));

        for( int a = 0; a < numbers.length; a ++){
            thirtNumbers[a] = numbers[a] + secoundNumbers[a];
        }
        System.out.println("Trzecia tablica");
        System.out.println(Arrays.toString(thirtNumbers));
    }
}
