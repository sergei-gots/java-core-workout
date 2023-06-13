package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> getAllEmployeesByDepartments();

    Collection<Employee> getEmployees(Integer departmentId);

    String getSalarySum(Integer departmentId);

    String getMaxSalary(Integer departmentId);

    String getMinSalary(Integer departmentId);
}
