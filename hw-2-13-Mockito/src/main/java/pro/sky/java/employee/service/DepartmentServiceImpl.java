package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.exceptions.ThereAreNoEmployeesInDepartmentException;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.util.EmployeeValidator;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;
    private final EmployeeValidator employeeValidator = new EmployeeValidator();

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Collection<Employee> getEmployees(Integer departmentId) {
        employeeValidator.validateDepartment(departmentId);
        return employeeService.getAll().stream().filter(e -> e.getDepartmentId() == departmentId).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String getMaxSalary(Integer departmentId) {
        employeeValidator.validateDepartment(departmentId);
        Employee maxSalaryEmployee = employeeService.getAll().stream().filter(e -> e.getDepartmentId() == departmentId).max(new SalaryComparator<>()).orElse(null);
        if (maxSalaryEmployee == null) {
            throw new ThereAreNoEmployeesInDepartmentException(departmentId);
        }
        return maxSalaryEmployee.getSalaryRub();
    }

    @Override
    public String getMinSalary(Integer departmentId) {
        employeeValidator.validateDepartment(departmentId);
        Employee minSalaryEmployee = employeeService.getAll().stream().filter(e -> e.getDepartmentId() == departmentId).min(new SalaryComparator<>()).orElse(null);
        if (minSalaryEmployee == null) {
            throw new ThereAreNoEmployeesInDepartmentException(departmentId);
        }
        return minSalaryEmployee.getSalaryRub();
    }

    @Override
    public String getSalarySum(Integer departmentId) {
        employeeValidator.validateDepartment(departmentId);
        BigDecimal sum =employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if(sum.compareTo(BigDecimal.ZERO) == 0) {
            throw new ThereAreNoEmployeesInDepartmentException(departmentId);
        }
        return  Employee.formatSalary(sum);
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        Map<Integer, List<Employee>> employeesMap = new HashMap<>();
        for (Employee e : employeeService.getAll()) {
            final int departmentId = e.getDepartmentId();
            List<Employee> departmentList
                    = employeesMap.computeIfAbsent(
                            departmentId, k -> new ArrayList<>());
            departmentList.add(e);
        }
        return employeesMap;
    }
}

