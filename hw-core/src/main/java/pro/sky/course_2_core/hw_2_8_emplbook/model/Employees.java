package pro.sky.course_2_core.hw_2_8_emplbook.model;

import pro.sky.course_2_core.employee.EmployeeUtils;
import pro.sky.course_2_core.employee.model.Employee;

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
