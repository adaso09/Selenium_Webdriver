package Java;



import java.util.NoSuchElementException;

public class Exception {

    public static void main(String[] args) {
        int[] elements = {1, 2, 4, 56, 74, 2, 421, 23, 42};
        int value = 57;
        try {
            System.out.println(indexOf(elements, value));
        } catch (NoSuchElementException e) {
            System.out.println("Wartos nie wystepuje");
        }
    }

    public static int indexOf(int[] elements, int value) {
        int testIndexu = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                testIndexu = i;
                break;
            }
        }
        if (testIndexu == -1) {
            throw new NoSuchElementException();
        }
        return testIndexu;
    }
}
