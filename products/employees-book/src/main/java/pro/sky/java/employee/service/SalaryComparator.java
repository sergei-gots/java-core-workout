package pro.sky.java.employee.service;

import pro.sky.java.employee.model.Employee;

import java.util.Comparator;

class SalaryComparator<T> implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}
