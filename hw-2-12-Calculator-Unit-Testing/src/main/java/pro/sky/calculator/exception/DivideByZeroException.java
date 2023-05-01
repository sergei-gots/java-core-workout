package pro.sky.calculator.exception;

public class DivideByZeroException extends IllegalArgumentException {
    public static final String DEFAULT_MESSAGE = "Division by 0  is not allowed.";
    public DivideByZeroException() {
        super(DEFAULT_MESSAGE);
    }
}
