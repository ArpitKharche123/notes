package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicQueries {
	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:postgresql://localhost/postgres",//url
				"postgres",//user
				"root1234")//password
				){
			
			//Executing dynamic sql query
			PreparedStatement s = c.prepareStatement(
					"Update students set age= ? where id = ?");
			
			s.setInt(1, 19);//set age
			s.setInt(2, 4);//set id
			
			s.execute();
			System.out.println("Updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
