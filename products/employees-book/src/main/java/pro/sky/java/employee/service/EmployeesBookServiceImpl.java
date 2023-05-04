package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.employee.exceptions.EmployeeNotFoundException;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Employees;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pro.sky.java.employee.util.EmployeeUtils.checkDepartmentId;

@Service
public class EmployeesBookServiceImpl implements EmployeesBookService {

    private Map<String, Employee> employees;

    public EmployeesBookServiceImpl() {
        employees = Employees.getInstance().getEmployees();
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
    public Collection<Employee> getAllEmployees() {
        return List.copyOf(employees.values());
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
