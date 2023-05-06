package pro.sky.java.employee.repository;

import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;

import java.util.List;

public interface EmployeesRepository {
    Employee add(Employee employee);

    Employee remove(Person person);

    Employee find(Person person);

    List<Employee> findAll();

    List<Employee> removeAll();

    int count();
}
