package basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicQueries {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres",
				"postgres",
				"root1234")){
			
		//Dynamic SQL query
		PreparedStatement stmt=
			con.prepareStatement("update emp set name=? "
					+ "where id=?");
			
		stmt.setString(1, "Vipul");
		stmt.setInt(2, 2);
		
		stmt.execute();
		System.out.println("Updated");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
