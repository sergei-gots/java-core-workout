package pro.sky.course_2_core.hw_2_8_emplbook.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.course_2_core.employee.exceptions.*;
import pro.sky.course_2_core.employee.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static pro.sky.course_2_core.employee.EmployeeUtils.checkDepartmentId;

@Service
@Component("EmployeesBookService")
public class EmployeesBookServiceImpl extends DepartmentsServiceImpl
        implements EmployeesBookService {

    public EmployeesBookServiceImpl() {
        super();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.containsKey(employee.getKey())) {
            throw new EmployeeAlreadyAddedException(employee);
        }
        employees.put(employee.getKey(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        final String key = employee.getKey();
        if (employees.get(key) == null) {
            throw new EmployeeNotFoundException(employee);
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(Employee employee) {
        final Employee foundEmployee = employees.get(employee.getKey());
        if (foundEmployee == null) {
            throw new EmployeeNotFoundException(employee);
        }
        return foundEmployee;
    }

    @Override
    public Employee setSalary(Employee employee, int newSalary) {
        Employee employeeToUpdate = employees.get(employee.getKey());
        if (employeeToUpdate == null) {
            throw new EmployeeNotFoundException(employee);
        }
        employeeToUpdate.setSalary(newSalary);
        return employeeToUpdate;
    }

    @Override
    public Employee setDepartment(Employee employee, int newDepartmentId) {
        checkDepartmentId(newDepartmentId);
        Employee employeeToUpdate = employees.get(employee.getKey());
        if (employeeToUpdate == null) {
            throw new EmployeeNotFoundException(employee);
        }
        employeeToUpdate.setDepartmentId(newDepartmentId);
        return employeeToUpdate;
    }

    @Override
    public List<Employee> findEmployeesWithSalaryGreaterOrEqualTo(int targetSalary) {
        return employees.values().stream()
                .filter(e -> e.getSalary() >= targetSalary)
                .collect(Collectors.toUnmodifiableList());
    }


    @Override
    public Collection<Employee> findEmployeesWithSalaryLessThan(double targetSalary) {
        return employees.values().stream()
                .filter(e -> e.getSalary() < targetSalary)
                .collect(Collectors.toUnmodifiableList());
    }


    @Override
    public Collection<Employee> indexSalary(int salaryIndexationPercentage) {
        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        Collection<Employee> employeesCollection = employees.values();
        employeesCollection.forEach(e -> e.setSalary(e.getSalary() * salaryMultiplier));
        return employeesCollection;
    }

    @Override
    public Employee findMaxSalaryEmployee() {
        return employees.values()
                .stream()
                .max(new SalaryComparator<>())
                .orElse(null);
    }

    @Override
    public Employee findMinSalaryEmployee() {
        return employees.values()
                .stream()
                .min(new SalaryComparator<>())
                .orElse(null);
    }

    @Override
    public String calculateMonthlyPayroll() {
        return Employee.formatSalary(calculateMonthlyPayrollAsNumber());
    }

    private double calculateMonthlyPayrollAsNumber() {
        return employees.values().stream().mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public String calculateAverageSalary() {
        return Employee.formatSalary((employees.size() == 0) ? 0 : calculateMonthlyPayrollAsNumber() / employees.size());
    }
}
