package pro.sky.java.course_2_core.hw_2_4_Exceptions;

public class ValidatorService {
    private static final String ALLOWED_CHARACTERS = "[a-z]|[A-Z]|";
    private ValidatorService() {
    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) throws IllegalArgumentException{
        if(login == null || login.length() > 20) {
            throw new WrongLoginException("Length must be less or equal 20.");
        }
        if(password == null || password.length() > 20) {
            throw new WrongPasswordException("Length must be less or equal 20.");
        }
        if(!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Length of login must be less or equal 20.");
        }

        return check(login) && check(password);

    }

    private static boolean check(String s) {
        return s.matches("^\\w+$");
    }
}
