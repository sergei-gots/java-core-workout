package pro.sky.java.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pro.sky.java.employee.util.EmployeeValidator;
import pro.sky.java.employee.util.PersonValidator;

import java.text.DecimalFormat;
import java.util.Objects;


public class Person {
    private static int nextId;
    private final int id;
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        id = ++nextId;
        this.firstName = PersonValidator.validateName(firstName);
        this.lastName = PersonValidator.validateName(lastName);
    }

    public Person(String firstName, String lastName, int departmentId, double salary) {
        this(firstName, lastName);
        EmployeeValidator.validateSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }



    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName;
    }


    public String getName() {
        return firstName + " " + lastName;
    }


    @JsonIgnore
    public String getKey() {
        return firstName + lastName;
    }

}
