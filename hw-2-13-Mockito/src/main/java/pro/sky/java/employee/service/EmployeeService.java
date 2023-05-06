package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departmentId, double salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    List<Employee> getAll();
}
