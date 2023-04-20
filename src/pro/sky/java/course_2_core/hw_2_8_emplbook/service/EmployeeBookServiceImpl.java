package pro.sky.java.course_2_core.hw_2_8_emplbook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course_2_core.employee.EmployeeUtils;
import pro.sky.java.course_2_core.employee.exceptions.*;
import pro.sky.java.course_2_core.employee.model.Employee;
import static pro.sky.java.course_2_core.employee.model.Employee.formatSalary;

import java.util.*;
import java.util.stream.Collectors;

import static pro.sky.java.course_2_core.employee.EmployeeUtils.DEPARTMENT_COUNT;

@Service
public class EmployeeBookServiceImpl implements EmployeesBookService {

    private final Map<String, Employee> employees;

    public EmployeeBookServiceImpl() {
        employees = EmployeeUtils.generateEmployees();
    }

    private static void checkDepartmentId(int departmentId) {
        if (departmentId < 1 || departmentId > DEPARTMENT_COUNT) {
            throw new IllegalArgumentException("Department with number " + departmentId + " is not listed.");
        }
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
    public List<Employee> getList() {
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
        if(employeeToUpdate == null) {
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
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employees.values().stream()
                .filter(e->e.getDepartmentId()==departmentId)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Employee> indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage) {
        Collection<Employee> departmentEmployeesCollection = findEmployeesByDepartment(departmentId);
        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        departmentEmployeesCollection
                .forEach(e -> e.setSalary(e.getSalary() * salaryMultiplier));
        return departmentEmployeesCollection;
    }

    @Override
    public Collection<Employee> indexSalary(int salaryIndexationPercentage) {
        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        Collection<Employee> employeesCollection = employees.values();
        employeesCollection.forEach(e -> e.setSalary(e.getSalary() * salaryMultiplier));
        return employeesCollection;
    }

    @Override
    public String calcAverageSalaryInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return formatSalary(employees.values()
                .stream()
                .filter(e->e.getDepartmentId()==departmentId)
                .mapToDouble(Employee::getSalary).average().orElse(0)
        );
    }


    @Override
    public Employee findMaxSalaryEmployeeInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employees.values()
                .stream()
                .filter(e->e.getDepartmentId()==departmentId)
                .max(new SalaryComparator<>())
                .orElse(null);

    }

    @Override
    public Employee findMinSalaryEmployeeInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employees.values()
                .stream()
                .filter(e->e.getDepartmentId()==departmentId)
                .min(new SalaryComparator<>())
                .orElse(null);
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

    @Override
    public String calculateMonthlyPayrollInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return Employee.formatSalary(
                employees.values().stream()
                        .filter(e->e.getDepartmentId()==departmentId)
                        .mapToDouble(Employee::getSalary)
                        .sum()
        );
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartments() {
        return employees.values()
                .stream()
                .sorted((employee1, employee2) -> employee1.getDepartmentId() >= employee2.getDepartmentId() ? 1 : -1)
                .collect(Collectors.toList());
    }

}

class SalaryComparator<T> implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}
