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

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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
                Arguments.of(-100_000 ),
                Arguments.of(0 ),
                Arguments.of(99_999 ),
                Arguments.of(55_000 ),
                Arguments.of(95_000 )
        );
    }

    @BeforeEach
    public void beforeEach() {
        employeeService.add("John", "Johnson", 1, 100_001);
        employeeService.add("Peter", "Peterson", 2, 120_000);

    }

    @Test
    public void addTest() {
        Employee expected = new Employee("Andrew", "Anderson-the-Elder", 3, 130_000);
        int beforeCount = employeeService.getAll().size();
        Employee actual =  employeeService.add("Andrew", "Anderson-the-Elder", 3, 130_000);
        assertThat(actual).usingRecursiveComparison()
                .comparingOnlyFields("firstName", "lastName", "departmentId", "salary")
                .isEqualTo(expected)
                .isIn(employeeService.getAll());
        assertThat(employeeService.getAll().size()).isEqualTo(beforeCount+1);
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectFirstnameTestParams")
    public void addWithIncorrectFirstnameTest(String firstName) {
        assertThatExceptionOfType(IncorrectNameException.class)
                .isThrownBy(()->employeeService.add(firstName, "Johnson", 1, 100_000));
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectSurnameTestParams")
    public void addWithIncorrectSurnameTest(String lastName) {
        assertThatExceptionOfType(IncorrectSurnameException.class)
                .isThrownBy(()->employeeService.add("John",  lastName, 1, 100_000));
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectDepartmentIdTestParams")
    public void addWithIncorrectDepartmentIdTest(int departmentId) {
        assertThatExceptionOfType(DepartmentIsNotListedException.class)
                .isThrownBy(()->employeeService.add("John", "Johnson", departmentId, 100_000));
    }

    @ParameterizedTest
    @MethodSource("addWithIncorrectSalaryTestParams")
    public void addWithSalaryTest(double salary) {
        assertThatExceptionOfType(SalaryIsTooLowException.class)
                .isThrownBy(() -> employeeService.add("John", "Johnson", 1,  salary));
    }

    @Test
    public void addEmployeeWhichAlreadyExistsTest() {
        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(()->employeeService.add("John", "Johnson", 1, 100_001));
    }

    @Test
    public void addEmployeeWhenStorageIsFullTest() {
        //GIVEN
        char suffix = 'a';
        while(employeeService.getAll().size() < EmployeeConstants.EMPLOYEES_MAX_COUNT) {
            employeeService.add("John", "Johnson-" + suffix, 1, 100_001);
            suffix++;
        }
        //THEN
        assertThat(employeeService.getAll().size()).isEqualTo(EmployeeConstants.EMPLOYEES_MAX_COUNT);
        assertThatExceptionOfType(EmployeeStorageIsFullException.class)
                .isThrownBy(()->employeeService.add("John", "Johnson-the-Next", 1, 100_001));
    }

    @Test
    public void removeTest() {
        //GIVEN
        Employee expected = new Employee("John", "Johnson", 1, 100_001);
        int beforeCount = employeeService.getAll().size();
        //WHEN
        Employee actual = employeeService.remove("John", "Johnson");
        //THEN
        assertThat(actual)
                .usingRecursiveComparison()
                .comparingOnlyFields("firstName", "lastName", "departmentId", "salary")
                .isEqualTo(expected)
                .isNotIn(employeeService.getAll());
        assertThat(employeeService.getAll().size())
                .isEqualTo(beforeCount-1);
   }

    @Test
    public void removeWhenEmployeeNotFoundTest() {
        //GIVEN
        int beforeCount = employeeService.getAll().size();
        //THEN
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.remove("John", "Johnson-the-Younger"));
        assertThat(employeeService.getAll().size())
                .isEqualTo(beforeCount);
    }

    @Test
    public void findTest() {
        //GIVEN
        Employee expected = new Employee("John", "Johnson", 1, 100_001);
        int beforeCount = employeeService.getAll().size();
        //WHEN
        Employee actual = employeeService.find("John", "Johnson");
        //THEN
        assertThat(actual)
                .usingRecursiveComparison()
                .comparingOnlyFields("firstName", "lastName", "departmentId", "salary")
                .isEqualTo(expected)
                .isIn(employeeService.getAll());
        assertThat(employeeService.getAll().size())
                .isEqualTo(beforeCount);
    }

    @Test
    public void findWhenEmployeeNotFoundTest() {
        //GIVEN
        int beforeCount = employeeService.getAll().size();
        //THEN
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> employeeService.find("John", "Johnson-the-Younger"));
        assertThat(employeeService.getAll().size())
                .isEqualTo(beforeCount);
    }

    @Test
    public void getAllTest() {
        //THEN
        assertThat(employeeService.getAll())
                .usingRecursiveComparison()
                .comparingOnlyFields(
                        "firstName," +
                        "lastName",
                        "departmentId",
                        "salary")

                .asList()
                .containsExactlyInAnyOrderElementsOf(List.of(
                        new Employee("John", "Johnson", 1, 100_001),
                        new Employee("Peter", "Peterson", 2, 120_000)
                        )
                );
        assertThat(employeeService.getAll().size()).isEqualTo(2);
    }
}
