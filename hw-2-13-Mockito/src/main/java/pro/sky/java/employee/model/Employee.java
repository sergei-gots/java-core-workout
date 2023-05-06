package pro.sky.java.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;


/**
 * Class Employee, который содержит информацию о Ф.И.О.,
 * отделе и зарплате сотрудника.
 * Отделы для простоты должны быть названы от 1 до 5.
 **/
public class Employee extends Person {
    public static final double MIN_ALLOWED_SALARY = 100_000;
    private static final DecimalFormat salaryFormat = new DecimalFormat("###,###,##0.00");
    private int departmentId;
    private double salary;

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Employee(String firstName, String lastName, int departmentId, double salary) {
        super(firstName, lastName);
        this.departmentId = departmentId;
        this.salary = salary;
    }
    public static String formatSalary(double salary) {
        return salaryFormat.format(salary) + " руб.";
    }



    @Override
    public String toString() {
        return super.toString() +  ": " + departmentId + "-й отдел, зарплата: " + formatSalary(salary);
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

    public Employee copy() {
        return new Employee(getFirstName(), getLastName(), departmentId, salary);
    }
}
