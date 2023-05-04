package pro.sky.java.employee.repository;

import pro.sky.java.employee.model.Employee;

import java.util.Collection;

public interface EmployeesRepository {
    Employee add(Employee employee);

    Employee remove(Employee employee);

    Employee find(Employee employee);

    Collection<Employee> findAll();

    Collection<Employee> removeAll();

    int count();
}
