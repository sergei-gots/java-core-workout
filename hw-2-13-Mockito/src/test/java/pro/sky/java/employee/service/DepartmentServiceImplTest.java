package pro.sky.java.employee.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.employee.exceptions.DepartmentIsNotListedException;
import pro.sky.java.employee.exceptions.ThereAreNoEmployeesInDepartmentException;
import pro.sky.java.employee.model.Employee;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;


    private final List<Employee> testEmployeeList = List.of(
            new Employee("John", "Johnson",
                    1, new BigDecimal(110_001)),
            new Employee("Peter", "Peterson",
                    1, new BigDecimal(120_000)),
            new Employee("Andrew", "Anderson",
                    2, new BigDecimal(130_000)),
            new Employee("Andrew", "Anderson-the-Elder",
                    2, new BigDecimal(140_000)),
            new Employee("Matthew", "Goode",
                    3, new BigDecimal(130_000))
    );


    @Test
    public void getEmployeesTest() {
        when(employeeService.getAll()).thenReturn(testEmployeeList);

        Collection<Employee> actual = employeeService.getAll();
        assertThat(actual.size()).isEqualTo(5);
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .isEqualTo(List.of(
                        new Employee("John", "Johnson",
                                1, new BigDecimal(110_001)),
                        new Employee("Peter", "Peterson",
                                1, new BigDecimal(120_000)),
                        new Employee("Andrew", "Anderson",
                                2, new BigDecimal(130_000)),
                        new Employee("Andrew", "Anderson-the-Elder",
                                2, new BigDecimal(140_000)),
                        new Employee("Matthew", "Goode",
                                3, new BigDecimal(130_000))
                ));
    }

    @Test
    public void test_getAllEmployeesByDepartments() {
        when(employeeService.getAll()).thenReturn(testEmployeeList);
        Map<Integer, List<Employee>> employeesMap
                = departmentService.getAllEmployeesByDepartments();
        assertThat(employeesMap.size())
                .isEqualTo(3);
        assertThat(employeesMap.containsKey(1)).isTrue();
        assertThat(employeesMap.containsKey(2)).isTrue();
        assertThat(employeesMap.containsKey(3)).isTrue();
        List<Employee> listActual1 = employeesMap.get(1);
        List<Employee> listActual2 = employeesMap.get(2);
        List<Employee> listActual3 = employeesMap.get(3);
        assertThat(listActual1.size()).isEqualTo(2);
        assertThat(listActual1)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsExactlyInAnyOrderElementsOf(List.of(
                        new Employee("John", "Johnson",
                                1, new BigDecimal(110_001)),
                        new Employee("Peter", "Peterson",
                                1, new BigDecimal(120_000))
                ));
        assertThat(listActual2.size()).isEqualTo(2);
        assertThat(listActual2)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsExactlyInAnyOrderElementsOf(List.of(
                        new Employee("Andrew", "Anderson",
                                2, new BigDecimal(130_000)),
                        new Employee("Andrew", "Anderson-the-Elder",
                                2, new BigDecimal(140_000)))
                );
        assertThat(listActual3.size()).isEqualTo(1);
        assertThat(listActual3)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsExactlyInAnyOrderElementsOf(List.of(
                        new Employee("Matthew", "Goode",
                                3, new BigDecimal(130_000))));

    }

    public static Stream<Arguments> getEmployeesTestParams() {
        return Stream.of(
                Arguments.of(1, List.of(
                        new Employee("John", "Johnson",
                                1, new BigDecimal(110_001)),
                        new Employee("Peter", "Peterson",
                                1, new BigDecimal(120_000)))
                ),
                Arguments.of(2, List.of(
                        new Employee("Andrew", "Anderson",
                                2, new BigDecimal(130_000)),
                        new Employee("Andrew", "Anderson-the-Elder",
                                2, new BigDecimal(140_000)))
                ),
                Arguments.of(3, List.of(
                        new Employee("Matthew", "Goode",
                                3, new BigDecimal(130_000)))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getEmployeesTestParams")
    void getEmployees(Integer departmentId, Collection<Employee> employeesExpected) {
        when(employeeService.getAll()).thenReturn(testEmployeeList);
        Collection<Employee> actual = departmentService.getEmployees(departmentId);
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsExactlyInAnyOrderElementsOf(employeesExpected);
        Employee changedOne = employeesExpected.stream().findFirst().orElseThrow();
        changedOne.setSalary(new BigDecimal("500000"));
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .doesNotContain(changedOne);

    }

    public static Stream<Arguments> getMaxSalary_testParams() {
        return Stream.of(
                Arguments.of(1, "120 000.00 руб."),
                Arguments.of(2, "140 000.00 руб."),
                Arguments.of(3, "130 000.00 руб.")
        );
    }

    @ParameterizedTest
    @MethodSource("getMaxSalary_testParams")
    public void test_getMaxSalary(int departmentId, String maxSalaryRub) {
        when(employeeService.getAll()).thenReturn(testEmployeeList);
        assertThat(departmentService.getMaxSalary(departmentId)).isEqualTo(maxSalaryRub);
    }

    public static Stream<Arguments> getMinSalary_testParams() {
        return Stream.of(
                Arguments.of(1, "110 001.00 руб."),
                Arguments.of(2, "130 000.00 руб."),
                Arguments.of(3, "130 000.00 руб.")
        );
    }

    @ParameterizedTest
    @MethodSource("getMinSalary_testParams")
    public void test_getMinSalary(int departmentId, String minSalaryRub) {
        when(employeeService.getAll()).thenReturn(testEmployeeList);
        assertThat(departmentService.getMinSalary(departmentId)).isEqualTo(minSalaryRub);
    }

    public static Stream<Arguments> getSalarySum_testParams() {
        return Stream.of(
                Arguments.of(1, "230 001.00 руб."),
                Arguments.of(2, "270 000.00 руб."),
                Arguments.of(3, "130 000.00 руб.")
        );
    }

    @ParameterizedTest
    @MethodSource("getSalarySum_testParams")
    public void test_getSalarySum(int departmentId, String salarySumRub) {
        when(employeeService.getAll()).thenReturn(testEmployeeList);
        assertThat(departmentService.getSalarySum(departmentId)).isEqualTo(salarySumRub);
    }

    public static Stream<Arguments> departmentIsEmptyId_testParams() {
        return Stream.of(
                Arguments.of(4),
                Arguments.of(5)
        );
    }

    @ParameterizedTest
    @MethodSource("departmentIsEmptyId_testParams")
    public void test_getSalarySum_whenDepartmentIsEmpty(int departmentId) {
        assertThatExceptionOfType(ThereAreNoEmployeesInDepartmentException.class)
                .isThrownBy(() -> departmentService.getMaxSalary(departmentId));
    }


    @ParameterizedTest
    @MethodSource("departmentIsEmptyId_testParams")
    public void test_getMaxSalary_whenDepartmentIsEmpty(int departmentId) {
        assertThatExceptionOfType(ThereAreNoEmployeesInDepartmentException.class)
                .isThrownBy(() -> departmentService.getMaxSalary(departmentId));
    }

    @ParameterizedTest
    @MethodSource("departmentIsEmptyId_testParams")
    public void test_getMinSalary_whenDepartmentIsEmpty(int departmentId) {
        assertThatExceptionOfType(ThereAreNoEmployeesInDepartmentException.class)
                .isThrownBy(() -> departmentService.getMinSalary(departmentId));
    }

    public static Stream<Arguments> incorrectDepartmentId_testParams() {
        return Stream.of(
                Arguments.of(-2),
                Arguments.of(-1),
                Arguments.of(6),
                Arguments.of(11)
        );
    }

    @ParameterizedTest
    @MethodSource("incorrectDepartmentId_testParams")
    public void test_getMaxSalary_when_incorrectDepartmentId(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(() -> departmentService.getMaxSalary(departmentId));
    }

    @ParameterizedTest
    @MethodSource("incorrectDepartmentId_testParams")
    public void test_getMinSalary_when_incorrectDepartmentId(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(() -> departmentService.getMinSalary(departmentId));
    }

    @ParameterizedTest
    @MethodSource("incorrectDepartmentId_testParams")
    public void test_getSalarySum_when_incorrectDepartmentId(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(() -> departmentService.getSalarySum(departmentId));
    }

}
