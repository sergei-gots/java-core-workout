package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> getAllEmployeesByDepartments();
    Collection<Employee> getEmployeesByDepartment(Integer departmentId);

    String getSalarySumInDepartment(Integer departmentId);

    String getMaxSalaryInDepartment(Integer departmentId);
    String getMinSalaryInDepartment(Integer departmentId);
}
