package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.repository.EmployeesRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import static pro.sky.java.employee.util.EmployeeUtils.checkDepartmentId;
import static pro.sky.java.employee.model.Employee.formatSalary;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    private final EmployeesRepository employeesRepository;

    public DepartmentsServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }


    @Override
    public Collection<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }


    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employeesRepository.findAll().stream().filter(e -> e.getDepartmentId() == departmentId).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Employee> indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage) {
        Collection<Employee> departmentEmployeesCollection = findEmployeesByDepartment(departmentId);
        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        departmentEmployeesCollection.forEach(e -> e.setSalary(e.getSalary() * salaryMultiplier));
        return departmentEmployeesCollection;
    }


    @Override
    public String calcAverageSalaryInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return formatSalary(employeesRepository.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToDouble(Employee::getSalary).average().orElse(0));
    }


    @Override
    public Employee findMaxSalaryEmployeeInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employeesRepository.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(new SalaryComparator<>()).orElse(null);

    }

    @Override
    public Employee findMinSalaryEmployeeInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employeesRepository.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(new SalaryComparator<>()).orElse(null);
    }


    private double calculateMonthlyPayrollAsNumber() {
        return employeesRepository.findAll().stream()
                .mapToDouble(Employee::getSalary).sum();
    }


    @Override
    public String calculateMonthlyPayrollInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return Employee.formatSalary(employeesRepository.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToDouble(Employee::getSalary).sum());
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartments() {
        return employeesRepository.findAll().stream().sorted((employee1, employee2) -> employee1.getDepartmentId() >= employee2.getDepartmentId() ? 1 : -1).collect(Collectors.toList());
    }

}

