package pro.sky.calculator.exception;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("Division by 0  is not allowed.");
    }
}
