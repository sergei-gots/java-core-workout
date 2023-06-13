package pro.sky.java.employee.exceptions;

public class DepartmentIsNotListedException extends EmployeeException {
    private final int departmentId;

    public DepartmentIsNotListedException(int departmentId) {
        super();
        this.departmentId = departmentId;
    }

    @Override
    public String getMessage() {
        return "Department with number " + departmentId + " is not listed.";
    }
}
