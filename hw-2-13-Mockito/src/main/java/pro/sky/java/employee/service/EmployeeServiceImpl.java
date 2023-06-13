package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.util.EmployeeValidator;
import pro.sky.java.employee.repository.EmployeesRepository;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository repository;
    private final EmployeeValidator validator;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository, EmployeeValidator employeeValidator) {
        this.repository = employeesRepository;
        this.validator = employeeValidator;
    }

    @Override
    public void add(Collection<Employee> employees) {
        for (Employee employee : employees) {
            add(employee);
        }
    }

    @Override
    public void add(Employee employee) {
        validator.validateEmployee(employee);
        repository.add(employee);
    }

    @Override
    public void edit(Employee employee) {
        validator.validateEmployee(employee);
        repository.edit(employee);
    }

    @Override
    public Employee remove(int id) {
        return repository.remove(id);
    }

    @Override
    public Employee get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public Collection<Employee> getEmployeesWithSalaryHigherThan(double salary) {
        return repository.getEmployeesWithSalaryHigherThan(salary);
    }

}
