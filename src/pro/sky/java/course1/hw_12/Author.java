package pro.sky.java.course1.hw_12;
public class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Utils.checkName(firstName);
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    public void setLastName(String lastName) {
        Utils.checkName(lastName);
        this.lastName = lastName;
    }
}
