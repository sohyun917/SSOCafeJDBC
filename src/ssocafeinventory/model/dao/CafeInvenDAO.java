package ssocafeinventory.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ssocafeinventory.model.vo.CafeInven;

public class CafeInvenDAO {

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "CAFEINVEN";
	private final String PASSWORD = "CAFEINVEN";
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	
	public int inoutMenu(CafeInven cafe) {
		int result = 0;
		try {
			String sql = "INSERT INTO CAFEINVEN VALUES('"+cafe.getName()+"', "+cafe.getInoutStock()+", DEFAULT)";
			Class.forName(DRIVERNAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			conn.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<CafeInven> printStock() {
		List<CafeInven> cList = null;
		try {
			String sql = "SELECT * FROM CAFEINVEN";
			Class.forName(DRIVERNAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			cList = new ArrayList<CafeInven>();
			while(rset.next()) {
				CafeInven cafe = new CafeInven();
				cafe.setName(rset.getString("NAME"));
				cafe.setInoutStock(rset.getInt("STOCK"));
				cafe.setInoutTime(rset.getDate("INOUTDATE"));
				cList.add(cafe);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	public List<CafeInven> orderSys() {
		String sql = "SELECT * FROM CAFEINVEN WHERE STOCK <= 3";
		List<CafeInven> cList = null;
		try {
			Class.forName(DRIVERNAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			cList = new ArrayList<CafeInven>();
			while(rset.next()) {
				CafeInven cafe = new CafeInven();
				cafe.setName(rset.getString("NAME"));
				cafe.setInoutStock(rset.getInt("STOCK"));
				cList.add(cafe);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
}
