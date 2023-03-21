package Java;


public class Main1 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(2,5);
        calculator.multiply(6,5);
        calculator.divide(10,5);
        // calculator.divide(6,0);
        calculator.subtract(2,5);
        calculator.printOperations();
        calculator.clearOperations();
        calculator.printOperations();
        System.out.println(calculator);
    }
}
