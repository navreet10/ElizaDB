package ElizaApp;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElizaDao {

	public String getHedgeset() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement sql = null;
		try {
			Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			sql = con.prepareStatement("SELECT * FROM   (  SELECT question FROM   hedgeSet"
					+ " ORDER BY DBMS_RANDOM.RANDOM) WHERE  rownum=1");
			
			rs = sql.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				sql.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean existsInReplacmentMap(String x) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement sql = null;
		try {
			Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			sql = con.prepareStatement("SELECT REPLACE FROM replacementMap where input = ?");
			sql.setString(1, x);
			rs = sql.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				sql.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public String getQualifierSet() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement sql = null;
		try {
			Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			sql = con.prepareStatement("SELECT * FROM   (  SELECT question FROM   qualifierSet"
					+ " ORDER BY DBMS_RANDOM.RANDOM) WHERE  rownum=1");
			
			rs = sql.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				sql.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getReplaceMent(String x) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement sql = null;
		try {
			Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(myDriver);
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			sql = con.prepareStatement("Select REPLACE from replacementMap where input = ?");
			sql.setString(1, x);
			rs = sql.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				sql.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
