package pro.sky.java.employee.repository;

import pro.sky.java.employee.model.Employee;

import java.util.Collection;

public interface EmployeesRepository {
    void add(Employee employee);
    void edit(Employee employee);

    Employee remove(int i);

    Employee get(int i);

    Collection<Employee> getAll();

    int size();

    Collection<Employee> getEmployeesWithSalaryHigherThan(double salary);
}
