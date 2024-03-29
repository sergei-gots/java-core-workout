package pro.sky.java.employee.exceptions;


public  class IncorrectSurnameException extends EmployeeException {

    private final String surname;
    public IncorrectSurnameException(String surname) {
        this.surname = surname;
    }

    public String getMessage() {
        return "Surname=\"" + surname + "\" should contain only letters.";
    }
}