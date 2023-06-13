package pro.sky.java.employee.model.util;

import org.springframework.stereotype.Component;
import pro.sky.java.employee.exceptions.DepartmentIsNotListedException;
import pro.sky.java.employee.exceptions.SalaryIsTooLowException;
import pro.sky.java.employee.model.Employee;

import java.math.BigDecimal;

import static pro.sky.java.employee.model.Employee.MIN_ALLOWED_SALARY;
import static pro.sky.java.employee.util.EmployeeConstants.DEPARTMENT_COUNT;

@Component
public class EmployeeValidator extends PersonValidator {
    public void validateDepartment(int departmentId) {
        if (departmentId < 1 || departmentId > DEPARTMENT_COUNT) {
            throw new DepartmentIsNotListedException(departmentId);
        }
    }

    public void validateSalary(BigDecimal salary) {
        if (salary.compareTo(MIN_ALLOWED_SALARY) < 0) {
            throw new SalaryIsTooLowException();
        }
    }

    public void validateEmployee(Employee employee) {
        validateName(employee.getFirstName());
        validateSurname(employee.getLastName());
        validateDepartment(employee.getDepartmentId());
        validateSalary(employee.getSalary());
    }

}
