package application.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import application.config.Config;

public class ConnectDB {
	String urlConnect = String.format("%s;databaseName=%s;user=%s;password=%s", Config.DB_CONNECTION, Config.DB_NAME,
			Config.DB_USER, Config.DB_PASSWORD);
	Connection conn = null;
	PreparedStatement stm = null;
	private static ConnectDB instance;

	public static ConnectDB getInstance() {
		if (instance == null) {
			instance = new ConnectDB();
		}
		return instance;
	}

	public Connection getconn() {
		return conn;
	}

	// thong bao loi csdl
	public void displayError(SQLException ex) {
		System.out.println("String url:  " + urlConnect);
		System.out.println(" Error Message:" + ex.getMessage());
		System.out.println(" SQL State:" + ex.getSQLState());
		System.out.println(" Error Code:" + ex.getErrorCode());
	}

	// mo ket noi voi csdl
	public void open() {
		try {
			Class.forName(Config.DB_DRIVER);
			conn = DriverManager.getConnection(urlConnect);
		} catch (SQLException e) {
			displayError(e);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			displayError(e);
		}
	}

	public void excuteQuery(String sql) {// danh cho cau lenh secect
		try {

			stm = conn.prepareStatement(sql);
			stm.executeUpdate();
		} catch (SQLException ex) {
			displayError(ex);
		}
	}

	// Dành cho câu lệnh SELECT
	public ResultSet executeQuery(String query, ArrayList<Object> arrObj) {
		ResultSet rs = null;
		try {

			stm = conn.prepareStatement(query);
			if (arrObj.size() > 0) {
				for (int i = 0; i < arrObj.size(); i++) {
					stm.setObject(i + 1, arrObj.get(i));
				}
			}
			rs = stm.executeQuery();
//			stm.close();
		} catch (SQLException e) {
			displayError(e);
		}
		return rs;
	}

	public String executeQuery(String query) {
		String rs = null;
		try {

			stm = conn.prepareStatement(query);
			stm.executeUpdate();
		} catch (SQLException ex) {
			displayError(ex);
		}
		return rs;
	}

	// CREATE, UPDATE, DROP, DELETE
	public int executeUpdate(String query, ArrayList<Object> arrObj) {
		int rs = 1;
		try {

			stm = conn.prepareStatement(query);
			if (arrObj.size() > 0) {
				for (int i = 0; i < arrObj.size(); i++) {
					stm.setObject(i + 1, arrObj.get(i));
				}
			}
			stm.executeUpdate();
		} catch (SQLException e) {
			displayError(e);
		}
		return rs;
	}

	public ResultSet executeInsert(String query, ArrayList<Object> arrObj) {
		ResultSet rSet = null;
		try {
			stm = conn.prepareStatement(query);
			if (arrObj.size() > 0) {
				for (int i = 0; i < arrObj.size(); i++) {
					stm.setObject(i + 1, arrObj.get(i));
				}
			}
			stm.executeUpdate();
		} catch (SQLException e) {
			displayError(e);
		}
		return rSet;
	}
}
