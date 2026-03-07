package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProduct {
	/*
	 * 1. Load a Driver (after jdbc4+, automatically loaded )
	 * 
	 * 2. Registering the Driver(optional)
	 * 
	 * 3. Creating/Establishing a connection
	 * 
	 * 4. Creating a statement
	 * 
	 * 5. Executing the query using statements
	 * 
	 * 6. Closing the connection(not needed if we are using try-resource )
	 * 
	 * 7. De-register the driver(Optional)
	 */

	public static void main(String[] args) {
		try (
				// Establishing the connection
				Connection connection = DriverManager.getConnection(
						// host:port_no/database_name
						"jdbc:postgresql://localhost:5432/postgres",
						"postgres"// username
						, "root1234");// password
		) {
			// Creating a statement
			Statement statement = connection.createStatement();

			// Executing the SQL query
			statement.execute("insert into products "
			+ "values(1,'laptop',45000.8)");

			System.out.println("Product inserted successfully!");

			// Closing the connection
			// Not required if we are using
			// try-resource block
			// connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
