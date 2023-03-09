package pro.sky.java.course_1.cw_1;

import java.text.DecimalFormat;

/**
 * Class Employee, который содержит информацию о Ф.И.О.,
 * отделе и зарплате сотрудника.
 * Отделы для простоты должны быть названы от 1 до 5.
 **/
public class Employee {
    private static int nextId;
    private static final DecimalFormat salaryFormat = new DecimalFormat("###,###,##0.00");
    private final int id;
    private final String fullName;
    private int departmentId;
    private double salary;

    public Employee(String fullName, int departmentId, double salary) {
        id = ++nextId;
        this.fullName = fullName;
        this.departmentId = departmentId;
        checkSalary(salary);
        this.salary = salary;

    }

    public static String formatSalary(double salary) {
        return salaryFormat.format(salary) + " руб.";
    }

    private void checkSalary(double salary) {
        if (salary <= 100_000) {
            throw new IllegalArgumentException("Труд будущего сотрудника с Ф.И.О. " + fullName + " явно недооценен.");
        }
    }

    @Override
    public String toString() {
        return id + ". "
                + fullName + ": "
                + departmentId + "-й отдел, зарплата: "
                + formatSalary(salary);
    }

    public String getFormattedSalary() {
        return formatSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        checkSalary(salary);
        this.salary = salary;
    }

    /**
     * @return String contains all the information about employee except a department id.
     */
    public String toShortString() {
        return id + ". " + fullName + " Зарплата: " + getFormattedSalary();
    }
}
