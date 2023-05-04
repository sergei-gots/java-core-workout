package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.Collection;

public interface DepartmentsService {
    Collection<Employee> getAllEmployees();


    Collection<Employee> findEmployeesByDepartment(int departmentId);

    Collection<Employee> indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage);


    String calcAverageSalaryInDepartment(int departmentId);

    Employee findMaxSalaryEmployeeInDepartment(int departmentId);

    Employee findMinSalaryEmployeeInDepartment(int departmentId);


    String calculateMonthlyPayrollInDepartment(int departmentId);

    Collection<Employee> getAllEmployeesByDepartments();
}
