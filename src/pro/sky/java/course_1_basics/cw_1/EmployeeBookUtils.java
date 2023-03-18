package pro.sky.java.course_1_basics.cw_1;

import java.util.Random;

final class EmployeeBookUtils {
    public static final int DEPARTMENT_COUNT = 5;
    public static final int EMPLOYEES_COUNT = 10;
    private static final Random random = new Random();

    public static int generateRandomSalaryIndexingPercentage() {
        int minPercentage = 10;
        return minPercentage + random.nextInt(20);
    }

    static double generateRandomSalary() {
        return 230_000 + 8_000 * random.nextInt(8);
    }

    static int generateRandomDepartmentId() {
        return random.nextInt(DEPARTMENT_COUNT) + 1;
    }

    public static void recruitEmployees(EmployeeBook employeeBook) {
        employeeBook.addEmployee("Майков-Никитин А.Н.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Чехов А.П.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Нефёдов-Эрьзя C.Д.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Понятов А.М.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Майков-Никитин А.Н.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Глинка М.И.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Павлов И.П.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Ландау Л.Д.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Рахманинов С.В.", generateRandomDepartmentId(), generateRandomSalary());
        employeeBook.addEmployee("Черенков П.А.", generateRandomDepartmentId(), generateRandomSalary());

    }

}
