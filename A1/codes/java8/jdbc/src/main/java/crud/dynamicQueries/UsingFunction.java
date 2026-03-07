package crud.dynamicQueries;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import crud.JDBC;

public class UsingFunction {
	public static void main(String[] args) {
		try(Connection c
				=DriverManager.getConnection(
						JDBC.getUrl()+"postgres",
						JDBC.getUser(),
						JDBC.getPassword())
				){
			
		CallableStatement stmt=
				c.prepareCall(
				"select fn_count_by_gender(?)");
		
		stmt.setString(1, "M");
		
		ResultSet count = stmt.executeQuery();
		
		if(count.next()) {
			System.out.println("Count: "+count.getInt(1));
		}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
