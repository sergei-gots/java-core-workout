package pro.sky.java.course_2_core.hw_2_4_Exceptions.credential;

/**
 * The end-implementations of this class should have descriptive names like "Login", "Password", etc.
 * because the name of a class will be used for description purpose in output.
 */
public abstract class LoginCredential implements CheckableCredential {
    public static final String ALLOWED_CHARACTERS_REG_EXP = "[a-z]|[A-Z]|";
    public static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY_1234567890";
    private String value;
    public String getValue() {
        return value;
    }

    public LoginCredential(String value) {
        if (value == null || value.isBlank()) {
            throwWrongCredentialException(this.getClass().getSimpleName() + " is not defined.");
        }
        this.value = value;
        checkLength();
        checkContent();
    }

    @Override
    public void checkContent() {
        for (int i = 0; i < value.length(); i++) {
            if(!ALLOWED_CHARACTERS.contains(value.subSequence(i, i+1))) {
                throwWrongCredentialException(this.getClass().getSimpleName() + " contains not allowed symbols.");
            }
        }
    }
}
