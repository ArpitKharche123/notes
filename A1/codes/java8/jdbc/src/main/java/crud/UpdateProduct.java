package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProduct {
	public static void main(String[] args) {
		try(Connection connection=
				DriverManager.getConnection(
				"jdbc:postgresql://localhost/postgres"
				+ "?user=postgres&password=root1234")
				){
		
			Statement statement=connection.createStatement();
			
			int rows = statement.executeUpdate(
					  "update products "
					+ "set price=35000.0 "
					+ "where id=1");
			
			System.out.println("Product is updated"
					+ "\nNo. of rows affected: "+rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
