package pro.sky.java.employee.exceptions;

import pro.sky.java.employee.model.Person;

public class EmployeeNotFoundException extends EmployeeException {
    public EmployeeNotFoundException(Person person) {
        super(person);
    }

    @Override
    public String getMessage() {
        return "Employee with the name " + getEmployeeName() + " is not listed in the register.";
    }
}
