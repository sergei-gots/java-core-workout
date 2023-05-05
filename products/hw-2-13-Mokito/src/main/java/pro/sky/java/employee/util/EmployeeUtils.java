package pro.sky.java.employee.util;

import pro.sky.java.employee.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class EmployeeUtils {
    public static final int DEPARTMENT_COUNT = 5;
    private static final Random random = new Random();

    public static void validateDepartment(int departmentId) {
        if (departmentId < 1 || departmentId > DEPARTMENT_COUNT) {
            throw new IllegalArgumentException("Department with number " + departmentId + " is not listed.");
        }
    }
    static double generateRandomSalary() {
        return 240_000 + 8_000 * random.nextInt(30);
    }

    static int generateRandomDepartmentId() {
        return random.nextInt(DEPARTMENT_COUNT) + 1;
    }

    public static Map<String, Employee> generateEmployees() {
        class EmployeeKey {
            private final String firstName;
            private final String lastName;
            public EmployeeKey(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
            public String getFirstName() {
                return firstName;
            }
            public String getLastName() {
                return lastName;
            }
            public String getKey() {
                return firstName + lastName;
            }
        }
        List<EmployeeKey> names = List.of(
                new EmployeeKey("Аполлон", "Майков"),
                new EmployeeKey("Афанасий", "Никитин"),
                new EmployeeKey("Антон", "Чехов"),
                new EmployeeKey("Михаил", "Глинка"),
                new EmployeeKey("Иван", "Павлов"),
                new EmployeeKey("Лев", "Ландау"),
                new EmployeeKey("Сергей", "Рахманинов"),
                new EmployeeKey("Павел", "Черенков"));
        Map<String, Employee> employees = new HashMap<>();
        for (EmployeeKey name : names) {
            employees.put(name.getKey(),
                    new Employee(name.getFirstName(),
                            name.getLastName(),
                            generateRandomDepartmentId(),
                            generateRandomSalary()));
        }
        return employees;
    }
}
