package crud.dynamicQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import crud.JDBC;

public class UsingPreparedStatement {
	public static void main(String[] args) {
		try(Connection connection=
				DriverManager.getConnection(
						JDBC.getUrl()+"postgres",
						JDBC.getUser(),
						JDBC.getPassword()
						)){
		
		//Dynamic query
		PreparedStatement stmt=
				connection.prepareStatement(
				" insert into employee(name,dept,gender) "
				+ "values(?,?,?)");
		
		//Setting the values for placeholders(?)
		stmt.setString(1, "hira");
		stmt.setString(2, "tracker");
		stmt.setString(3, "M");
		
		stmt.execute();
		System.out.println("Employee inserted successfully!");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
