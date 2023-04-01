package ru.skypro.jdbc;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        String query = "SELECT * FROM employee";

        try (Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString(2);
                System.out.println(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "124421tot@";

        return DriverManager.getConnection(url, user, password);
    }
}
