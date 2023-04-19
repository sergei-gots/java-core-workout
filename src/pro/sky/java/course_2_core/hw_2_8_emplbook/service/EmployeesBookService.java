package pro.sky.java.course_2_core.hw_2_8_emplbook.service;

import pro.sky.java.course_2_core.employee.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeesBookService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    List<Employee> getList();

    String calculateAverageSalary();

    String calculateMonthlyPayroll();

    Employee findMinWageEmployee();

    Employee setSalary(Employee employee, int newSalary);

    Employee setDepartment(Employee employee, int newDepartmentId);

    List<Employee> findEmployeesWithSalaryGreaterOrEqualTo(int targetSalary);

    List<Employee> findEmployeesWithSalaryLessThan(double targetSalary);

    List<Employee> findEmployeesByDepartment(int departmentId);

    List<Employee> indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage);

    List<Employee> indexSalary(int salaryIndexationPercentage);

    String calcAverageSalaryInDepartment(int departmentId);

    Employee findMaxPaidEmployeeInDepartment(int departmentId);

    Employee findMinPaidEmployeeInDepartment(int departmentId);

    Employee findMaxWageEmployee();

    String calculateMonthlyPayrollInDepartment(int departmentId);

    Collection<Employee> getEmployeesByDepartment(int departmentId);
}
