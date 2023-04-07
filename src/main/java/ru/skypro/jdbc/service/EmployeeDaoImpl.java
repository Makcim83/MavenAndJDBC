package ru.skypro.jdbc.service;

import ru.skypro.jdbc.config.ConnectionConfig;
import ru.skypro.jdbc.model.City;
import ru.skypro.jdbc.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                    "SELECT * "
                            + "FROM employee "
                            + "INNER JOIN city ON employee.city_id = city.city_id"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City(Integer.parseInt(resultSet.getString("city_id")),
                        resultSet.getString("city_name"));
                employees.add(new Employee(id, firstName, lastName, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        if (isContainsId(id)) {
            try (
                    PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                            "SELECT * " +
                                    "FROM employee AS e " +
                                    "INNER JOIN city AS c ON e.city_id = c.city_id " +
                                    "WHERE id = (?) ")) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    employee.setId(resultSet.getInt(1));
                    employee.setFirst_name(resultSet.getString("first_name"));
                    employee.setLast_name(resultSet.getString("last_name"));
                    employee.setGender(resultSet.getString("gender"));
                    employee.setAge(Integer.parseInt(resultSet.getString("age")));

                    City city = new City(resultSet.getInt("city_id"),
                            resultSet.getString("city_name"));
                    employee.setCity(city);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("cant get by id " + id + " (no found)");
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        try (
                PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                        "INSERT INTO employee " +
                                "(first_name, last_name, gender, age, city_id) " +
                                "VALUES( (?), (?), (?), (?), (?) )")) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        if (isContainsId(id)) {
            try (
                    PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                            "UPDATE employee SET first_name=?,last_name=?, gender=?, age=?, city_id=? WHERE id= ? ")) {
                statement.setString(1, employee.getFirst_name());
                statement.setString(2, employee.getLast_name());
                statement.setString(3, employee.getGender());
                statement.setInt(4, employee.getAge());
                statement.setInt(5, employee.getCity().getCity_id());
                statement.setInt(6, id);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("cant update id " + id + " (no found)");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        if (isContainsId(id)) {
            try (
                    PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                            "DELETE FROM employee " +
                                    "WHERE id = (?) ")) {
                statement.setInt(1, id);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("cant delete id " + id + " (no found)");
        }
    }

    @Override
    public boolean isContainsId(int id) {
        try (
                PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                        "SELECT COUNT(*) " +
                                "FROM employee " +
                                "WHERE id = (?) ")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idFromResultset = resultSet.getInt(1);
                return idFromResultset == 1 ? true : false;
            } else {
                System.out.println("validation id : resultset is empty");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("validation id : no connection");
        return false;
    }
}
