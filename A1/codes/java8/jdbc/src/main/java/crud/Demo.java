package crud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
	public static void main(String[] args) {
		try(Connection connection=
				DriverManager.getConnection(
						JDBC.getUrl()+"postgres",
						JDBC.getUser(),
						JDBC.getPassword()
						)){
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
