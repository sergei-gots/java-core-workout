package pro.sky.java.employee.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.employee.exceptions.*;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.util.EmployeeValidator;
import pro.sky.java.employee.repository.EmployeesRepositoryImpl;
import pro.sky.java.employee.util.EmployeeConstants;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class EmployeeServiceImplTest {

    private final EmployeeValidator employeeValidator = new EmployeeValidator();
    private final EmployeeService employeeService
            = new EmployeeServiceImpl(EmployeesRepositoryImpl.getEmptyInstance(), employeeValidator);

    public static Stream<Arguments> addWithIncorrectFirstnameTestParams() {
        return Stream.of(
                Arguments.of("John1"),
                Arguments.of("Jo#hn"),
                Arguments.of("John$"),
                Arguments.of("John)"),
                Arguments.of(".John1")
        );
    }

    public static Stream<Arguments> addWithIncorrectSurnameTestParams() {
        return Stream.of(
                Arguments.of( "J1ohnson"),
                Arguments.of("Joh%nson"),
                Arguments.of( "Johnson^"),
                Arguments.of( "Johnson:)"),
                Arguments.of( "Johnson!")
        );
    }

    public static Stream<Arguments> addWithIncorrectDepartmentIdTestParams() {
        return Stream.of(
                Arguments.of( -1 ),
                Arguments.of( 0),
                Arguments.of( 6),
                Arguments.of( 7),
                Arguments.of( 11 )
        );
    }

    public static Stream<Arguments> addWithIncorrectSalaryTestParams() {
        return Stream.of(
                Arguments.of(new BigDecimal(-100_000) ),
                Arguments.of(new BigDecimal("0.01") ),
                Arguments.of(new BigDecimal("99999.99") ),
                Arguments.of(new BigDecimal(55_000) ),
                Arguments.of(new BigDecimal(95_000) )
        );
    }

    @BeforeEach
    public void beforeEach() {
        employeeService.add(List.of(
                new Employee("John", "Johnson",
                1, new BigDecimal(100_001)),
                new Employee("Peter", "Peterson",
                1, new BigDecimal(120_000))));
    }

    @Test
    public void addTest() {
        int beforeCount = employeeService.getAll().size();
        Employee employee = new Employee("Andrew", "Anderson-the-Elder",
                2, new BigDecimal(130_000));
        employeeService.add(employee);
        Employee actual = employeeService.get(employee.getId());
        assertThat(actual).usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(employee).ignoringFields("id")
                .isIn(employeeService.getAll());
        assertThat(employeeService.getAll().size()).isEqualTo(beforeCount+1);
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectFirstnameTestParams")
    public void addWithIncorrectFirstnameTest(String firstName) {
        assertThatExceptionOfType(IncorrectNameException.class)
                .isThrownBy(()->employeeService.add(new Employee(firstName, "Johnson",
                        1, new BigDecimal(100_000))));
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectSurnameTestParams")
    public void addWithIncorrectSurnameTest(String lastName) {
        assertThatExceptionOfType(IncorrectSurnameException.class)
                .isThrownBy(()->employeeService.add(new Employee("John",  lastName,
                        1, new BigDecimal(100_000))));
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectDepartmentIdTestParams")
    public void addWithIncorrectDepartmentIdTest(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(()->employeeService.add(new Employee("John", "Johnson",
                        departmentId, new BigDecimal(100_000))));
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectSalaryTestParams")
    public void addWithSalaryTest(BigDecimal salary) {
        assertThatExceptionOfType(SalaryIsTooLowException.class)
                .isThrownBy(() -> employeeService.add(
                        new Employee("John", "Johnson", 1,  salary)));
    }

    @Test
    public void addEmployeeWhenStorageIsFullTest() {
        //GIVEN
        char suffix = 'a';
        while(employeeService.getAll().size() < EmployeeConstants.EMPLOYEES_MAX_COUNT) {
            employeeService.add(new Employee("John", "Johnson-" + suffix,
                    1, new BigDecimal(100_001)));
            suffix++;
        }
        //THEN
        assertThat(employeeService.getAll().size()).isEqualTo(EmployeeConstants.EMPLOYEES_MAX_COUNT);
        assertThatExceptionOfType(EmployeeStorageIsFullException.class)
                .isThrownBy(()->employeeService.add(new Employee("John", "Johnson-the-Next",
                        1, new BigDecimal(100_001))));
    }

    @Test
    public void removeTest() {
        //GIVEN
        final int targetId = employeeService.getAll().stream().findFirst().get().getId();
        Employee expected = employeeService.get(targetId);

        int beforeCount = employeeService.getAll().size();
        //WHEN
        Employee actual = employeeService.remove(targetId);
        //THEN
        assertThat(employeeService.getAll().size())
                .isEqualTo(beforeCount-1);
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected)
                .isNotIn(employeeService.getAll());

   }

    @Test
    public void removeWhenEmployeeNotFoundTest() {
        //GIVEN
        final int beforeCount = employeeService.getAll().size();
        //THEN
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.remove(beforeCount));
        assertThat(employeeService.getAll().size())
                .isEqualTo(beforeCount);
    }


    @Test
    public void findWhenEmployeeNotFoundTest() {
        //GIVEN
        final int beforeCount = employeeService.getAll().size();
        //THEN
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.get(beforeCount+1));
        assertThat(employeeService.getAll().size())
                .isEqualTo(beforeCount);
    }

    @Test
    public void getAllTest() {
        //THEN
        assertThat(employeeService.getAll())
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsExactlyInAnyOrderElementsOf(List.of(
                        new Employee("John", "Johnson", 1, new BigDecimal(100_001)),
                        new Employee("Peter", "Peterson", 1, new BigDecimal(120_000))
                        )
                );
        assertThat(employeeService.getAll().size()).isEqualTo(2);
    }

}
