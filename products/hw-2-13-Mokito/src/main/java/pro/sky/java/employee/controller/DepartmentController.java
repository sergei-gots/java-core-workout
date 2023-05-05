package pro.sky.java.employee.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    final private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }


    @GetMapping("/{id}/salary/min")
    String getMinSalaryInDepartment(@PathVariable("id") Integer departmentId) {
        return service.getMinSalaryInDepartment(departmentId);
    }

    /**
     * @return Employee with maximum wage within department.
     **/
    @GetMapping("/{id}/salary/max")
    String getMaxSalaryInDepartment(@PathVariable("id") Integer departmentId)  {
        return service.getMaxSalaryInDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    String getSalarySumInDepartment(@PathVariable("id") Integer departmentId) {
        return service.getSalarySumInDepartment(departmentId);
    }

    @GetMapping("/{id}/employees")
    Collection<Employee> getEmployees(@PathVariable("id") Integer departmentId) {
        return service.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("employees")
    Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return service.getAllEmployeesByDepartments();
    }


}
