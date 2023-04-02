import java.sql.*;

import static ru.skypro.jdbc.config.ConnectionConfig.getConnection;

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
}
