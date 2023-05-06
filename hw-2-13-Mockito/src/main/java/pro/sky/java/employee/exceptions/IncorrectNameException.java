package pro.sky.java.employee.exceptions;


public  class IncorrectNameException extends IllegalArgumentException {

    private final String name;
    public IncorrectNameException(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "Name=\"" + name + "\" should contain only letters.";
    }
}