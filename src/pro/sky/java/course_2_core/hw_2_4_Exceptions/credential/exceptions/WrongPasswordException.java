package pro.sky.java.course_2_core.hw_2_4_Exceptions.credential.exceptions;

public class WrongPasswordException extends IllegalArgumentException {
    public WrongPasswordException(String s) {
        super(s);
    }
}
