package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallingStoredProcedure {
	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:postgresql://localhost/postgres",//url
				"postgres",//user
				"root1234")//password
				){
			
		CallableStatement s = c.prepareCall("call sp_insert_student('mehul',21)");
		
		s.execute();
		
		System.out.println("inserted successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
