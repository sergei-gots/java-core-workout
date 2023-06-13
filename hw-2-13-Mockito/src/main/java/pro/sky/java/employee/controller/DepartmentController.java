package pro.sky.java.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    final private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }


    @GetMapping("/{id}/salary/min")
    String getMinSalaryInDepartment(@PathVariable("id") Integer departmentId) {
        return service.getMinSalary(departmentId);
    }

    /**
     * @return Employee with maximum wage within department.
     **/
    @GetMapping("/{id}/salary/max")
    String getMaxSalaryInDepartment(@PathVariable("id") Integer departmentId)  {
        return service.getMaxSalary(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    String getSalarySumInDepartment(@PathVariable("id") Integer departmentId) {
        return service.getSalarySum(departmentId);
    }

    @GetMapping("/{id}/employees")
    Collection<Employee> getEmployees(@PathVariable("id") Integer departmentId) {
        return service.getEmployees(departmentId);
    }

    @GetMapping("/all")
    Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return service.getAllEmployeesByDepartments();
    }


}
