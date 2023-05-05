package pro.sky.java.employee.exceptions;

import pro.sky.java.employee.model.Person;

public abstract class EmployeeException extends RuntimeException {
    private final Person person;
    public EmployeeException(Person person) {
        super();
        this.person = person;
    }

    public String getEmployeeName() {
        return "<b>" + person.getName() + "</b>";
    }

    @Override
    public abstract String getMessage();

}