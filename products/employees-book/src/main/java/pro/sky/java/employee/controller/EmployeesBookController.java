package pro.sky.java.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.service.DepartmentsService;
import pro.sky.java.employee.service.EmployeesBookService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employees-book")
public class EmployeesBookController {

    final private EmployeesBookService employeesBookService;
    final private DepartmentsService departmentsService;

    public EmployeesBookController(EmployeesBookService employeesBookService,
                                   DepartmentsService departmentsService) {
        this.employeesBookService = employeesBookService;
        this.departmentsService = departmentsService;
    }

    @GetMapping("/add-employee")
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        return employeesBookService.addEmployee(new Employee(firstName, lastName, departmentId, salary));
    }

    @GetMapping("/remove-employee")
    public Employee removeEmployee(String firstName, String lastName) {
        return employeesBookService.removeEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/find-employee")
    public Employee findEmployee(String firstName, String lastName) {
        return employeesBookService.findEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/list")
    public Collection<Employee> getAllEmployees() {
        return employeesBookService.getAllEmployees();
    }

    @GetMapping("/company-average-salary")
    public String getCompanyAverageSalary() {
        return employeesBookService.calculateAverageSalary();
    }

    @GetMapping("/company-monthly-payroll")
    public String getCompanyMonthlyPayroll() {
        return employeesBookService.calculateMonthlyPayroll();
    }

    @GetMapping("/company-min-salary-employee")
    public Employee getCompanyMinSalaryEmployee() {
        return employeesBookService.findMinSalaryEmployee();
    }

    @GetMapping("/company-max-salary-employee")
    public Employee getCompanyMaxSalaryEmployee() {
        return employeesBookService.findMaxSalaryEmployee();
    }

    @GetMapping("/assign-salary")
    public Employee assignSalary(String firstName, String lastName, int salary) {
        return employeesBookService.setSalary(new Employee(firstName, lastName), salary);
    }

    @GetMapping("/assign-department")
    public Employee assignDepartment(String firstName, String lastName, int departmentId) {
        return employeesBookService.setDepartment(new Employee(firstName, lastName), departmentId);
    }

    @GetMapping("/employees-with-salary-greater-or-equal-to")
    public List<Employee> findEmployeesWithSalaryGreaterOrEqualTo(int salary) {
        return employeesBookService.findEmployeesWithSalaryGreaterOrEqualTo(salary);
    }

    @GetMapping("/employees-with-salary-less-than")
    public Collection<Employee> findEmployeesWithSalaryGreaterOrEqualTot(int salary) {
        return employeesBookService.findEmployeesWithSalaryLessThan(salary);
    }

    @GetMapping("/employees-by-department")
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return departmentsService.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/index-salary-in-department")
    public Collection<Employee> indexSalaryInDepartment(int departmentId, int percentage) {
        return departmentsService.indexSalaryInDepartment(departmentId, percentage);
    }

    @GetMapping("/index-salary-for-all")
    public Collection<Employee> indexSalaryInDepartment(int percentage) {
        return employeesBookService.indexSalary(percentage);
    }

    @GetMapping("/average-salary-in-department")
    public String calcAverageSalaryInDepartment(int departmentId) {
        return departmentsService.calcAverageSalaryInDepartment(departmentId);
    }

    @GetMapping("/find-max-salary-employee-in-department")
    public Employee findMaxSalaryEmployeeInDepartment(int departmentId) {
        return departmentsService.findMaxSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/find-min-salary-employee-in-department")
    public Employee findMinSalaryEmployeeInDepartment(int departmentId) {
        return departmentsService.findMinSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/find-max-salary-employee")
    public Employee findMaxSalaryEmployee() {
        return employeesBookService.findMaxSalaryEmployee();
    }

    @GetMapping("/find-min-Salary-employee")
    public Employee findMinSalaryEmployee() {
        return employeesBookService.findMinSalaryEmployee();
    }

    @GetMapping("/monthly-payroll-in-department")
    public String calculateMonthlyPayrollInDepartment(int departmentId) {
        return departmentsService.calculateMonthlyPayrollInDepartment(departmentId);
    }
}
