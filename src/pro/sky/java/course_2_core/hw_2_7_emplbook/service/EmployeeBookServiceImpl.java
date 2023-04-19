package pro.sky.java.course_2_core.hw_2_7_emplbook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course_2_core.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course_2_core.employee.exceptions.EmployeeNotFoundException;
import pro.sky.java.course_2_core.employee.model.Employee;
import pro.sky.java.course_2_core.employee.EmployeeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static pro.sky.java.course_2_core.employee.EmployeeUtils.*;

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
        if (employeeToUpdate == null) {
            throw new EmployeeNotFoundException(employee);
        }
        employeeToUpdate.setDepartmentId(newDepartmentId);
        return employeeToUpdate;
    }

    @Override
    public List<Employee> findEmployeesWithSalaryGreaterOrEqualTo(int targetSalary) {
        List<Employee> employeesTargetedSalary = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getSalary() >= targetSalary) {
                employeesTargetedSalary.add(employee);
            }
        }
        return employeesTargetedSalary;
    }

    @Override
    public List<Employee> findEmployeesWithSalaryLessThan(double targetSalary) {
        List<Employee> employeesTargetedSalary = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < targetSalary) {
                employeesTargetedSalary.add(employee);
            }
        }
        return employeesTargetedSalary;
    }

    @Override
    public List<Employee> findEmployeesByDepartment(int departmentId) {
        List<Employee> employeesInDepartment = new ArrayList<>();
        checkDepartmentId(departmentId);
        for (Employee employee : employees.values()) {
            if (departmentId == employee.getDepartmentId()) {
                employeesInDepartment.add(employee);
            }
        }
        return employeesInDepartment;
    }

    @Override
    public List<Employee> indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage) {
        List<Employee> employeesInDepartment = findEmployeesByDepartment(departmentId);
        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        for (Employee employee : employees.values()) {
            employee.setSalary(employee.getSalary() * salaryMultiplier);
        }
        return employeesInDepartment;
    }

    @Override
    public List<Employee> indexSalary(int salaryIndexationPercentage) {
        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        for (Employee employee : employees.values()) {
            employee.setSalary(employee.getSalary() * salaryMultiplier);
        }
        return getList();
    }

    @Override
    public String calcAverageSalaryInDepartment(int departmentId) {
        double sum = 0;
        int count = 0;
        checkDepartmentId(departmentId);

        for (Employee employee : employees.values()) {
            if (employee.getDepartmentId() == departmentId) {
                count++;
                sum += employee.getSalary();
            }
        }
        return Employee.formatSalary((count == 0) ? 0 : (sum / count));
    }

    @Override
    public Employee findMaxWageEmployeeInDepartment(int departmentId) {
        double maxWage = Double.MIN_VALUE;
        Employee employeeWithMaxWage = null;
        for (Employee employee : employees.values()) {
            if (employee.getDepartmentId() == departmentId && employee.getSalary() > maxWage) {
                maxWage = employee.getSalary();
                employeeWithMaxWage = employee;
            }
        }
        return employeeWithMaxWage;
    }

    @Override
    public Employee findMinWageEmployeeInDepartment(int departmentId) {
        double minWage = Double.MAX_VALUE;
        Employee employeeWithMinWage = null;
        for (Employee employee : employees.values()) {
            if (employee.getDepartmentId() == departmentId && employee.getSalary() < minWage) {
                minWage = employee.getSalary();
                employeeWithMinWage = employee;
            }
        }
        return employeeWithMinWage;
    }

    @Override
    public Employee findMaxWageEmployee() {
        double maxWage = Double.MIN_VALUE;
        Employee employeeWithMaxWage = null;
        for (Employee employee : employees.values()) {
            if (employee != null && maxWage < employee.getSalary()) {
                maxWage = employee.getSalary();
                employeeWithMaxWage = employee;
            }
        }
        return employeeWithMaxWage;
    }

    @Override
    public Employee findMinWageEmployee() {
        double minWage = Double.MAX_VALUE;
        Employee employeeWithMinWage = null;
        for (Employee employee : employees.values()) {
            if (minWage > employee.getSalary()) {
                minWage = employee.getSalary();
                employeeWithMinWage = employee;
            }
        }
        return employeeWithMinWage;
    }

    @Override
    public String calculateMonthlyPayroll() {
        return Employee.formatSalary(calculateMonthlyPayrollAsNumber());
    }

    private double calculateMonthlyPayrollAsNumber() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            sum += employee.getSalary();
        }
        return sum;
    }

    @Override
    public String calculateAverageSalary() {
        return Employee.formatSalary((employees.size() == 0) ? 0 : calculateMonthlyPayrollAsNumber() / employees.size());
    }

    @Override
    public String calculateMonthlyPayrollInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartmentId() == departmentId) {
                sum += employee.getSalary();
            }
        }
        return Employee.formatSalary(sum);
    }


}
