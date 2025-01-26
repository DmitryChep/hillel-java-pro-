package ua.ithillel.javapro;

import lombok.Data;
import ua.ithillel.javapro.exception.DatabaseOperationException;

import java.sql.*;
import java.util.Arrays;

@Data
public class DatabaseConnector {

    public static Connection connectToDatabase(String url, String username, String password, String dbName) throws DatabaseOperationException {
        if (username == null || password == null || dbName == null) {
            System.err.println("ERROR: Missing environment variables.");
            System.err.println("Please ensure MYSQL_USER, MYSQL_PASSWORD, and MYSQL_DB_NAME are set.");
            throw new IllegalArgumentException("Environment variables are not set.");
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try  {
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection successful!");
                return connection;

            } catch (SQLException e) {
                throw new DatabaseOperationException(e.getMessage());
            }
        } catch (ClassNotFoundException | DatabaseOperationException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    // DDl is used here, so we can use Statement without PrepareStatement
    public static void createTable(Connection connection, String tableName, String[] tableColumns) throws DatabaseOperationException {
        StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");
        // add an array of columns to the query
        Arrays.stream(tableColumns).forEach(column -> query.append(column).append(", "));
        // delete last coma
        query.deleteCharAt(query.length() - 2).append(");");

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query.toString());

            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            throw new DatabaseOperationException("Couldn't create table: " + tableName + e.getMessage());
        }
    }
}

