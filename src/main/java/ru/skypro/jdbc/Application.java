package ru.skypro.jdbc;

import ru.skypro.jdbc.model.Employee;
import ru.skypro.jdbc.service.EmployeeDAO;


public class Application {
    public static void main(String[] args) {

        Employee employee = new Employee (EmployeeDAO.getById(3));
        System.out.println(employee.getFirst_name());

    }
}
