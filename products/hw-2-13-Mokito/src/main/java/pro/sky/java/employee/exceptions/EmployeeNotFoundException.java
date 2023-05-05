package pro.sky.java.employee.exceptions;

import pro.sky.java.employee.model.Employee;

public class EmployeeNotFoundException extends EmployeeException {
    public EmployeeNotFoundException(Employee employee) {
        super(employee);
    }

    @Override
    public String getMessage() {
        return "Employee with the name " + getEmployeeName() + " is not listed in the register.";
    }
}
