package pro.sky.java.employee.model.util;

public class EmployeeKey {
    private final String firstName;
    private final String lastName;

    public EmployeeKey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getKey() {
        return firstName + lastName;
    }
}
