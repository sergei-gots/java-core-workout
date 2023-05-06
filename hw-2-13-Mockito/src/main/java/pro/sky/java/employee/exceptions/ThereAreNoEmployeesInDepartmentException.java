package pro.sky.java.employee.exceptions;

public class ThereAreNoEmployeesInDepartmentException extends RuntimeException {
    private  int departmentId;
    public ThereAreNoEmployeesInDepartmentException(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String getMessage() {
        return  "There are no employees in department #" + departmentId + ".";
    }
}
