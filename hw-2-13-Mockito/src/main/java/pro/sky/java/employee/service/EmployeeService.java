package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    void add(Collection<Employee> employees);

    void add(Employee employee);

    void edit(Employee employee);

    Employee remove(int id);

    Employee get(int id);

    Collection<Employee> getAll();

    Collection<Employee> getEmployeesWithSalaryHigherThan(double salary);
}
