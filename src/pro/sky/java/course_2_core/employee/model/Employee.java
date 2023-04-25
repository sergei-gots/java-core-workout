package pro.sky.java.course_2_core.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import pro.sky.java.course_2_core.employee.exceptions.IllegalNameException;

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

    public Employee(String firstName, String lastName) {
        id = ++nextId;
        this.firstName = validateName(firstName);
        this.lastName = validateName(lastName);
    }

    public Employee(String firstName, String lastName, int departmentId, double salary) {
        this(firstName, lastName);
        this.departmentId = departmentId;
        checkSalary(salary);
        this.salary = salary;
    }

    String validateName(String name) {
        if(!StringUtils.isAlpha(name)) {
            throw new IllegalNameException(name);
        }
        return StringUtils.capitalize(name);
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

    @JsonProperty("department")
    public int getDepartmentId() {
        return departmentId;
    }

    @JsonProperty("salary")
    public String getSalaryRub() {
        return formatSalary(salary);
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @JsonIgnore
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        checkSalary(salary);
        this.salary = salary;
    }

    @JsonIgnore
    public String getKey() {
        return firstName + lastName;
    }
}
