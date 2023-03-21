package Java;

import java.util.Arrays;

public class Calculator {
    public String[] operationsHistory;

    public Calculator() {
        this.operationsHistory = new String[0];
    }

    public int add(int num1, int num2) {
        int result = num1 + num2;
        this.operationsHistory = Arrays.copyOf(operationsHistory, operationsHistory.length + 1);
        this.operationsHistory[operationsHistory.length - 1] = "added " + num1 + " to " + num2 + " got " + result;
        return result;

    }

    public int multiply(int num1, int num2) {
        int result = num1 * num2;
        this.operationsHistory = Arrays.copyOf(operationsHistory, operationsHistory.length + 1);
        this.operationsHistory[operationsHistory.length - 1] = "multiply " + num1 + " with  " + num2 + " got " + result;
        return result;

    }

    public int subtract(int num1, int num2) {
        int result = num1 - num2;
        this.operationsHistory = Arrays.copyOf(operationsHistory, operationsHistory.length + 1);
        this.operationsHistory[operationsHistory.length - 1] = "subtract " + num1 + " from   " + num2 + " got " + result;
        return result;
    }

    public int divide(int num1, int num2) {
        if ( num2 == 0) {
            throw new ArithmeticException("Nie mozna dzielic przez 0");
        }
        int result = num1 / num2;
        this.operationsHistory = Arrays.copyOf(operationsHistory, operationsHistory.length + 1);
        this.operationsHistory[operationsHistory.length - 1] = "divide " + num1 + " by    " + num2 + " got " + result;
        return result;

    }

    public void printOperations() {
        System.out.println(Arrays.toString(this.operationsHistory));
    }

    public void clearOperations() {
        operationsHistory = new String[0];
    }
}