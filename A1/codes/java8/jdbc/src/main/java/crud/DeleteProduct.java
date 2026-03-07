package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteProduct {
	public static void main(String[] args) {
		try(Connection connection=
				DriverManager.getConnection(
						JDBC.getUrl()+"postgres",
						JDBC.getUser(),
						JDBC.getPassword()
						)){
			
		Statement statement=connection.createStatement();
		
		statement.execute("delete from products "
				+ "where id=1");
		
		System.out.println("Product deleted successfully!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
