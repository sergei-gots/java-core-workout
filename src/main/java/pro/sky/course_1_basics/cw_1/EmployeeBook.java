package pro.sky.course_1_basics.cw_1;

import static java.lang.System.out;
import static pro.sky.course_1_basics.cw_1.EmployeeBookUtils.DEPARTMENT_COUNT;
import static pro.sky.course_1_basics.cw_1.EmployeeBookUtils.EMPLOYEES_COUNT;

public class EmployeeBook {
    private final Employee[] employees;
    /** Must be incremented within any method which adds an employee in case of success and
     * must be decreased within any method which removes an employee in case of success.
     */
    private int employeesCount;

    public EmployeeBook() {
        employees = new Employee[EMPLOYEES_COUNT];
    }



    private static void checkDepartmentId(int departmentId) {
        if (departmentId < 1 || departmentId > DEPARTMENT_COUNT) {
            throw new IllegalArgumentException("Задан несуществующий номер отдела: " + departmentId);
        }
    }



    public boolean addEmployee(String fullName, int departmentId, double salary) {
        checkDepartmentId(departmentId);
        return addEmployee(new Employee(fullName, departmentId, salary));
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                employeesCount++;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployeeByFullName(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
                employeesCount--;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                employeesCount--;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployee(String fullName) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                return employee;
            }
        }
        return null;
    }


    /**
     * @param fullName .
     * @param newSalary .
     * @return employee whose salary was successfully changed or null if there is no such employee with
     * specified fullName
     */
    public Employee changeSalary(String fullName, double newSalary) {
        Employee employee = getEmployee(fullName);
        if (employee == null) {
            return null;
        }
        String currentSalary = employee.getFormattedSalary();
        employee.setSalary(newSalary);
        out.println("Зарплата сотрудника с Ф.И.О. " + fullName + " изменена с " +
                currentSalary + " на " + employee.getFormattedSalary());
        return employee;
    }

    public void printEmployeesByDepartments() {
        out.println("Списки сотрудников компании по отделам.");
        for (int i = 1; i <= DEPARTMENT_COUNT; i++) {
            if (!isDepartmentEmpty(i)) {
                printEmployeesListInDepartment(i);
            } else {
                out.println("Сотрудников в отделе на данный момент нет.\n");
            }
        }
    }

    public Employee changeDepartment(String fullName, int newDepartmentId) {
        checkDepartmentId(newDepartmentId);
        Employee employee = getEmployee(fullName);
        if (employee == null) {
            return null;
        }
        employee.setDepartmentId(newDepartmentId);
        return employee;
    }

    public boolean isDepartmentEmpty(int departmentId) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentId() == departmentId) {
                return false;
            }
        }
        return true;
    }

    public void printAverageSalaryInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        out.print("Средняя зарплата в " + departmentId + "-м отделе составляет "
                + Employee.formatSalary(calcAverageSalaryInDepartment(departmentId)) + "\n\n");
    }

    public void printMaxWageEmployeeInDepartment(int departmentId) {
        Employee employee = findMaxWageEmployeeInDepartment(departmentId);
        out.println("Сотрудник с максимальной зарплатой в " + departmentId + "-м отделе:");
        out.print("\t" + employee.getFullName());
        out.print(" Зарплата составляет " + employee.getFormattedSalary());
        out.print("\n\n");
    }

    public void printMinWageEmployeeInDepartment(int departmentId) {
        Employee employee = findMinWageEmployeeInDepartment(departmentId);
        out.println("Сотрудник с минимальной зарплатой в " + departmentId + "-м отделе:");
        out.print("\t" + employee.getFullName());
        out.print(" Зарплата составляет " + employee.getFormattedSalary());
        out.print("\n\n");
    }

    public void printEmployeesWithSalaryGreaterOrEqualTo(double targetSalary) {
        out.println("Список сотрудников с зарплатой, равной или превышающей " + Employee.formatSalary(targetSalary) + ':');
        boolean areFound = false;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= targetSalary) {
                areFound = true;
                out.println(employee.toShortString());
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
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < targetSalary) {
                out.println(employee.toShortString());
            }
        }
        if (!areFound) {
            out.println("\tтаковых сотрудников не найдено.");
        }
        out.println();
    }

    public void printEmployeesListInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        out.println("Список сотрудников " + departmentId + "-го отдела:");
        for (Employee employee : employees) {
            if (employee != null && departmentId == employee.getDepartmentId()) {
                out.println(employee.toShortString());
            }
        }
        out.println();
    }

    public void indexSalaryInDepartment(int departmentId, int salaryIndexationPercentage) {
        out.println("Индексация зарплаты.");
        checkDepartmentId(departmentId);
        out.print("Производится индексация зарплаты для всех сотрудников " + departmentId + "-го отдела.");
        out.println("Увеличение составит " + salaryIndexationPercentage + "%.");

        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        for (Employee employee : employees) {
            if (employee != null && departmentId == employee.getDepartmentId()) {
                employee.setSalary(employee.getSalary() * salaryMultiplier);
            }

        }
        out.println();
    }

    public void indexSalary(int salaryIndexationPercentage) {
        out.println("Индексация зарплаты.");
        out.print("Производится индексация зарплаты для всех сотрудников компании.");
        out.println("Увеличение составит " + salaryIndexationPercentage + "%.");

        double salaryMultiplier = (100.0 + salaryIndexationPercentage) / 100.0;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * salaryMultiplier);
            }
        }

        out.println();
    }

    public double calcAverageSalaryInDepartment(int departmentId) {
        double sum = 0;
        int count = 0;
        checkDepartmentId(departmentId);

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentId() == departmentId) {
                count++;
                sum += employee.getSalary();
            }
        }
        return sum / count;
    }

    public Employee findMaxWageEmployeeInDepartment(int departmentId) {
        double maxWage = Double.MIN_VALUE;
        Employee employeeWithMaxWage = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentId() == departmentId
                    && employee.getSalary() > maxWage) {
                maxWage = employee.getSalary();
                employeeWithMaxWage = employee;
            }
        }
        return employeeWithMaxWage;
    }

    public Employee findMinWageEmployeeInDepartment(int departmentId) {
        double minWage = Double.MAX_VALUE;
        Employee employeeWithMinWage = null;
        for (Employee employee : employees) {
            if (employee != null
                    && employee.getDepartmentId() == departmentId
                    && employee.getSalary() < minWage) {
                minWage = employee.getSalary();
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

    public void printFullNamesList() {
        out.println("Список сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                out.println(employee.getId() + ". " + employee.getFullName());
            }
        }
        out.println();
    }

    public double calcAverageSalary() {
        return (employeesCount == 0) ? 0 : calcMonthlyPayroll() / employeesCount;

    }

    public Employee findMinWageEmployee() {
        double minWage = Double.MAX_VALUE;
        Employee employeeWithMinWage = null;
        for (Employee employee : employees) {
            if (employee != null && minWage > employee.getSalary()) {
                minWage = employee.getSalary();
                employeeWithMinWage = employee;
            }
        }
        return employeeWithMinWage;
    }

    public Employee findMaxWageEmployee() {
        double maxWage = Double.MIN_VALUE;
        Employee employeeWithMaxWage = null;
        for (Employee employee : employees) {
            if (employee != null && maxWage < employee.getSalary()) {
                maxWage = employee.getSalary();
                employeeWithMaxWage = employee;
            }
        }
        return employeeWithMaxWage;
    }

    public double calcMonthlyPayrollInDepartment(int departmentId) {
        checkDepartmentId(departmentId);
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentId() == departmentId) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double calcMonthlyPayroll() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void printEmployeesList() {
        out.println("\nСводка по сотрудникам:");
        for (Employee employee : employees) {
            if (employee != null) {
                out.println(employee);
            }
        }
        out.println();
    }

    public int getEmployeesCount() {
        return employeesCount;
    }
}