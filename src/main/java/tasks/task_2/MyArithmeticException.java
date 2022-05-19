package tasks.task_2;

public class MyArithmeticException extends Exception {
    MyArithmeticException(String details) {
        super("MyArithmeticException" + details);
    }
    MyArithmeticException() {}
}
