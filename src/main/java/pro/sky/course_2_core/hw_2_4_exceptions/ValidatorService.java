package pro.sky.course_2_core.hw_2_4_exceptions;

import pro.sky.course_2_core.hw_2_4_exceptions.credential.Login;
import pro.sky.course_2_core.hw_2_4_exceptions.credential.LoginCredential;
import pro.sky.course_2_core.hw_2_4_exceptions.credential.Password;
import pro.sky.util.BasicService;

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
        return 1 + RANDOM.nextInt(maxLength-1);
    }

    public static String generatateCorrectTestLogin() {
        return generateCorrectContent(generateNonZeroCredentialLength(Login.MAX_LENGTH));
    }


    public static String generatateWrongByLengthTestLogin() {
        return generateCorrectContent(Login.MAX_LENGTH + generateNonZeroCredentialLength(10));
    }

    public static String generatatePresumablyWrongByContentTestLogin() {
        return generatePresumablyWrongContent(generateNonZeroCredentialLength(Login.MAX_LENGTH));
    }


    public static String generatateCorrectTestPassword() {
        return generateCorrectContent(generateNonZeroCredentialLength(Password.MAX_LENGTH));
    }

    public static String generatateWrongByLengthTestPassword() {
        return generateCorrectContent(Password.MAX_LENGTH) + generateNonZeroCredentialLength(10);
    }

    public static String generatatePresumablyWrongByContentTestPassword() {
        return generatePresumablyWrongContent(generateNonZeroCredentialLength(Password.MAX_LENGTH));
    }

    private static String generateCorrectContent(int length) {
        char[] credential = new char[length];
        for (int i = 0; i < length; i++) {
            credential[i] = LoginCredential.ALLOWED_CHARACTERS.charAt(
                    RANDOM.nextInt(LoginCredential.ALLOWED_CHARACTERS.length()));
        }
        return new String(credential);

    }

    private static String generatePresumablyWrongContent(int length) {
        int minCharValue = 33;
        int maxCharValue = 126;
        char[] credential = new char[length];
        for (int i = 0; i < length; i++) {
            credential[i] = (char) (minCharValue + RANDOM.nextInt(maxCharValue - minCharValue));
        }
        return new String(credential);
    }


}
