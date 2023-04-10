package pro.sky.java.course_2_core.hw_2_4_exceptions;

import pro.sky.java.course_2_core.hw_2_4_exceptions.credential.exceptions.WrongLoginException;
import pro.sky.java.course_2_core.hw_2_4_exceptions.credential.exceptions.WrongPasswordException;
import pro.sky.java.util.BasicService;
import pro.sky.java.util.Homework;

public class Hw_2_4_Exceptions implements Homework {

    public static void main(String[] args) {
        new Hw_2_4_Exceptions().homework();
    }

    @Override
    public void homework() {
        System.out.println("\nHomework #2.4. Exceptions. Task \"Login credentials\"\n");

        String login;
        String password;
        String confirmPassword;

        login = ValidatorService.generatateCorrectTestLogin();
        password = ValidatorService.generatateCorrectTestPassword();
        confirmPassword = password;
        BasicService.printHeader("Case #1. Everything is correct.");
        validate(login, password, confirmPassword);

        BasicService.printHeader("Case #2. ConfirmPassword isn't equal to the Password.");
        confirmPassword = confirmPassword.substring(0,confirmPassword.length()-1);
        validate(login, password, confirmPassword);

        BasicService.printHeader("Case #3. Password has exceed length.");
        password = ValidatorService.generatateWrongByLengthTestPassword();
        validate(login, password, confirmPassword);

        BasicService.printHeader("Case #4. Password contains non allowed symbols.");
        password = ValidatorService.generatatePresumablyWrongByContentTestPassword();
        validate(login, password, confirmPassword);

        BasicService.printHeader("Case #5. Login has exceed length.");
        login = ValidatorService.generatateWrongByLengthTestLogin();
        validate(login, password, confirmPassword);

        BasicService.printHeader("Case #6. Login contains non allowed symbols.");
        login = ValidatorService.generatatePresumablyWrongByContentTestLogin();
        validate(login, password, confirmPassword);

        BasicService.printHeader("Case #7. Everything is ok again.");
        login = ValidatorService.generatateCorrectTestLogin();
        password = ValidatorService.generatateCorrectTestPassword();
        confirmPassword = password;
        validate(login, password, confirmPassword);




    }

    private void validate(String login, String password, String confirmPassword) {
        try {
            System.out.println("ValidatorService.validate(login=\"" + login + "\", password=\""
                    + password + "\", confirm_password=\"" + confirmPassword + "\") = "
                    + ValidatorService.validate(login, password, confirmPassword));
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println("Exception " + e.getClass().getSimpleName() + " was thrown");
            System.out.println("e.getMessage() = \"" + e.getMessage() + "\"");
        }
    }
}
