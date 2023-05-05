package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;

import java.util.Collection;
import java.util.List;

public interface EmployeesBookService  {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Person person);

    Employee findEmployee(Person person);
}
