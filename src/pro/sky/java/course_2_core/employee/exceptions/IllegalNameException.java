package pro.sky.java.course_2_core.employee.exceptions;


public  class IllegalNameException extends IllegalArgumentException {

    private final String name;
    public IllegalNameException(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "Name=\"" + name + "\" should contain only letters.";
    }
}