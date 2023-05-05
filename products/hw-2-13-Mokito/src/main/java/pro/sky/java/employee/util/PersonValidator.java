package pro.sky.java.employee.util;

import org.apache.commons.lang3.StringUtils;
import pro.sky.java.employee.exceptions.IllegalNameException;

public class PersonValidator {

    public static String validateName(String name) {
        if(!StringUtils.isAlpha(name)) {
            throw new IllegalNameException(name);
        }
        return StringUtils.capitalize(name);
    }
}
