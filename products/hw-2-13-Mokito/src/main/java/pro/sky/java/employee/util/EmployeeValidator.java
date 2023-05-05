package pro.sky.java.employee.util;

import org.apache.commons.lang3.StringUtils;
import pro.sky.java.employee.exceptions.DepartmentIsNotListedException;
import pro.sky.java.employee.exceptions.IllegalNameException;
import pro.sky.java.employee.exceptions.SalaryIsTooLowException;

import static pro.sky.java.employee.model.Employee.MIN_ALLOWED_SALARY;
import static pro.sky.java.employee.util.EmployeeUtils.DEPARTMENT_COUNT;

public class EmployeeValidator {
    public static void validateDepartment(int departmentId) {
        if (departmentId < 1 || departmentId > DEPARTMENT_COUNT) {
            throw new DepartmentIsNotListedException(departmentId);
        }
    }

    public static String validateName(String name) {
        if(!StringUtils.isAlpha(name)) {
            throw new IllegalNameException(name);
        }
        return StringUtils.capitalize(name);
    }

    public static void validateSalary(double salary) {
        if (salary <= MIN_ALLOWED_SALARY) {
            throw new SalaryIsTooLowException();
        }
    }

}
