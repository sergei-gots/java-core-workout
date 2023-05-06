package pro.sky.java.employee.model.util;

import org.apache.commons.lang3.StringUtils;
import pro.sky.java.employee.exceptions.IncorrectNameException;
import pro.sky.java.employee.exceptions.IncorrectSurnameException;


public class PersonValidator {

    public String validateName(String name) {
        if(!StringUtils.isAlpha(name)) {
            throw new IncorrectNameException(name);
        }
        return StringUtils.capitalize(name);
    }
    public String validateSurname(String surname) {
        if(!StringUtils.isAlpha(StringUtils.remove(surname, '-'))) {
            throw new IncorrectSurnameException(surname);
        }
        return StringUtils.capitalize(surname);
    }
}
