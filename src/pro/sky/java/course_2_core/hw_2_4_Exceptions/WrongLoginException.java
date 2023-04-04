package pro.sky.java.course_2_core.hw_2_4_Exceptions;

public class WrongLoginException extends IllegalArgumentException {
    public WrongLoginException(String s) {
        super(s);
    }
}
