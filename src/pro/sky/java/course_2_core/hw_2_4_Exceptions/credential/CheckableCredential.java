package pro.sky.java.course_2_core.hw_2_4_Exceptions.credential;

public interface CheckableCredential {
    /**
     *  throws some uncheckable Exception if length is not valid.
     */
    void checkLength();
    /**
     *  throws some uncheckable Exception if credential contains not allowed symbols.
     */
    void checkContent();

    /**
     *  throws implementing class-dependent Wrong Credential Exception
     */
    void throwWrongCredentialException(String message);
}
