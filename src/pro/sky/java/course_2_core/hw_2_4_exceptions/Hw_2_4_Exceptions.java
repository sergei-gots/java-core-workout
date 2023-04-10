package pro.sky.java.course_2_core.hw_2_4_exceptions;

import pro.sky.java.course_2_core.hw_2_4_exceptions.credential.exceptions.WrongLoginException;
import pro.sky.java.course_2_core.hw_2_4_exceptions.credential.exceptions.WrongPasswordException;
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
        validate(login, password, confirmPassword);

        confirmPassword = confirmPassword.substring(0,confirmPassword.length()-1);
        validate(login, password, confirmPassword);

        password = ValidatorService.generatateWrongByLengthTestPassword();
        validate(login, password, confirmPassword);

        password = ValidatorService.generatateWrongByContentTestPassword();
        validate(login, password, confirmPassword);

        login = ValidatorService.generatateWrongByLengthTestLogin();
        validate(login, password, confirmPassword);

        login = ValidatorService.generatateWrongByContentTestLogin();
        validate(login, password, confirmPassword);

        login = ValidatorService.generatateCorrectTestLogin();
        password = ValidatorService.generatateCorrectTestPassword();
        confirmPassword = password;
        validate(login, password, confirmPassword);




    }

    private void validate(String login, String password, String confirmPassword) {
        try {
            System.out.println("ValidatorService.validate(login, password, confirm_password) = "
                    + ValidatorService.validate(login, password, confirmPassword));
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println("Exception " + e.getClass().getSimpleName() + " was thrown");
            System.out.println("e.getMessage() = \"" + e.getMessage() + "\"");
        }
    }
}
