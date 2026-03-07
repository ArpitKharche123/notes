package crud;

public class JDBC {
	private static String url 
	= "jdbc:postgresql://localhost:5432/";
	
	private static String user 
	= "postgres";
	
	private static String password 
	= "root1234";

	public static String getUrl() {
		return url;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}
}
