package pro.sky.java.employee.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import pro.sky.java.employee.exceptions.DepartmentIsNotListedException;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.util.EmployeeValidator;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

     private EmployeeValidator employeeValidator;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    public static Stream<Arguments> getMaxSalaryTestParams() {
        return Stream.of(
                Arguments.of(1, "120 000,00 руб."),
                Arguments.of(2, "140 000,00 руб."),
                Arguments.of(3, "130 000,00 руб.")
        );
    }

    public static Stream<Arguments> getMinSalaryTestParams() {
        return Stream.of(
                Arguments.of(1, "110 001,00 руб."),
                Arguments.of(2, "130 000,00 руб."),
                Arguments.of(3, "130 000,00 руб.")
        );
    }

    public static Stream<Arguments> getSalarySumTestParams() {
        return Stream.of(
                Arguments.of(1, "230 001,00 руб."),
                Arguments.of(2, "270 000,00 руб."),
                Arguments.of(3, "130 000,00 руб.")
        );
    }

    public static Stream<Arguments> incorrectDepartmentIdTestParams() {
        return Stream.of(
                Arguments.of(-1, 0, 6, 11)
        );
    }

    @BeforeEach
    public void beroreEach() {
        when(employeeService.getAll())
                .thenReturn(List.of(
                    new Employee("John", "Johnson", 1, 110_001),
                    new Employee("Peter", "Peterson", 1, 120_000),
                    new Employee("Andrew", "Anderson", 2, 130_000),
                    new Employee("Andrew", "Anderson-the-Elder", 2, 140_000),
                    new Employee("Matthew", "Goode", 3, 130_000)
                ));
    }

    @Test
    public void getEmployeesTest() {
        Integer departmentId = 1;
        departmentService.getEmployees(departmentId);
    }

    @ParameterizedTest
    @MethodSource("getMaxSalaryTestParams")
    public void getMaxSalaryTest(int departmentId, String maxSalaryRub) {
        assertThat(departmentService.getMaxSalary(departmentId)).isEqualTo(maxSalaryRub);
    }

    @ParameterizedTest
    @MethodSource("getMinSalaryTestParams")
    public void getMinSalaryTest(int departmentId, String minSalaryRub) {
        assertThat(departmentService.getMinSalary(departmentId)).isEqualTo(minSalaryRub);
    }

    @ParameterizedTest
    @MethodSource("getSalarySumTestParams")
    public void getSalarySumTest(int departmentId, String salarySumRub) {
        assertThat(departmentService.getSalarySum(departmentId)).isEqualTo(salarySumRub);
    }

    @Test
    public void getAllEmployeesByDepartmentsTest() {
        Map<Integer, List<Employee>> employeesMap = departmentService.getAllEmployeesByDepartments();
    }

    @ParameterizedTest
    @MethodSource("incorrectDepartmentIdTestParams")
    public void getMaxSalaryWithIncorrectDepartmentId(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(()->departmentService.getMaxSalary(departmentId));
    }

    @ParameterizedTest
    @MethodSource("incorrectDepartmentIdTestParams")
    public void getMinSalaryWithIncorrectDepartmentId(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(()->departmentService.getMinSalary(departmentId));
    }

    @ParameterizedTest
    @MethodSource("incorrectDepartmentIdTestParams")
    public void getSalarySumWithIncorrectDepartmentId(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(()->departmentService.getSalarySum(departmentId));
    }
}
