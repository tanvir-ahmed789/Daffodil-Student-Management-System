package daffodil.student.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;
    public Statement statement;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/daffodilmanagement?useSSL=false",
                    "tanvir", // Replace with your DB username
                    "12345" // Replace with your DB password
            );
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found. Please add mysql-connector-java to classpath.", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to database: " + e.getMessage(), e);
        }
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }
        return connection.prepareStatement(query);
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}