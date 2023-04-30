package pro.sky.course_2_core.employee.exceptions;

import pro.sky.course_2_core.employee.model.Employee;

public class EmployeeNotFoundException extends EmployeeException {
    public EmployeeNotFoundException(Employee employee) {
        super(employee);
    }

    @Override
    public String getMessage() {
        return "Employee with the name " + getEmployeeName() + " is not listed in the register.";
    }
}
