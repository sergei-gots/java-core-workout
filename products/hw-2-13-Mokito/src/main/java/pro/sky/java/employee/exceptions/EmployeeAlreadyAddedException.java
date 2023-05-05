package pro.sky.java.employee.exceptions;

import pro.sky.java.employee.model.Employee;

public class EmployeeAlreadyAddedException extends EmployeeException {
    public EmployeeAlreadyAddedException(Employee employee) {
        super(employee);
    }

    @Override
    public String getMessage() {
        return "Employee with the name " + getEmployeeName() + " does already exist in the register.";
    }
}
