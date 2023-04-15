package pro.sky.java.course_2_core.hw_2_7_emplbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course_2_core.hw_2_7_emplbook.model.Employee;
import pro.sky.java.course_2_core.hw_2_7_emplbook.service.EmployeesBookService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees-book")
public class EmployeesBookController {
    private EmployeesBookService employeesBookService;

    public EmployeesBookController(EmployeesBookService employeesBookService) {
        this.employeesBookService = employeesBookService;
    }

    @GetMapping("/add-employee")
    Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        return employeesBookService.addEmployee(new Employee(firstName, lastName, departmentId, salary));
    }

    @GetMapping("/remove-employee")
    Employee removeEmployee(String firstName, String lastName){
        return employeesBookService.removeEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/find-employee")
    Employee findEmployee(String firstName, String lastName) {
        return employeesBookService.findEmployee(new Employee(firstName, lastName));
    }

    @GetMapping("/list")
    List<Employee> getEmployeesList() {
        return employeesBookService.getList();
    }
}
