package pro.sky.java.course_2_core.hw_2_7_emplbook.exceptions;

import pro.sky.java.course_2_core.hw_2_7_emplbook.model.Employee;

public class EmployeeNotFoundException extends EmployeeException {
    public EmployeeNotFoundException(Employee employee) {
        super(employee);
    }

    @Override
    public String getMessage() {
        return "Employee with the name " + getEmployeeName() + " is not listed in the register.";
    }
}
