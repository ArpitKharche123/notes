package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayProducts {
public static void main(String[] args) {
	try(Connection connection=
			DriverManager.getConnection(
					JDBC.getUrl()+"postgres",
					JDBC.getUser(),
					JDBC.getPassword())){
	
		Statement statement=connection.createStatement();
		
		ResultSet products 
		= statement.executeQuery(
				"select * from products"
				);
		while(products.next()) {
			System.out.println("Id: "+products.getInt(1));
			//or products.getInt("id")
			System.out.println("Name: "+products.getString(2));
			//or products.getString("name");
			System.out.println("Price: "+products.getDouble(3));
			//or products.getDouble("price");
			System.out.println("----------------------------------");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
