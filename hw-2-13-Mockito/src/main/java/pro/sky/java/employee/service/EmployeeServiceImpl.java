package pro.sky.java.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.employee.model.Employee;
import pro.sky.java.employee.model.Person;
import pro.sky.java.employee.model.util.EmployeeValidator;
import pro.sky.java.employee.repository.EmployeesRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository repository;
    private final EmployeeValidator validator;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository, EmployeeValidator employeeValidator) {
        this.repository = employeesRepository;
        this.validator = employeeValidator;
    }

    @Override
    public Employee add(String firstName, String lastName, int departmentId, double salary) {

        final Employee employee = new Employee(
                validator.validateName(firstName),
                validator.validateSurname(lastName),
                validator.validateDepartment(departmentId),
                validator.validateSalary(salary));
        return repository.add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        final Person person = new Person(validator.validateName(firstName), validator.validateSurname(lastName));
        return repository.remove(person);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        final Person person = new Person(validator.validateName(firstName), validator.validateSurname(lastName));
        return repository.find(person);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

}
