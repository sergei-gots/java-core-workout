package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;
import pro.sky.java.employee.repository.EmployeesRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Employee add(String firstName, String lastName, int departmentId, double salary) {
        return employeesRepository.add(new Employee(firstName, lastName, departmentId, salary));
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        return employeesRepository.remove(new Person(firstName, lastName));
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return employeesRepository.find(new Person(firstName, lastName));
    }

    @Override
    public List<Employee> getAll() {
        return employeesRepository.findAll();
    }

}
