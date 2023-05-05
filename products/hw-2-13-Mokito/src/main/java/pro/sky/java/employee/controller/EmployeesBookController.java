package pro.sky.java.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;
import pro.sky.java.employee.service.EmployeesBookService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employees-book")
public class EmployeesBookController {

    final private EmployeesBookService employeesBookService;

    public EmployeesBookController(EmployeesBookService employeesBookService) {
        this.employeesBookService = employeesBookService;
    }


    @GetMapping("/add")
    public Employee addEmployee(String firstName, String lastName, Integer departmentId, Double salary) {
        return employeesBookService.addEmployee(new Employee(firstName, lastName, departmentId, salary));
    }

    @GetMapping("/find")
    public Employee findEmployee(String firstName, String lastName) {
        return employeesBookService.findEmployee(new Person(firstName, lastName));
    }

    @GetMapping("/remove")
    public Employee removeEmployee(String firstName, String lastName) {
        return employeesBookService.removeEmployee(new Person(firstName, lastName));
    }
}
