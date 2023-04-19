package pro.sky.java.course_2_core.hw_2_8_emplbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course_2_core.employee.model.Employee;
import pro.sky.java.course_2_core.hw_2_8_emplbook.service.EmployeesBookService;


import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    final private EmployeesBookService service;

    public DepartmentsController(EmployeesBookService employeesBookService) {
        this.service = employeesBookService;
    }

    /**
     *  @return Employee with minimum wage within department.
     **/
    @GetMapping("/min-salary")
    Employee getMinPaidEmployee(int departmentId) {
        return service.findMinPaidEmployeeInDepartment(departmentId);
    }

    /**
     *  @return Employee with maximum wage within department.
     **/
    @GetMapping("/max-salary")
    Employee getMaxPaidEmployee(int departmentId) {
        return service.findMaxPaidEmployeeInDepartment(departmentId);
    }

    /**
     *  @return list of employees in department.
     **/
    @GetMapping("/all")
    Collection<Employee> getEmployeesByDepartment(int departmentId) {
        return service.getEmployeesByDepartment(departmentId);
    }



}
