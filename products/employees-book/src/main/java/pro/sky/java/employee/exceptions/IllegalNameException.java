package pro.sky.java.employee.exceptions;


public  class IllegalNameException extends IllegalArgumentException {

    private final String name;
    public IllegalNameException(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "Name=\"" + name + "\" should contain only letters.";
    }
}