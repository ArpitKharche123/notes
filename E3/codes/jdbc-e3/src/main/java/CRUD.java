import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	/*
	 * 1. Loading the Driver Class
	 * (not required from JDBC 4+/java SE 6+)
	 * 
	 * 2. Register the driver
	 * (not required from JDBC 4+/java SE 6+)
	 * 
	 * 3. Creating/Establishing a connection 
	 * 
	 * 4. Creating a Statement
	 * 
	 * 5. Executing the query
	 * 
	 * 6. Close the connection
	 * 	(not required in try with resource block)
	 * 
	 * 7. De-register the driver
	 * 	(optional)
	 */
	public static void main(String[] args) {
		try(Connection c=
			DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres",
				"postgres",
				"root1234")){
			
			Statement s = c.createStatement();
			
//			Inserting the data
			
//			s.execute("Insert into employee(name,gender) "
//					+ "values('marx','M')");
//			
//			System.out.println("Inserted");
			
			//Updating
			
//			int r = s.executeUpdate("Update employee "
//					+ "set name='emily', gender='F' "
//					+ "where id=2");
//			
//			System.out.println(r+" no. of rows affected");
			
			//Deleting
			
//			s.execute("delete from employee where id=2");
//			System.out.println("Deleted");
			
			
			//Fetching
			
			ResultSet employees 
			= s.executeQuery("Select * from employee");
			
			while(employees.next()) {
				System.out.println("Id: "+employees.getInt(1));
				System.out.println("Name: "+employees.getString(2));
				System.out.println("Gender: "+employees.getString(3));
				System.out.println("----------------------");
			}
			
			//Insert into employee(name,gender)
			//values(?,?);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
