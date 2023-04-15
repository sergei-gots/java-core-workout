package pro.sky.java.course_2_core.hw_2_7_emplbook.service;

import pro.sky.java.course_2_core.hw_2_7_emplbook.model.Employee;

import java.util.List;

public interface EmployeesBookService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    List<Employee> getList();

}
