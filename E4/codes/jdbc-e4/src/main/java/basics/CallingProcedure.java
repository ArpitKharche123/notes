package basics;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallingProcedure {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres",
				"postgres",
				"root1234")){
			
		//Calling a stored procedure
		CallableStatement s =
			con.prepareCall("call sp_insert_emp(?,?)");
		
		s.setString(1, "prathamesh");
		s.setString(2, "M");
		
		s.execute();
		System.out.println("Called");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * More boilerplate code
		 * Developer must know about SQL and DBMS
		 * We cannot map Object with record of the table
		 * 
		 * 
		 * 			ORM Tools
		 *  ORM- Object Relational Mapping
		 *  
		 *  Customer
		 *  	-id
		 *  	-name
		 *  	-age
		 *  	-email
		 *  
		 *  classname - table name
		 *  properties- columns
		 *  
		 *  new Customer(); - record
		 *  
		 *  
		 *  Hibernate ORM Tool/Framework
		 *  	
		 *  	* CRUD + ORM
		 *      * built in methods
		 *      * minimal SQL query
		 *      * JPQL support
		 *      * automatic table generation
		 *      * JPA - Java Persistence API
		 *      * internally use JDBC
		 *      
		 *  Maven- 1.Hibernate Core
		 *   	   2. PostgreSQL JDBC Driver
		 *   	   3. Project Lombok
		 */
	}
}
