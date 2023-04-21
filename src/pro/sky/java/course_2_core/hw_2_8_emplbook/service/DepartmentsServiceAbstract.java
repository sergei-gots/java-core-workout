package pro.sky.java.course_2_core.hw_2_8_emplbook.service;

import pro.sky.java.course_2_core.employee.model.Employee;

import java.util.Collection;

public interface DepartmentsServiceAbstract {
    Collection<Employee> getAllEmployees();


    Collection<Employee> findEmployeesByDepartment(int departmentId);

    Collection<Employee> indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage);


    String calcAverageSalaryInDepartment(int departmentId);

    Employee findMaxSalaryEmployeeInDepartment(int departmentId);

    Employee findMinSalaryEmployeeInDepartment(int departmentId);


    String calculateMonthlyPayrollInDepartment(int departmentId);

    Collection<Employee> getAllEmployeesByDepartments();
}
