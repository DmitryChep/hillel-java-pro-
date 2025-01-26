package ua.ithillel.javapro;

import lombok.Data;
import ua.ithillel.javapro.exception.DatabaseOperationException;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

@Data
public class EmployeeDao {
    private final Connection connection;

    public Optional<Employee> addEmployee(Employee employee, String tableName) throws SQLException, NoSuchFieldException, IllegalAccessException, DatabaseOperationException {
        StringBuilder query = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        // list of column name from t_employee table from DB
        List<String> tableColumnNamesDB = new ArrayList<>();
        // list of values from employee instance
        List<Object> employeeValues = new ArrayList<>();

        // get meta information from database table
        DatabaseMetaData DatabaseMetaData = connection.getMetaData();
        // get columns from meta information database
        ResultSet resultColumnNameSet = DatabaseMetaData.getColumns(null, null, tableName, "%");

        while (resultColumnNameSet.next()) {
            // skip the id column (it is auto-incremental)
            if (!resultColumnNameSet.getBoolean("IS_AUTOINCREMENT")) {
                tableColumnNamesDB.add(resultColumnNameSet.getString("COLUMN_NAME"));
                query.append(resultColumnNameSet.getString("COLUMN_NAME")).append(", ");
            }
        }

        // delete last coma in the query column names
        query.delete(query.length() - 2, query.length());
        query.append(") VALUES (");

        // get values to insert into the table even if the employee doesn't have getters methods
        for (String columnName : tableColumnNamesDB) {
            Field field = Employee.class.getDeclaredField(columnName);
            field.setAccessible(true);
            employeeValues.add(field.get(employee));
        }

        //get wildcards for inserting values
        query.append(String.join(", ", Collections.nCopies(employeeValues.size(), "?"))).append(");");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < employeeValues.size(); i++) {
                preparedStatement.setString(i + 1, employeeValues.get(i).toString());
            }

            int execute = preparedStatement.executeUpdate();
            if (execute > 0) {
                System.out.println("Data inserted successfully.");
            }

            // set auto-increment "id" into the employee
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    employee.setId(generatedId);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException("Couldn't insert data into table: " + e.getMessage());
        }
        return Optional.ofNullable(employee);
    }


    public Optional<Employee> getEmployee(int id, String table) throws DatabaseOperationException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + table + " WHERE id = ?")) {
            statement.setInt(1, id);

            boolean execute = statement.execute();

            if (!execute) {
                System.out.println("Data not found.");
                return Optional.empty();
            }

            ResultSet resultSet = statement.getResultSet();
            Employee employeeFromDB = null;
            while(resultSet.next()) {
                if(employeeFromDB == null) {
                    employeeFromDB = new Employee();
                    employeeFromDB.setId(resultSet.getInt("id"));
                    employeeFromDB.setName(resultSet.getString("name"));
                    employeeFromDB.setAge(resultSet.getInt("age"));
                    employeeFromDB.setPosition(resultSet.getString("position"));
                    employeeFromDB.setSalary(resultSet.getFloat(("salary")));
                }
                return Optional.of(employeeFromDB);
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }

        return Optional.empty();
    }


    public Optional<Employee> updateEmployee(String tableName, int id, String column, double value) throws DatabaseOperationException, SQLException {
        StringBuilder query = new StringBuilder("UPDATE ").append(tableName).append(" SET ");

        List<String> tableColumnNames = new ArrayList<>();

        DatabaseMetaData DatabaseMetaData = connection.getMetaData();
        ResultSet columnNameMetaData = DatabaseMetaData.getColumns(null, null, tableName, "%");

        while (columnNameMetaData.next()) {
            tableColumnNames.add(columnNameMetaData.getString("COLUMN_NAME"));
            for (String tableColumnName : tableColumnNames) {
                if (tableColumnName.equals(column.toLowerCase().trim())) {
                    query.append(tableColumnName).append(" = ").append(" ?  ");
                }
            }
        }

        query.append("WHERE id = ?;");
        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {
            preparedStatement.setDouble(1, value);
            preparedStatement.setInt(2, id);
            int execute = preparedStatement.executeUpdate();
            if (execute > 0) {
                System.out.println("Data updated successfully.");
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException(e);
        }
        return getEmployee(id, tableName);
    }


    public void deleteEmployee(String tableName, int id) throws DatabaseOperationException {
        String query = "DELETE FROM " + tableName + " WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Data deleted successfully.");
        } catch (SQLException e) {
            throw new DatabaseOperationException("Couldn't delete data from table: " + e.getMessage());
        }
    }
}
