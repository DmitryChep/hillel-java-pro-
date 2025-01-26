package ua.ithillel.javapro;

import ua.ithillel.javapro.exception.DatabaseOperationException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {

        final String username = System.getenv("MYSQL_USER");
        final String password = System.getenv("MYSQL_PASSWORD");
        final String dbName = System.getenv("MYSQL_DB_NAME");
        final String url = "jdbc:mysql://localhost:3306/" + dbName + "?allowPublicKeyRetrieval=true&useSSL=false";

        String tableName = "t_employee";
        String[] tableColumns = {
                "id INT AUTO_INCREMENT PRIMARY KEY",
                "name VARCHAR(100)",
                "age INT",
                "position VARCHAR(100)",
                "salary FLOAT"
        };

        try (Connection connection = DatabaseConnector.connectToDatabase(url, username, password, dbName)) {
            DatabaseConnector.createTable(connection, tableName, tableColumns);

            Employee employee = new Employee(0, "John", 23, "Developer", 2000.0);

            EmployeeDao employeeDao = new EmployeeDao(connection);
            // create
            Optional<Employee> resultAddEmployee = employeeDao.addEmployee(employee, tableName);
            resultAddEmployee.ifPresent(System.out::println);

            // read
            Optional<Employee> employeeFromDB = employeeDao.getEmployee(1, tableName);
            employeeFromDB.ifPresent(System.out::println);

            // update
            Optional<Employee> resultUpdateEmployee = employeeDao.updateEmployee(tableName, 1, "salary", 3000.0);
            resultUpdateEmployee.ifPresent(System.out::println);

            // delete
            employeeDao.deleteEmployee(tableName, 1);

        } catch (DatabaseOperationException | SQLException | NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
