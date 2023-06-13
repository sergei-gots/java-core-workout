package pro.sky.java.employee.exceptions;

public class EmployeeAlreadyAddedException extends EmployeeException {
    public EmployeeAlreadyAddedException(int employeeId) {
        super(employeeId);
    }

    @Override
    public String getMessage() {
        return "Employee with the name " + getEmployeeId() + " does already exist in the register.";
    }
}
