package co.bbuggu.prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "bbuggu";
	private String password = "1234";

	public Connection conn; // 연결객체

	public DAO() {
		try {
			Class.forName(driver); // jdbc 드라이버를 사용할 수 있도록 하는 구문
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 실패");
		}
	}
}
