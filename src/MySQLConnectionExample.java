import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionExample {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:52001/db";
        String username = "user";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to MySQL server via HAProxy successfully.");

            // Execute a simple query to test the connection
            try (Statement statement = connection.createStatement()) {
                String query = "SELECT * FROM mytable";
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        // Process the result set
                        String columnValue = resultSet.getString("column_name");
                        System.out.println("Value: " + columnValue);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to MySQL server: " + e.getMessage());
        }
    }
}
