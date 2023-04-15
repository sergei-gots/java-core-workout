package pro.sky.java.course_2_core.hw_2_7_emplbook.model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Class Employee, который содержит информацию о Ф.И.О.,
 * отделе и зарплате сотрудника.
 * Отделы для простоты должны быть названы от 1 до 5.
 **/
public class Employee {
    private static final double MIN_ALLOWED_SALARY = 100_000;
    private static final DecimalFormat salaryFormat = new DecimalFormat("###,###,##0.00");
    private static int nextId;
    private final int id;
    private final String firstName;
    private final String lastName;
    private int departmentId;
    private double salary;

    public Employee(String firstName, String lastName, int departmentId, double salary) {
        id = ++nextId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        checkSalary(salary);
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
        id = ++nextId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static String formatSalary(double salary) {
        return salaryFormat.format(salary) + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    private void checkSalary(double salary) {
        if (salary <= MIN_ALLOWED_SALARY) {
            throw new IllegalArgumentException("Труд будущего сотрудника " + firstName + " " + lastName + " явно недооценен.");
        }
    }


    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName + ": " + departmentId + "-й отдел, зарплата: " + formatSalary(salary);
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getSalary() {
        return formatSalary(salary);
    }

    public String firstName() {
        return firstName;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double salary() {
        return salary;
    }

    public void setSalary(double salary) {
        checkSalary(salary);
        this.salary = salary;
    }

    public String key() {
        return firstName + lastName;
    }
}