package pro.sky.course_2_core.hw_2_8_emplbook.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.course_2_core.employee.model.Employee;
import pro.sky.course_2_core.hw_2_8_emplbook.model.Employees;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pro.sky.course_2_core.employee.EmployeeUtils.checkDepartmentId;
import static pro.sky.course_2_core.employee.model.Employee.formatSalary;

@Service
@Component("DepartmentsService")
public class DepartmentsServiceImpl implements DepartmentsService {

    protected Map<String, Employee> employees;

    public DepartmentsServiceImpl() {
        employees = Employees.getInstance().getEmployees();
    }


    @Override
    public Collection<Employee> getAllEmployees() {
        return List.copyOf(employees.values());
    }


    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employees.values().stream().filter(e -> e.getDepartmentId() == departmentId).collect(Collectors.toUnmodifiableList());
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
        return formatSalary(employees.values().stream().filter(e -> e.getDepartmentId() == departmentId).mapToDouble(Employee::getSalary).average().orElse(0));
    }


    @Override
    public Employee findMaxSalaryEmployeeInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employees.values().stream().filter(e -> e.getDepartmentId() == departmentId).max(new SalaryComparator<>()).orElse(null);

    }

    @Override
    public Employee findMinSalaryEmployeeInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return employees.values().stream().filter(e -> e.getDepartmentId() == departmentId).min(new SalaryComparator<>()).orElse(null);
    }


    private double calculateMonthlyPayrollAsNumber() {
        return employees.values().stream().mapToDouble(Employee::getSalary).sum();
    }


    @Override
    public String calculateMonthlyPayrollInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        return Employee.formatSalary(employees.values().stream().filter(e -> e.getDepartmentId() == departmentId).mapToDouble(Employee::getSalary).sum());
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartments() {
        return employees.values().stream().sorted((employee1, employee2) -> employee1.getDepartmentId() >= employee2.getDepartmentId() ? 1 : -1).collect(Collectors.toList());
    }

}

