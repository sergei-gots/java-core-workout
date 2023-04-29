package pro.sky.course_2_core.hw_2_4_exceptions.credential.exceptions;

public class WrongPasswordException extends IllegalArgumentException {
    public WrongPasswordException(String s) {
        super(s);
    }
}
