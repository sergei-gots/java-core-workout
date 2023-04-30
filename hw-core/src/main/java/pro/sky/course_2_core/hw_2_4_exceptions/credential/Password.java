package pro.sky.course_2_core.hw_2_4_exceptions.credential;

import pro.sky.course_2_core.hw_2_4_exceptions.credential.exceptions.WrongPasswordException;

public class Password extends LoginCredential {
    public final static int MAX_LENGTH = 19;

    public Password(String value, String confirmedPassword) {
        super(value);
        if (!value.equals(confirmedPassword)) {
            throw new WrongPasswordException("Password and confirm-password aren't equal.");
        }
    }

    /**
     * throws WrongPasswordException when its length more than 20.
     */
    @Override
    public void checkLength() {
        if (getValue().length() > MAX_LENGTH) {
            throwWrongCredentialException("Length of password must be less than " + (MAX_LENGTH + 1) + ".");
        }
    }

    @Override
    public void throwWrongCredentialException(String message) {
        throw new WrongPasswordException(message);
    }


}
