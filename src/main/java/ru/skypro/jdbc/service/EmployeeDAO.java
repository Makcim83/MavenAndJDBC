package ru.skypro.jdbc.service;

import ru.skypro.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    Employee getById(int id);

    void addEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}