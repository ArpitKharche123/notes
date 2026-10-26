package edu.j2ee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallingStoredProcedure {
    static void main() {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mydb",
                "postgres",
                "root1234"
        )
        ){
            String query = "CALL insert_emp('Rohan',16)";
            CallableStatement s = con.prepareCall(query);

            s.execute();
            System.out.println("Executed");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
