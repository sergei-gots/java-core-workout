package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.repository.EmployeesRepository;

import java.util.*;
import java.util.stream.Collectors;

import static pro.sky.java.employee.util.EmployeeUtils.validateDepartment;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeesRepository employeesRepository;

    public DepartmentServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Collection<Employee> getEmployeesByDepartment(Integer departmentId) {
        validateDepartment(departmentId);
        return employeesRepository.findAll().stream().filter(e -> e.getDepartmentId() == departmentId).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String getMaxSalaryInDepartment(Integer departmentId) {
        validateDepartment(departmentId);
        Employee maxSalaryEmployee = employeesRepository.findAll().stream().filter(e -> e.getDepartmentId() == departmentId).max(new SalaryComparator<>()).orElse(null);
        return (maxSalaryEmployee != null) ? maxSalaryEmployee.getSalaryRub() : "There are no employees in this department.";
    }

    @Override
    public String getMinSalaryInDepartment(Integer departmentId) {
        validateDepartment(departmentId);
        Employee minSalaryEmployee = employeesRepository.findAll().stream().filter(e -> e.getDepartmentId() == departmentId).min(new SalaryComparator<>()).orElse(null);
        return (minSalaryEmployee != null) ? minSalaryEmployee.getSalaryRub() : "There are no employees in this department.";
    }

    @Override
    public String getSalarySumInDepartment(Integer departmentId) {
        validateDepartment(departmentId);
        return Employee.formatSalary(employeesRepository.findAll().stream().filter(e -> e.getDepartmentId() == departmentId).mapToDouble(Employee::getSalary).sum());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        Map<Integer, List<Employee>> employeesMap = new HashMap<>();
        for (Employee e : employeesRepository.findAll()) {
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

