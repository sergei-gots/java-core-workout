package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeesBookService  {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    String calculateAverageSalary();


    String calculateMonthlyPayroll();

    Employee setSalary(Employee employee, int newSalary);

    Employee setDepartment(Employee employee, int newDepartmentId);

    List<Employee> findEmployeesWithSalaryGreaterOrEqualTo(int targetSalary);

    Collection<Employee> findEmployeesWithSalaryLessThan(double targetSalary);

    Collection<Employee> indexSalary(int salaryIndexationPercentage);

    Employee findMaxSalaryEmployee();

    Employee findMinSalaryEmployee();

    Collection<Employee> getAllEmployees();
}
