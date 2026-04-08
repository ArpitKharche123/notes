package demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsingCallableStatement {
	public static void main(String[] args) {
		try(Connection c=
				DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
					"postgres",
					"root1234")){
		
			CallableStatement stmt=
					c.prepareCall("CALL sp_insert_employee(?,?)");
			
			stmt.setString(1, "Sahil");
			stmt.setString(2, "M");
			
//			stmt.execute();
//			System.out.println("Called successfully");
			
			CallableStatement s=
					c.prepareCall("Select count_by_gender(?)");
			
			s.setString(1, "M");
			
			ResultSet emp = s.executeQuery();
			
			while(emp.next()) {
				System.out.println("Count: "+emp.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
