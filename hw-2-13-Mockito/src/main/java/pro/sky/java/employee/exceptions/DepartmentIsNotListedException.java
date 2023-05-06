package pro.sky.java.employee.exceptions;

public class DepartmentIsNotListedException extends IllegalArgumentException{
    private int departmentId;

    public DepartmentIsNotListedException(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String getMessage() {
        return "Department with number " + departmentId + " is not listed.";
    }
}
