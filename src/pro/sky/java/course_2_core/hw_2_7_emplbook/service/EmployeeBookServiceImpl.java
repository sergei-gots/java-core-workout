package pro.sky.java.course_2_core.hw_2_7_emplbook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course_2_core.hw_2_7_emplbook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course_2_core.hw_2_7_emplbook.exceptions.EmployeeNotFoundException;
import pro.sky.java.course_2_core.hw_2_7_emplbook.model.Employee;
import pro.sky.java.course_2_core.hw_2_7_emplbook.EmployeeBookUtils;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static pro.sky.java.course_2_core.hw_2_7_emplbook.EmployeeBookUtils.*;

@Service
public class EmployeeBookServiceImpl implements EmployeesBookService{

    private final Map <String, Employee> employees;

    public EmployeeBookServiceImpl() {
        employees = EmployeeBookUtils.generateEmployees();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(employees.containsKey(employee.key())) {
            throw new EmployeeAlreadyAddedException();
        }
        return employees.put(employee.key(), employee);
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        final String key = employee.key();
        final Employee employeeToRemove = employees.get(key);
        if(employeeToRemove == null) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(key);
        return employeeToRemove;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        final Employee foundEmployee = employees.get(employee.key());
        if(foundEmployee == null) {
            throw new EmployeeNotFoundException();
        }
        return foundEmployee;
    }

    @Override
    public List<Employee> getList() {
        return List.copyOf(employees.values());
    }

    private static void checkDepartmentId(int departmentId) {
        if (departmentId < 1 || departmentId > DEPARTMENT_COUNT) {
            throw new IllegalArgumentException("Задан несуществующий номер отдела: " + departmentId);
        }
    }


    /**
     * @param newSalary .
     * @return employee whose salary was successfully changed or null if there is no such employee with
     * specified fullName
     */
    public Employee changeSalary(Employee employee, double newSalary) {
        Employee employeeToUpdate = employees.get(employee.key());
        if (employeeToUpdate == null) {
            throw new EmployeeNotFoundException();
        }
        String currentSalary = employee.getSalary();
        employee.setSalary(newSalary);
        out.println("Зарплата сотрудника с Ф.И.О. " + employee.getName() + " изменена с " +
                currentSalary + " на " + employee.getSalary());
        return employeeToUpdate;
    }

    public void printEmployeesByDepartments() {
        out.println("Списки сотрудников компании по отделам.");
        for (int i = 1; i <= DEPARTMENT_COUNT; i++) {
            printEmployeesListInDepartment(i);
        }
    }

    public Employee changeDepartment(Employee employee, int newDepartmentId) {
        checkDepartmentId(newDepartmentId);
        Employee employeeToUpdate = employees.get(employee.key());
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        employee.setDepartmentId(newDepartmentId);
        return employeeToUpdate;
    }


