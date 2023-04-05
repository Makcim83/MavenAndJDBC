package ru.skypro.jdbc;

import ru.skypro.jdbc.model.City;
import ru.skypro.jdbc.model.Employee;
import ru.skypro.jdbc.service.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args) {
        System.out.println(new EmployeeDaoImpl().getById(6) + "\n");

        selectAll();

        int idToUpdate = 4;
        Employee emp = new Employee(idToUpdate, "Ivan", "Ivanov", "male", 59, new City(1, "Moscow"));
        new EmployeeDaoImpl().updateEmployee(idToUpdate, emp);

//        new EmployeeDaoImpl().addEmployee(new Employee ("Ivan", "Ivanovovskiy" , "male" , 33, 2));
        selectAll();

        new EmployeeDaoImpl().deleteEmployee(9);
        selectAll();

    }
    private static void selectAll() {
        for (Object o : new EmployeeDaoImpl().getAllEmployee()) {
            System.out.println(o);
        }
        System.out.println();
    }
}
