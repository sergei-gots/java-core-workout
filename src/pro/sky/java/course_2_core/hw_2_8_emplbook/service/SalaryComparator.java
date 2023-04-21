package pro.sky.java.course_2_core.hw_2_8_emplbook.service;

import pro.sky.java.course_2_core.employee.model.Employee;

import java.util.Comparator;

class SalaryComparator<T> implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}
