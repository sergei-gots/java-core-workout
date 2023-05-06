package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import pro.sky.java.employee.util.EmployeeValidator;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Collection<Employee> getEmployees(Integer departmentId) {
        EmployeeValidator.validateDepartment(departmentId);
        return employeeService.getAll().stream().filter(e -> e.getDepartmentId() == departmentId).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String getMaxSalary(Integer departmentId) {
        EmployeeValidator.validateDepartment(departmentId);
        Employee maxSalaryEmployee = employeeService.getAll().stream().filter(e -> e.getDepartmentId() == departmentId).max(new SalaryComparator<>()).orElse(null);
        return (maxSalaryEmployee != null) ? maxSalaryEmployee.getSalaryRub() : "There are no employees in this department.";
    }

    @Override
    public String getMinSalary(Integer departmentId) {
        EmployeeValidator.validateDepartment(departmentId);
        Employee minSalaryEmployee = employeeService.getAll().stream().filter(e -> e.getDepartmentId() == departmentId).min(new SalaryComparator<>()).orElse(null);
        return (minSalaryEmployee != null) ? minSalaryEmployee.getSalaryRub() : "There are no employees in this department.";
    }

    @Override
    public String getSalarySumIn(Integer departmentId) {
        EmployeeValidator.validateDepartment(departmentId);
        return Employee.formatSalary(employeeService.getAll().stream().filter(e -> e.getDepartmentId() == departmentId).mapToDouble(Employee::getSalary).sum());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        Map<Integer, List<Employee>> employeesMap = new HashMap<>();
        for (Employee e : employeeService.getAll()) {
            final int departmentId = e.getDepartmentId();
            List<Employee> departmentList = employeesMap.get(departmentId);
            if (departmentList == null) {
                departmentList = new ArrayList<>();
                employeesMap.put(departmentId, departmentList);
            }
            departmentList.add(e);
        }
        return employeesMap;
    }
}

