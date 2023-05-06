package pro.sky.java.employee.model.util;

import org.springframework.stereotype.Component;
import pro.sky.java.employee.exceptions.DepartmentIsNotListedException;
import pro.sky.java.employee.exceptions.SalaryIsTooLowException;

import static pro.sky.java.employee.model.Employee.MIN_ALLOWED_SALARY;
import static pro.sky.java.employee.util.EmployeeConstants.DEPARTMENT_COUNT;

@Component
public class EmployeeValidator extends PersonValidator {
    public int validateDepartment(int departmentId) {
        if (departmentId < 1 || departmentId > DEPARTMENT_COUNT) {
            throw new DepartmentIsNotListedException(departmentId);
        }
        return departmentId;
    }

    public double validateSalary(double salary) {
        if (salary < MIN_ALLOWED_SALARY) {
            throw new SalaryIsTooLowException();
        }
        return salary;
    }

}
