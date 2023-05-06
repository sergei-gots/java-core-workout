package pro.sky.java.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;
import pro.sky.java.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees-book")
public class EmployeeController {

    final private EmployeeService employeesBookService;

    public EmployeeController(EmployeeService employeesBookService) {
        this.employeesBookService = employeesBookService;
    }


    @GetMapping("/add")
    public Employee addEmployee(String firstName, String lastName, Integer departmentId, Double salary) {
        return employeesBookService.add(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(String firstName, String lastName) {
        return employeesBookService.find(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(String firstName, String lastName) {
        return employeesBookService.remove(firstName, lastName);
    }
}
