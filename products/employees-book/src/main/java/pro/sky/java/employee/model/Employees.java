package pro.sky.java.employee.model;

import pro.sky.java.employee.util.EmployeeUtils;

import java.util.Map;


public class Employees {

    private static final Employees instance;

    private final Map<String, Employee> employees;

    static {
        instance = new Employees();
    }
    public static Employees getInstance() {
        return instance;
    }

    private Employees() {
        employees = EmployeeUtils.generateEmployees();
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }
}
