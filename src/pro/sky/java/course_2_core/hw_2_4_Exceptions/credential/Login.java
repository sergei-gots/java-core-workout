package pro.sky.java.course_2_core.hw_2_4_Exceptions.credential;

import pro.sky.java.course_2_core.hw_2_4_Exceptions.credential.exceptions.WrongLoginException;

public class Login extends LoginCredential {
    public final static int MAX_LENGTH = 20;

    public Login(String value) {
        super(value);
    }

    /**
     * throws WrongLoginException when its length more than 20.
     */
    @Override
    public void checkLength() {
        if (getValue().length() > MAX_LENGTH) {
            throw new WrongLoginException("Length of login must be less or equal " + MAX_LENGTH + ".");
        }
    }

    @Override
    public void throwWrongCredentialException(String message) {
        throw new WrongLoginException(message);
    }
}
