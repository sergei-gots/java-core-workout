package pro.sky.java.course_2_core.hw_2_4_exceptions;

import pro.sky.java.course_2_core.hw_2_4_exceptions.credential.Login;
import pro.sky.java.course_2_core.hw_2_4_exceptions.credential.LoginCredential;
import pro.sky.java.course_2_core.hw_2_4_exceptions.credential.Password;
import pro.sky.java.util.BasicService;

public class ValidatorService extends BasicService {

    private final static boolean TEST_PRINT_ALLOWED = true;

    private ValidatorService() {
    }

    public static void print(String login, String password, String confirmPassword) {
        if (!TEST_PRINT_ALLOWED) {
            return;
        }
        printHeader("Login credentials to validate:");
        System.out.println("login = " + login);
        System.out.println("password = " + password);
        System.out.println("confirmPassword = " + confirmPassword);
        printFooter();
    }

    public static boolean validate(String login, String password, String confirmPassword) {

        print(login, password, confirmPassword);
        new Login(login);
        new Password(password, confirmPassword);
        return true;

    }

    private static int generateNonZeroCredentialLength(int maxLength) {
        int l;
        do {
            l = RANDOM.nextInt(Login.MAX_LENGTH);
        } while (l == 0);
        return l;
    }

    public static String generatateCorrectTestLogin() {
        return generateCorrectContent(generateNonZeroCredentialLength(Login.MAX_LENGTH));
    }


    public static String generatateWrongByLengthTestLogin() {
        return generateCorrectContent(Login.MAX_LENGTH + generateNonZeroCredentialLength(10));
    }

    public static String generatateWrongByContentTestLogin() {
        return generatePresumablyWrongContent(generateNonZeroCredentialLength(Login.MAX_LENGTH));
    }


    public static String generatateCorrectTestPassword() {
        return generateCorrectContent(generateNonZeroCredentialLength(Password.MAX_LENGTH));
    }

    public static String generatateWrongByLengthTestPassword() {
        return generateCorrectContent(Password.MAX_LENGTH) + generateNonZeroCredentialLength(10);
    }

    public static String generatateWrongByContentTestPassword() {
        return generatePresumablyWrongContent(generateNonZeroCredentialLength(Password.MAX_LENGTH));
    }

    private static String generateCorrectContent(int length) {
        char[] credential = new char[length];
        for (int i = 0; i < length; i++) {
            credential[i] = LoginCredential.ALLOWED_CHARACTERS.charAt(
                    RANDOM.nextInt(LoginCredential.ALLOWED_CHARACTERS.length()));
        }
        System.out.println("credential = " + credential);
        return new String(credential);

    }

    private static String generatePresumablyWrongContent(int length) {
        int minCharValue = 33;
        int maxCharValue = 126;
        char[] credential = new char[length];
        for (int i = 0; i < length; i++) {
            credential[i] = (char) (minCharValue + RANDOM.nextInt(maxCharValue - minCharValue));
        }
        System.out.println("credential = " + credential);
        return new String(credential);
    }


}
