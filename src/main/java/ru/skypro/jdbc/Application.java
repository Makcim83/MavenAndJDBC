package ru.skypro.jdbc;

import ru.skypro.jdbc.model.Employee;
import ru.skypro.jdbc.service.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args) {
        System.out.println(new EmployeeDaoImpl().getById(6) + "\n");

        selectAll();

        Employee emp = new Employee("Ivan", "Ivanov", "male", 59, 3);
        new EmployeeDaoImpl().updateEmployee(4, emp);

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
