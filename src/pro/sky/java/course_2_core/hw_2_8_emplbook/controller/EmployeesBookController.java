package pro.sky.java.course_2_core.hw_2_8_emplbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course_2_core.employee.model.Employee;
import pro.sky.java.course_2_core.hw_2_8_emplbook.service.EmployeesBookService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employees-book")
public class EmployeesBookController {

    final private EmployeesBookService service;

    public EmployeesBookController(@Qualifier("EmployeesBookService") EmployeesBookService service) {
      this.service = service;
    }

    @GetMapping("/add-employee")
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        return service.addEmployee(new Employee(firstName, lastName, departmentId, salary));
    }

    @GetMapping("/remove-employee")
    public Employee removeEmployee(String firstName, String lastName){
        return service.removeEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/find-employee")
    public Employee findEmployee(String firstName, String lastName) {
        return service.findEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/list")
    public Collection<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/company-average-salary")
    public String getCompanyAverageSalary() {
        return service.calculateAverageSalary();
    }

    @GetMapping("/company-monthly-payroll")
    public String getCompanyMonthlyPayroll() {
        return service.calculateMonthlyPayroll();
    }

    @GetMapping("/company-min-salary-employee")
    public Employee getCompanyMinSalaryEmployee() {
        return service.findMinSalaryEmployee();
    }

    @GetMapping("/company-max-salary-employee")
    public Employee getCompanyMaxSalaryEmployee() {
        return service.findMaxSalaryEmployee();
    }

    @GetMapping("/assign-salary")
    public Employee assignSalary(String firstName, String lastName, int salary) {
        return service.setSalary(new Employee(firstName, lastName), salary);
    }

    @GetMapping("/assign-department")
    public Employee assignDepartment(String firstName, String lastName, int departmentId) {
        return service.setDepartment(new Employee(firstName, lastName), departmentId);
    }

    @GetMapping("/employees-with-salary-greater-or-equal-to")
    public List<Employee>  findEmployeesWithSalaryGreaterOrEqualTo(int salary) {
        return service.findEmployeesWithSalaryGreaterOrEqualTo(salary);
    }

    @GetMapping("/employees-with-salary-less-than")
    public Collection<Employee>  findEmployeesWithSalaryGreaterOrEqualTot(int salary) {
        return service.findEmployeesWithSalaryLessThan(salary);
    }

    @GetMapping("/employees-by-department")
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return service.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/index-salary-in-department")
    public Collection<Employee> indexSalaryInDepartment(int departmentId, int percentage) {
        return service.indexSalaryInDepartment(departmentId, percentage);
    }

    @GetMapping("/index-salary-for-all")
    public Collection<Employee> indexSalaryInDepartment(int percentage) {
        return service.indexSalary(percentage);
    }

    @GetMapping("/average-salary-in-department")
    public String calcAverageSalaryInDepartment(int departmentId) {
        return service.calcAverageSalaryInDepartment(departmentId);
    }

    @GetMapping("/find-max-salary-employee-in-department")
    public Employee findMaxSalaryEmployeeInDepartment(int departmentId) {
        return service.findMaxSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/find-min-salary-employee-in-department")
    public Employee findMinSalaryEmployeeInDepartment(int departmentId) {
        return service.findMinSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/find-max-salary-employee")
    public Employee findMaxSalaryEmployee() {
        return service.findMaxSalaryEmployee();
    }

    @GetMapping("/find-min-Salary-employee")
    public Employee findMinSalaryEmployee() {
        return service.findMinSalaryEmployee();
    }

    @GetMapping("/monthly-payroll-in-department")
    public String calculateMonthlyPayrollInDepartment(int departmentId) {
        return service.calculateMonthlyPayrollInDepartment(departmentId);
    }
}
