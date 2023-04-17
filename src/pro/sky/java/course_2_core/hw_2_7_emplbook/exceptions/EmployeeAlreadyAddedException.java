package pro.sky.java.course_2_core.hw_2_7_emplbook.exceptions;

import pro.sky.java.course_2_core.hw_2_7_emplbook.model.Employee;

public class EmployeeAlreadyAddedException extends EmployeeException {
    public EmployeeAlreadyAddedException(Employee employee) {
        super(employee);
    }

    @Override
    public String getMessage() {
        return "Employee with the name " + getEmployeeName() + " does already exist in the register.";
    }
}
