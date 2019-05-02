import java.sql.*;

public class dbConnection {

	protected String url = "jdbc:mysql://localhost:3306/Bank_app";
	protected String username = "root";
	protected String password = "";
	protected Connection conn;

	public Connection toConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_app","root","");
			}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}