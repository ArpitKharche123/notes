package basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Load and Register the Driver ***
 * 
 * 2. Create a Connection 
 * 
 * 3. Create a Statement
 * 
 * 4. Execute a Query
 * 
 * 5. Close the Connection ***
 * 
 * 6. De-register the Driver ***
 */

public class CrudUsingJdbc {
  public static void main(String[] args) {
	try(Connection con = DriverManager.getConnection(
			"jdbc:postgresql://localhost:5432/postgres",
			"postgres",
			"root1234")){
	Statement stmt = con.createStatement();
	
	//Insert
//	stmt.execute("Insert into emp(name,gender) "
//			+ "values('Shailesh','M')");
//	System.out.println("Inserted Successfully! ");
	
	//Update
//	int row = stmt.executeUpdate(
//			"Update emp set name='ramu' where id=1");
	
	//System.out.println(row+" no. of rows updated");
	
	//Delete
//	stmt.execute("Delete from emp where id = 1");
//	System.out.println("Deleted");
	
	//Selecting all the rows
	ResultSet set = stmt.executeQuery("Select * from emp");
	
	while(set.next()) {
		System.out.println("Id: "+set.getInt(1));
		System.out.println("Name: "+set.getString(2));
		System.out.println("Gender: "+set.getString(3));
		System.out.println("----------------------------");
	}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
