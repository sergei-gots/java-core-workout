package pro.sky.java.course_2_core.hw_2_8_emplbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course_2_core.hw_2_7_emplbook.model.Employee;
import pro.sky.java.course_2_core.hw_2_8_emplbook.service.EmployeesBookService;

import java.util.List;

@RestController
@RequestMapping("/employees-book")
public class EmployeesBookController {
    final private EmployeesBookService employeesBookService;

    public EmployeesBookController(EmployeesBookService employeesBookService) {
        this.employeesBookService = employeesBookService;
    }

    @GetMapping("/add-employee")
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        return employeesBookService.addEmployee(new Employee(firstName, lastName, departmentId, salary));
    }

    @GetMapping("/remove-employee")
    public Employee removeEmployee(String firstName, String lastName){
        return employeesBookService.removeEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/find-employee")
    public Employee findEmployee(String firstName, String lastName) {
        return employeesBookService.findEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/list")
    public List<Employee> getEmployeesList() {
        return employeesBookService.getList();
    }

    @GetMapping("/company-average-salary")
    public String getCompanyAverageSalary() {
        return employeesBookService.calculateAverageSalary();
    }

    @GetMapping("/company-monthly-payroll")
    public String getCompanyMonthlyPayroll() {
        return employeesBookService.calculateMonthlyPayroll();
    }

    @GetMapping("/company-min-wage-employee")
    public Employee getCompanyMinWageEmployee() {
        return employeesBookService.findMinWageEmployee();
    }

    @GetMapping("/company-max-wage-employee")
    public Employee getCompanyMaxWageEmployee() {
        return employeesBookService.findMaxWageEmployee();
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
    public List<Employee>  findEmployeesWithSalaryGreaterOrEqualTo(int salary) {
        return employeesBookService.findEmployeesWithSalaryGreaterOrEqualTo(salary);
    }

    @GetMapping("/employees-with-salary-less-than")
    public List<Employee>  findEmployeesWithSalaryGreaterOrEqualTot(int salary) {
        return employeesBookService.findEmployeesWithSalaryLessThan(salary);
    }

    @GetMapping("/employees-by-department")
    public List<Employee> findEmployeesByDepartment(int departmentId) {
        return employeesBookService.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/index-salary-in-department")
    public List<Employee> indexSalaryInDepartment(int departmentId, int percentage) {
        return employeesBookService.indexSalaryInDepartment(departmentId, percentage);
    }

    @GetMapping("/index-salary-for-all")
    public List<Employee> indexSalaryInDepartment(int percentage) {
        return employeesBookService.indexSalary(percentage);
    }

    @GetMapping("/average-salary-in-department")
    public String calcAverageSalaryInDepartment(int departmentId) {
        return employeesBookService.calcAverageSalaryInDepartment(departmentId);
    }

    @GetMapping("/find-max-wage-employee-in-department")
    public Employee findMaxWageEmployeeInDepartment(int departmentId) {
        return employeesBookService.findMaxPaidEmployeeInDepartment(departmentId);
    }

    @GetMapping("/find-min-wage-employee-in-department")
    public Employee findMinWageEmployeeInDepartment(int departmentId) {
        return employeesBookService.findMinPaidEmployeeInDepartment(departmentId);
    }

    @GetMapping("/find-max-wage-employee")
    public Employee findMaxWageEmployee() {
        return employeesBookService.findMaxWageEmployee();
    }

    @GetMapping("/find-min-wage-employee")
    public Employee findMinWageEmployee() {
        return employeesBookService.findMinWageEmployee();
    }

    @GetMapping("/monthly-payroll-in-department")
    public String calculateMonthlyPayrollInDepartment(int departmentId) {
        return employeesBookService.calculateMonthlyPayrollInDepartment(departmentId);
    }
}
