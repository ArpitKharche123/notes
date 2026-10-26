package edu.j2ee;

import java.sql.*;

public class Crud {
    /*
        Steps to connect java application with database

        1. Load and Register the Driver(can be skipped)
        2. Create a Connection between java app and database
        3. Create a Statement
        4. Execute a Query
        5. Close the connection and statement
        (can be skipped using try-resource)
        6. De-register the Driver(can be skipped)
     */
    static void main() {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mydb",
                "postgres",
                "root1234"
        );
             //Used to execute static query
             Statement s = con.createStatement();
        ) {
            String insert = """
                    INSERT into employees(name,age)
                    VALUES ('John',23)
                    """;
//            s.execute(insert);

            String update = """
                    UPDATE employees
                    SET age = 25
                    WHERE id = 1
                    """;

            String delete = """
                    Delete from employees
                    WHERE id = 1
                    """;
//            int i = s.executeUpdate(delete);
//            System.out.printf("%d no. of rows affected",i);

            String bulkInsert = """
                    INSERT INTO employees(name,age)
                    VALUES('Carl',34),
                          ('Bob',14),
                          ('Kalpesh',26),
                          ('Vijay',18)
                    """;
//            s.execute(bulkInsert);
//            System.out.println("Done");

            String selectAll = """
                    SELECT * 
                    FROM employees
                    """;
            ResultSet set = s.executeQuery(selectAll);
            while (set.next()) {
                System.out.printf("""
                                Id: %d
                                Name: %s
                                Age: %d
                                --------
                                """
                        ,set.getInt(1),
                        set.getString(2),
                        set.getInt(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
