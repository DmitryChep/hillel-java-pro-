1.Create a database (use PostgreSQL, for example):

* a. Create a database named company.

* b. Create the table employees, which will contain the fields:
    * id (type INTEGER, AUTO_INCREMENT, PRIMARY KEY),
    * name (of type VARCHAR),
    * age (of type INTEGER),
    * position (of type VARCHAR),
    * salary (of type FLOAT).

2.Connect to the database using JDBC:

* a. Create a DatabaseConnector class that will contain methods for connecting to the database, executing queries, and closing the connection.

* b. Implement methods to connect to the database and execute queries (to create a table and insert data).

3.Create methods to work with the database:

* a. Create an EmployeeDAO class that will contain methods for adding, updating, deleting, and retrieving information
  about employees from the database.

* b. Implement methods to add, update, delete, and retrieve information about employees.

4.Checking the correctness of execution:

* a. Create a Main class in which you call methods to add, update, delete, and retrieve information about employees and
  display the results on the screen.

* b. Make sure that all methods work correctly and display the expected result.

