package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicSqlQueries {
	public static void main(String[] args) {
		try(Connection c=
				DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
					"postgres",
					"root1234")){
			
			//Executing a dynamic SQL query
			PreparedStatement stmt
			=c.prepareStatement("Insert into employee(name,gender) "
					+ "values(?,?)");//?-placeholder
			
			stmt.setString(1, "bob");
			stmt.setString(2, "M");
			
			stmt.execute();
			System.out.println("Inserted");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
