package pro.sky.java.employee.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.repository.EmployeesRepositoryImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeeServiceImplTest {

    private final EmployeeService employeeService
            = new EmployeeServiceImpl(EmployeesRepositoryImpl.getEmptyInstance());

    @BeforeEach
    public void beforeEach() {
        employeeService.add("John", "Johnson", 1, 100_001);
        employeeService.add("Peter", "Peterson", 2, 120_000);

    }
    @Test
    public void addTest() {
        Employee expected = new Employee("Andrew", "Anderson", 3, 130_000);
        int beforeCount = employeeService.getAll().size();
        Employee actual =  employeeService.add("Andrew", "Anderson", 3, 130_000);
        assertThat(actual).usingRecursiveComparison()
                .comparingOnlyFields("firstName", "lastName", "departmentId", "salary")
                .isEqualTo(expected)
                .isIn(employeeService.getAll());
        assertThat(employeeService.getAll().size()).isEqualTo(beforeCount+1);
    }
}
