package pro.sky.java.employee.model;

import java.util.Objects;


public class Person {
    private static int nextId;
    private int id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        id = ++nextId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        id = ++nextId;
    }

    protected Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getId() {
        return id;
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
        //return id == (person.id);
       return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
     //   return Objects.hash(id);
       return Objects.hash(firstName, lastName);

    }

    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName;
    }


    public String getName() {
        return firstName + " " + lastName;
    }

    protected void updateWith(Person person) {
        this.firstName = person.firstName;
        this.lastName = person.lastName;
    }
}
