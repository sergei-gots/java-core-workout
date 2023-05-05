package pro.sky.java.employee.repository;

import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;

import java.util.Collection;

public interface EmployeesRepository {
    Employee add(Employee employee);

    Employee remove(Person person);

    Employee find(Person person);

    Collection<Employee> findAll();

    Collection<Employee> removeAll();

    int count();
}
