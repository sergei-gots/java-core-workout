package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Person person);

    Employee findEmployee(Person person);
}
