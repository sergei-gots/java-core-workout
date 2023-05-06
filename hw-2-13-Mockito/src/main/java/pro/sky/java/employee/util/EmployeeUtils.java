package pro.sky.java.employee.util;

import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.util.EmployeeKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class EmployeeUtils {

    private static final Random random = new Random();
    static double generateRandomSalary() {
        return 240_000 + 8_000 * random.nextInt(30);
    }

    static int generateRandomDepartmentId() {
        return random.nextInt(EmployeeConstants.DEPARTMENT_COUNT) + 1;
    }

    public static Map<String, Employee> generateEmployees() {

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
