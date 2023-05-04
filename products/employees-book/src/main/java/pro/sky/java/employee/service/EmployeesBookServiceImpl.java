package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.repository.EmployeesRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static pro.sky.java.employee.util.EmployeeUtils.checkDepartmentId;

@Service
public class EmployeesBookServiceImpl implements EmployeesBookService {

    private final EmployeesRepository employeesRepository;

    public EmployeesBookServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeesRepository.add(employee);
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        return employeesRepository.remove(employee);
    }

    @Override
    public Employee findEmployee(Employee employee) {
        return employeesRepository.find(employee);
    }

    @Override
    public Collection<Employee> getAllEmployees() {

        return employeesRepository.findAll();
    }

    @Override
    public Employee setSalary(Employee template, int newSalary) {
        Employee employee = employeesRepository.find(template);
        employee.setSalary(newSalary);
        return employee.copy();
    }

    @Override
    public Employee setDepartment(Employee template, int departmentId) {
        checkDepartmentId(departmentId);
        Employee employee = employeesRepository.find(template);
        employee.setDepartmentId(departmentId);
        return employee.copy();
    }

    @Override
    public List<Employee> findEmployeesWithSalaryGreaterOrEqualTo(int targetSalary) {
        return employeesRepository.findAll().stream()
                .filter(e -> e.getSalary() >= targetSalary)
                .collect(Collectors.toUnmodifiableList());
    }


    @Override
    public Collection<Employee> findEmployeesWithSalaryLessThan(double targetSalary) {
        return employeesRepository.findAll().stream()
                .filter(e -> e.getSalary() < targetSalary)
                .collect(Collectors.toUnmodifiableList());
    }


    @Override
    public Collection<Employee> indexSalary(int salaryIndexationPercentage) {
        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        Collection<Employee> employeesCollection = employeesRepository.findAll();
        employeesCollection.forEach(e -> e.setSalary(e.getSalary() * salaryMultiplier));
        return employeesCollection;
    }

    @Override
    public Employee findMaxSalaryEmployee() {
        return employeesRepository.findAll()
                .stream()
                .max(new SalaryComparator<>())
                .orElse(null);
    }

    @Override
    public Employee findMinSalaryEmployee() {
        return employeesRepository.findAll()
                .stream()
                .min(new SalaryComparator<>())
                .orElse(null);
    }

    @Override
    public String calculateMonthlyPayroll() {
        return Employee.formatSalary(calculateMonthlyPayrollAsNumber());
    }

    private double calculateMonthlyPayrollAsNumber() {
        return employeesRepository.findAll().stream().mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public String calculateAverageSalary() {
        return Employee.formatSalary((employeesRepository.count() == 0) ?
                0 : calculateMonthlyPayrollAsNumber() / employeesRepository.count());
    }
}
