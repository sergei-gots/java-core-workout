package pro.sky.course_2_core.hw_2_4_exceptions.credential.exceptions;

public class WrongLoginException extends IllegalArgumentException {
    public WrongLoginException(String s) {
        super(s);
    }
}
