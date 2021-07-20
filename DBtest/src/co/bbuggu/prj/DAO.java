package co.bbuggu.prj;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "bbuggu";
	private String password = "1234";

	public Connection conn;

	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("🌏Connection DB🌏");
		} catch (Exception e) {
			System.out.println("Disconnection DB or Not Class");
		}
	}

}
