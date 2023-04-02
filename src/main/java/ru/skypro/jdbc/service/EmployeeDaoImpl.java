package ru.skypro.jdbc.service;

import ru.skypro.jdbc.config.ConnectionConfig;
import ru.skypro.jdbc.model.City;
import ru.skypro.jdbc.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                    "SELECT * " +
                            "FROM employee " +
                            "INNER JOIN city ON employee.city_id = city_id;"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String lasttName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = Integer.parseInt(resultSet.getString("age"));
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name"));
                employees.add(new Employee(id, firstName, lasttName, gender, age, city.getCity_id()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void updateEmployee(int id, Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }


/*  ArrayList<Employee> getAllEmployee();
    Employee getById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
*/

}
