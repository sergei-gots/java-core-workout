package pro.sky.java.employee.exceptions;

public abstract class EmployeeException extends RuntimeException  {
    private final int employeeId;
    public EmployeeException() {
        super();
        this.employeeId = -1;
    }
    public EmployeeException(int employeeId) {
        super();
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return "<b>" + employeeId + "</b>";
    }

}