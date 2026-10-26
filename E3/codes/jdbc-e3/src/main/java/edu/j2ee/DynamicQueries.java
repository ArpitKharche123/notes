package edu.j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicQueries {
    static void main() {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mydb",
                "postgres",
                "root1234"
        )
        ){
            String dynamicQuery = """
                    UPDATE employees
                    SET name = ?
                    WHERE id = ?
                    """;
            PreparedStatement s = con.prepareStatement(dynamicQuery);
            s.setString(1,"Jack");
            s.setInt(2,3);
            int i = s.executeUpdate();
            System.out.printf("%d no. of rows affected",i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
