package pro.sky.java.employee.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeesBookService) {
        this.employeeService = employeesBookService;
    }


    @PostMapping
    public void addEmployee(@RequestBody Collection<Employee> employees) {
        employeeService.add(employees);
    }


    @PutMapping
    public void editEmployee(@RequestBody Employee employee) {
        employeeService.edit(employee);
    }

    @DeleteMapping("/{id}")
    public Employee remove(@PathVariable int id) {
        return employeeService.remove(id);
    }


    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) {
        return employeeService.get(id);
    }

    @GetMapping("/list")
    public Collection<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/salaryHigherThan")
    public Collection<Employee> getEmployeesWithSalaryHigherThan(double salary) {
        return employeeService.getEmployeesWithSalaryHigherThan(salary);
    }

}
