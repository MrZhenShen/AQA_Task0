package tasks.task_2;

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        try {
            if (b == 0) throw new MyArithmeticException();
        } catch (MyArithmeticException e) {
            e.printStackTrace();
            return 0;
        }
        return (double) a / b;
    }
}

