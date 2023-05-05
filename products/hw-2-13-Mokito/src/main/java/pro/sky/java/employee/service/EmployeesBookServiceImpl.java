package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;
import pro.sky.java.employee.repository.EmployeesRepository;

@Service
public class EmployeesBookServiceImpl implements EmployeesBookService {

    private final EmployeesRepository employeesRepository;

    public EmployeesBookServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeesRepository.add(employee);
    }

    @Override
    public Employee removeEmployee(Person person) {
        return employeesRepository.remove(person);
    }

    @Override
    public Employee findEmployee(Person person) {
        return employeesRepository.find(person);
    }

}
