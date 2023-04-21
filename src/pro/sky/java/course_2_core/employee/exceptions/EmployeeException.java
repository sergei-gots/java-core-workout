package pro.sky.java.course_2_core.employee.exceptions;

import pro.sky.java.course_2_core.employee.model.Employee;

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