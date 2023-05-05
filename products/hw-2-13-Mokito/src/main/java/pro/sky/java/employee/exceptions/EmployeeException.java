package pro.sky.java.employee.exceptions;

import pro.sky.java.employee.model.Employee;

public abstract class EmployeeException extends RuntimeException {
    private final Employee employee;
    public EmployeeException(Employee employee) {
        super();
        this.employee = employee;
    }

    public String getEmployeeName() {
        return "<b>" + employee.getName() + "</b>";
    }

    @Override
    public abstract String getMessage();

}