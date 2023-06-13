package pro.sky.java.employee.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.employee.exceptions.EmployeeNotFoundException;
import pro.sky.java.employee.exceptions.EmployeeStorageIsFullException;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.util.EmployeeUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pro.sky.java.employee.util.EmployeeConstants.EMPLOYEES_MAX_COUNT;

@Repository
public class EmployeesRepositoryImpl implements EmployeesRepository {

    private static final EmployeesRepositoryImpl instance;

    private final Map<Integer, Employee> employees;

    static {
        instance = new EmployeesRepositoryImpl();
    }

    public static EmployeesRepositoryImpl getEmptyInstance() {
        instance.employees.clear();
        return instance;
    }

    private EmployeesRepositoryImpl() {
           employees =  new HashMap<>();
    }

    @Override
    public void add(Employee employee) {
        if(employees.size() == EMPLOYEES_MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        final int id = employee.getId();
        if (employees.containsKey(id)) {
            throw new EmployeeAlreadyAddedException(id);
        }
        employees.put(id, employee);
    }

    @Override
    public void edit(Employee employee) {
        final int id = employee.getId();
        validateId(id);
        Employee e = employees.get(id);
        e.updateWith(employee);
    }

    private void validateId(int id) {
        if (employees.get(id) == null) {
            throw new EmployeeNotFoundException(id);
        }
    }

    @Override
    public Employee remove(int id) {
        validateId(id);
        return employees.remove(id);
    }


    @Override
    public Employee get(int id) {
        validateId(id);
        return employees.get(id).copy();
    }

    @Override
    public List<Employee> getAll() {
        return List.copyOf(employees.values());
    }


    @Override
    public int size() {
        return employees.size();
    }

    @Override
    public Collection<Employee> getEmployeesWithSalaryHigherThan(double salary) {
        return employees.values()
                .stream().filter((e)->e.getSalary().doubleValue()>salary)
                .collect(Collectors.toUnmodifiableList());
    }
}
