package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	/*
	 Steps to connect JAVA App with database
	 
	 1. Load / Register the driver (skip)
	 2. Create the connection
	 3. Create the statement
	 4. Execute the query
	 5. Close the connection (skip)
	 6. De-register the Driver (skip)
	 
	 */
	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:postgresql://localhost/postgres",//url
				"postgres",//user
				"root1234")//password
				){
		
		Statement s = c.createStatement();
		
		//Insert
		//s.execute("Insert into students(name,age) values('satish',21)");
		
		//Update
//		int r = s.executeUpdate("Update students set age=13 where id=1");
//		System.out.println(r+ " rows effected");
		
		//Delete
		//s.execute("Delete from students where id=1");
		
		//Select
		ResultSet r = s.executeQuery("Select * from students");
		while(r.next()) {
			System.out.println("Id: "+r.getInt(1));
			System.out.println("Name: "+r.getString(2));
			System.out.println("Age: "+r.getInt(3));
			System.out.println("------------------");
		}
		
		
		System.out.println("Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
