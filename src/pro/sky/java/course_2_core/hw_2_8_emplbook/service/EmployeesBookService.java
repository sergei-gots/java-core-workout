package pro.sky.java.course_2_core.hw_2_8_emplbook.service;

import pro.sky.java.course_2_core.employee.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeesBookService extends DepartmentsServiceAbstract {
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
}
