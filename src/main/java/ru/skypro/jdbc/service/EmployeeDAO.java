package ru.skypro.jdbc.service;

import ru.skypro.jdbc.model.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    ArrayList<Employee> getAllEmployee();
    Employee getById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
