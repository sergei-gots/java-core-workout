package pro.sky.java.employee.exceptions;

public class EmployeeNotFoundException extends EmployeeException {
    public EmployeeNotFoundException(int id) {
        super(id);
    }

    @Override
    public String getMessage() {
        return "Employee with the id " + getEmployeeId() + " is not listed in the register.";
    }
}
