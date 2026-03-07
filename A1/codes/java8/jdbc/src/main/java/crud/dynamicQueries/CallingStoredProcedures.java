package crud.dynamicQueries;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import crud.JDBC;

public class CallingStoredProcedures {
	public static void main(String[] args) {
		try(Connection c
				=DriverManager.getConnection(
						JDBC.getUrl()+"postgres",
						JDBC.getUser(),
						JDBC.getPassword());
				Scanner sc=new Scanner(System.in)){
			
		CallableStatement stmt=
				c.prepareCall(
				"call sp_insert_employee(?,?,?)");
		
		System.out.println("Enter the employee name: ");
		stmt.setString(1, sc.nextLine());
		
		System.out.println("Enter the employee department: ");
		stmt.setString(2, sc.nextLine()); 
		
		System.out.println("Enter the employee gender: ");
		stmt.setString(3, sc.nextLine());
		
		stmt.execute();
		System.out.println("Employee inserted successfully!");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
