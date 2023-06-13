package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.Comparator;

class SalaryComparator<T> implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getSalary().compareTo(e2.getSalary());
    }
}
