package pro.sky.java.employee.model;

import pro.sky.java.employee.util.SalaryFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Class Employee, который содержит информацию о Ф.И.О.,
 * отделе и зарплате сотрудника.
 * Отделы для простоты должны быть названы от 1 до 5.
 **/
public class Employee extends Person {
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public static final BigDecimal MIN_ALLOWED_SALARY = new BigDecimal(100_000);
    private int departmentId;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int departmentId) {
        super(firstName, lastName);
        this.departmentId = departmentId;
    }

    private Employee(int id, String firstName, String lastName,
                     int departmentId, BigDecimal salary) {
        super(id, firstName, lastName);
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Employee(String firstName, String lastName,
                    int departmentId, BigDecimal salary) {
        super(firstName, lastName);
        this.departmentId = departmentId;
        this.salary = salary.setScale(2, RoundingMode.HALF_EVEN);
    }
    public static String formatSalary(BigDecimal salary) {
        return SalaryFormatter.format(salary);
    }
    @Override
    public String toString() {
        return super.toString() +  ": " + departmentId + "-й отдел, зарплата: " + formatSalary(salary);
    }


    //@JsonProperty("department")
    public int getDepartmentId() {
        return departmentId;
    }

    //@JsonProperty("salary")
    public String getSalaryRub() {
        return formatSalary(salary);
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public Employee copy() {
        return new Employee(
                getId(),
                getFirstName(),
                getLastName(),
                departmentId,
                salary);
    }

    public void updateWith(Employee employee) {
        super.updateWith(employee);
        this.salary = employee.salary;
        this.departmentId = employee.departmentId;
    }
}
