package pro.sky.java.course_1.cw_1;

import static java.lang.System.out;
import static pro.sky.java.course_1.cw_1.EmployeeBookUtils.*;

public class Cw_1 {
    static final boolean isBasicTask = false;
    static final boolean isIncreasedComplexityTask = false;
    static final boolean isVeryDifficultTask = true;

    static pro.sky.java.course_1.cw_1.EmployeeBook employeeBook = new EmployeeBook();

    public static void main(String[] args) {
        out.println("Курсовая работа # 1. \"Информация о сотрудниках компании\".\n");

        pro.sky.java.course_1.cw_1.EmployeeBookUtils.recruitEmployees(employeeBook);

        if (isBasicTask) {
            doBasicTask();
        }
        if (isIncreasedComplexityTask) {
            doIncreasedComplexityTask();
        }
        if (isVeryDifficultTask) {
            doVeryDifficultTask();
        }
    }

    private static void doVeryDifficultTask() {

        employeeBook.printEmployeesList();
        employeeBook.removeEmployeeByFullName("Глинка М.И.");
        employeeBook.removeEmployeeById(7);
        employeeBook.printEmployeesList();

        String fullNameToAdd1 = "Семёнов Н.Н.";
        String fullNameToAdd2 = "Тамм И.Е.";
        String fullNameToAdd3 = "Lorem Ipsum";

        showTestTryToAddEmployee(fullNameToAdd1);
        showTestTryToAddEmployee(fullNameToAdd2);
        showTestTryToAddEmployee(fullNameToAdd3);


        employeeBook.printEmployeesByDepartments();
        employeeBook.printEmployeesList();

        employeeBook.changeDepartment(fullNameToAdd1, 1);
        employeeBook.changeSalary(fullNameToAdd2, 430_000.00);
        employeeBook.changeSalary(fullNameToAdd3, -10_000.00);

        try {
            employeeBook.changeDepartment(fullNameToAdd1, 0);
        } catch (IllegalArgumentException e) {
            out.println(e);
        }

        try {
            employeeBook.changeSalary(fullNameToAdd2, 95_000.00);
        } catch (IllegalArgumentException e) {
            out.println(e);
        }

        employeeBook.printEmployeesList();
    }

    private static void showTestTryToAddEmployee(String fullName) {
        boolean isAdded = employeeBook.addEmployee(fullName, 2, generateRandomSalary());
        out.println("\nМетод EmployeeBook.addEmployee возвратил " + isAdded);
        if (isAdded) {
            out.println("Это значит, добавление прошло успешно");
        }   else {
            out.println("Это значит, что добавления не произошло. И скорее всего потому, что массив сотрудников заполнен.");
            out.println(" Проверим: ");
        }
        out.println("Количество сотрудников в компании = " + employeeBook.getEmployeesCount());
        out.println();
    }

    private static void doBasicTask() {
        employeeBook.printEmployeesList();
        employeeBook.printMonthlyPayroll();
        employeeBook.printMinWageEmployeeInfo();
        employeeBook.printMaxWageEmployeeInfo();
        employeeBook.printAverageSalary();
        employeeBook.printFullNamesList();
    }

    private static void doIncreasedComplexityTask() {

        employeeBook.printEmployeesList();
        employeeBook.indexSalary(generateRandomSalaryIndexingPercentage());
        employeeBook.printEmployeesList();

        int departmentId;
        do {
            departmentId = generateRandomDepartmentId();
        } while (employeeBook.isDepartmentEmpty(departmentId));

        employeeBook.printMinWageEmployeeInDepartment(departmentId);
        employeeBook.printMaxWageEmployeeInDepartment(departmentId);
        employeeBook.printAverageSalaryInDepartment(departmentId);
        employeeBook.printMonthlyPayrollInDepartment(departmentId);
        employeeBook.printEmployeesListInDepartment(departmentId);
        employeeBook.indexSalaryInDepartment(departmentId, generateRandomSalaryIndexingPercentage());
        employeeBook.printEmployeesListInDepartment(departmentId);
        employeeBook.printAverageSalaryInDepartment(departmentId);
        employeeBook.printMonthlyPayrollInDepartment(departmentId);
        double averageSalary = employeeBook.calcAverageSalary();
        employeeBook.printEmployeesWithSalaryLessThan(averageSalary);
        employeeBook.printEmployeesWithSalaryGreaterOrEqualTo(averageSalary);
        employeeBook.printEmployeesWithSalaryLessThan(0);
    }
}