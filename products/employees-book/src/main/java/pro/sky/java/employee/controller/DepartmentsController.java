package pro.sky.java.employee.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.service.DepartmentsService;

import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    final private DepartmentsService service;

    public DepartmentsController(DepartmentsService service) {
        this.service = service;
    }

    /**
     * @return Employee with minimum wage within department.
     **/
    @GetMapping("/{id}/min-salary")
    Employee getMinPaidEmployee(@PathVariable("id") Integer departmentId) {
        return service.findMinSalaryEmployeeInDepartment(departmentId);
    }

    /**
     * @return Employee with maximum wage within department.
     **/
    @GetMapping("/{id}/max-salary")
    Employee getMaxPaidEmployee(@PathVariable("id") Integer departmentId)  {
        return service.findMaxSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/{id}")
    Collection<Employee> dispatchGetAllEmployees(@PathVariable("id") Integer departmentId) {
        return service.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    Collection<Employee> getAllEmployeesByDepartments() {
        return service.getAllEmployeesByDepartments();
    }


}
