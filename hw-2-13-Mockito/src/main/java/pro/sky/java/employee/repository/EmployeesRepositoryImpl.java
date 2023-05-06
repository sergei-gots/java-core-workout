package pro.sky.java.employee.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.employee.exceptions.EmployeeNotFoundException;
import pro.sky.java.employee.exceptions.EmployeeStorageIsFullException;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;
import pro.sky.java.employee.util.EmployeeUtils;

import java.util.List;
import java.util.Map;

import static pro.sky.java.employee.util.EmployeeConstants.EMPLOYEES_MAX_COUNT;

@Repository
public class EmployeesRepositoryImpl implements EmployeesRepository {

    private static final EmployeesRepositoryImpl instance;

    private final Map<String, Employee> employees;

    static {
        instance = new EmployeesRepositoryImpl();
    }

    public static EmployeesRepositoryImpl getEmptyInstance() {
        instance.employees.clear();
        return instance;
    }

    private EmployeesRepositoryImpl() {
           employees = EmployeeUtils.generateEmployees();
    }

    @Override
    public Employee add(Employee employee) {
        if(employees.size() == EMPLOYEES_MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getKey())) {
            throw new EmployeeAlreadyAddedException(employee);
        }
        employees.put(employee.getKey(), employee);
        return employee;
    }

    @Override
    public Employee remove(Person person) {
        final String key = person.getKey();
        if (employees.get(key) == null) {
            throw new EmployeeNotFoundException(person);
        }
        return employees.remove(key);
    }

    @Override
    public Employee find(Person person) {
        final Employee foundEmployee = employees.get(person.getKey());
        if (foundEmployee == null) {
            throw new EmployeeNotFoundException(person);
        }
        return foundEmployee.copy();
    }

    @Override
    public List<Employee> findAll() {
        return List.copyOf(employees.values());
    }

    @Override
    public List<Employee> removeAll() {
        List<Employee> list = List.copyOf(employees.values());
        employees.clear();
        return list;
    }

    @Override
    public int count() {
        return employees.size();
    }
}
