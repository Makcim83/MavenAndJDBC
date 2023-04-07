package ru.skypro.jdbc;

import ru.skypro.jdbc.model.City;
import ru.skypro.jdbc.model.Employee;
import ru.skypro.jdbc.service.EmployeeDAO;
import ru.skypro.jdbc.service.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDao = new EmployeeDaoImpl();

        System.out.println(employeeDao.getById(6) + "\n");

        selectAll(employeeDao);

        int idToUpdate = 4;
        Employee emp = new Employee(idToUpdate, "Ivan", "Ivanov", "male", 59, new City(1, "Moscow"));
        employeeDao.updateEmployee(idToUpdate, emp);

//        employeeDao.addEmployee(new Employee ("Ivan", "Ivanovovskiy" , "male" , 33, 2));
        selectAll(employeeDao);

        employeeDao.deleteEmployee(9);
        selectAll(employeeDao);

    }
    public static void selectAll(EmployeeDAO employeeDao) {
        for (Employee e : employeeDao.getAllEmployee()) {
            System.out.println(e);
        }
        System.out.println();
    }
}