    public void printAverageSalaryInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        out.print("Средняя зарплата в " + departmentId + "-м отделе составляет "
                + Employee.formatSalary(calcAverageSalaryInDepartment(departmentId)) + "\n\n");
    }

    public void printMaxWageEmployeeInDepartment(int departmentId) {
        Employee employee = findMaxWageEmployeeInDepartment(departmentId);
        out.println("Сотрудник с максимальной зарплатой в " + departmentId + "-м отделе:");
        out.print("\t" + employee.firstName());
        out.print(" Зарплата составляет " + employee.getSalary());
        out.print("\n\n");
    }

    public void printMinWageEmployeeInDepartment(int departmentId) {
        Employee employee = findMinWageEmployeeInDepartment(departmentId);
        out.println("Сотрудник с минимальной зарплатой в " + departmentId + "-м отделе:");
        out.print("\t" + employee.firstName());
        out.print(" Зарплата составляет " + employee.getSalary());
        out.print("\n\n");
    }

    public void printEmployeesWithSalaryGreaterOrEqualTo(double targetSalary) {
        out.println("Список сотрудников с зарплатой, равной или превышающей " + Employee.formatSalary(targetSalary) + ':');
        boolean areFound = false;
        for (Employee employee : employees.values()) {
            if (employee != null && employee.salary() >= targetSalary) {
                areFound = true;
                out.println(employee.toString());
            }
        }
        if (!areFound) {
            out.println("\tтаковых сотрудников не найдено.");
        }
        out.println();
    }

    public void printEmployeesWithSalaryLessThan(double targetSalary) {
        out.println("Список сотрудников с зарплатой, меньшей чем " + Employee.formatSalary(targetSalary) + ':');
        boolean areFound = false;
        for (Employee employee : employees.values()) {
            if (employee != null && employee.salary() < targetSalary) {
                out.println(employee.toString());
            }
        }
        if (!areFound) {
            out.println("\tтаковых сотрудников не найдено.");
        }
        out.println();
    }

    public void printEmployeesListInDepartment(int departmentId) {
        boolean departmentIsEmpty = true;
        checkDepartmentId(departmentId);
        out.println("Список сотрудников " + departmentId + "-го отдела:");
        for (Employee employee : employees.values()) {
            if (employee != null && departmentId == employee.getDepartmentId()) {
                out.println(employee.toString());
                departmentIsEmpty = false;
            }
        }
        if(departmentIsEmpty) {
            out.println("Сотрудников в отделе на данный момент нет.\n");
        }
        out.println();
    }

    public void indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage) {
        out.println("Индексация зарплаты.");
        checkDepartmentId(departmentId);
        out.print("Производится индексация зарплаты для всех сотрудников " + departmentId + "-го отдела.");
        out.println("Увеличение составит " + salaryIndexationPercentage + "%.");

        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        for (Employee employee : employees.values()) {
            if (employee != null && departmentId == employee.getDepartmentId()) {
                employee.setSalary(employee.salary() * salaryMultiplier);
            }

        }
        out.println();
    }

    public void indexSalary(int salaryIndexationPercentage) {
        out.println("Индексация зарплаты.");
        out.print("Производится индексация зарплаты для всех сотрудников компании.");
        out.println("Увеличение составит " + salaryIndexationPercentage + "%.");

        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        for (Employee employee : employees.values()) {
            if (employee != null) {
                employee.setSalary(employee.salary() * salaryMultiplier);
            }
        }

        out.println();
    }

    public double calcAverageSalaryInDepartment(int departmentId) {
        double sum = 0;
        int count = 0;
        checkDepartmentId(departmentId);

        for (Employee employee : employees.values()) {
            if (employee != null && employee.getDepartmentId() == departmentId) {
                count++;
                sum += employee.salary();
            }
        }
        return sum / count;
    }

    public Employee findMaxWageEmployeeInDepartment(int departmentId) {
        double maxWage = Double.MIN_VALUE;
        Employee employeeWithMaxWage = null;
        for (Employee employee : employees.values()) {
            if (employee != null && employee.getDepartmentId() == departmentId
                    && employee.salary() > maxWage) {
                maxWage = employee.salary();
                employeeWithMaxWage = employee;
            }
        }
        return employeeWithMaxWage;
    }

    public Employee findMinWageEmployeeInDepartment(int departmentId) {
        double minWage = Double.MAX_VALUE;
        Employee employeeWithMinWage = null;
        for (Employee employee : employees.values()) {
            if (employee != null
                    && employee.getDepartmentId() == departmentId
                    && employee.salary() < minWage) {
                minWage = employee.salary();
                employeeWithMinWage = employee;
            }
        }
        return employeeWithMinWage;
    }

    public void printAverageSalary() {
        out.println("Средняя зарплата по компании составляет " + Employee.formatSalary(calcAverageSalary()));
        out.println();
    }

    public void printMaxWageEmployeeInfo() {
        out.print("Сотрудник с максимальной зарплатой:\n\t");
        out.println(findMaxWageEmployee());
        out.println();
    }

    public void printMinWageEmployeeInfo() {
        out.print("Сотрудник с минимальной зарплатой:\n\t");
        out.println(findMinWageEmployee());
        out.println();
    }

    public void printMonthlyPayroll() {
        out.println("Cумма затрат на зарплаты в компании за месяц составляет "
                + Employee.formatSalary(calcMonthlyPayroll()));
        out.println();
    }

    public void printMonthlyPayrollInDepartment(int departmentId) {
        out.println("Cумма затрат на зарплаты в " + departmentId + "-м отделе за месяц составляет "
                + Employee.formatSalary(calcMonthlyPayrollInDepartment(departmentId)));
        out.println();
    }

    public double calcAverageSalary() {
        return (employees.size()== 0) ? 0 : calcMonthlyPayroll() / employees.size();

    }

    public Employee findMinWageEmployee() {
        double minWage = Double.MAX_VALUE;
        Employee employeeWithMinWage = null;
        for (Employee employee : employees.values()) {
            if (employee != null && minWage > employee.salary()) {
                minWage = employee.salary();
                employeeWithMinWage = employee;
            }
        }
        return employeeWithMinWage;
    }

    public Employee findMaxWageEmployee() {
        double maxWage = Double.MIN_VALUE;
        Employee employeeWithMaxWage = null;
        for (Employee employee : employees.values()) {
            if (employee != null && maxWage < employee.salary()) {
                maxWage = employee.salary();
                employeeWithMaxWage = employee;
            }
        }
        return employeeWithMaxWage;
    }

    public double calcMonthlyPayrollInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee != null && employee.getDepartmentId() == departmentId) {
                sum += employee.salary();
            }
        }
        return sum;
    }

    public double calcMonthlyPayroll() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee != null) {
                sum += employee.salary();
            }
        }
        return sum;
    }

    public void printEmployeesList() {
        out.println("\nСводка по сотрудникам:");
        for (Employee employee : employees.values()) {
            if (employee != null) {
                out.println(employee);
            }
        }
        out.println();
    }
}
