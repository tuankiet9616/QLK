package application.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.AdminModel;
import application.service.ConnectDB;

public class AdminDAO {
	
private static AdminDAO instance;
	
	ResultSet resultSet;
	
	public static AdminDAO getInstace() {
		if(instance == null) {
			return instance = new AdminDAO();
		}
		return instance;
	}
	
	public AdminDAO() {}
	
	public ArrayList<AdminModel> getListAdmin() {
		ArrayList<AdminModel> arrAdmin = new ArrayList<>();
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "SELECT * FROM qlk_admin";
		try {
			ConnectDB.getInstance().open();
			
			resultSet = ConnectDB.getInstance().executeQuery(query, arrObj);
			while(resultSet.next()) {
				arrAdmin.add(new AdminModel(resultSet.getInt("id_admin"),
						resultSet.getInt("id_role"),
						resultSet.getString("ho_admin"),
						resultSet.getString("ten_admin"),
						resultSet.getString("tenmaychu_admin"),
						resultSet.getString("userlog_admin"),
						resultSet.getString("pwlog_admin")));
			}
			
			ConnectDB.getInstance().close();
			
		} catch (SQLException e) {
			ConnectDB.getInstance().displayError(e);
		}
		
		return arrAdmin;
	}
	
	// Check Login cua Admin
	public boolean checkLoginAdmin(String name, String pass) {
		
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "SELECT * FROM qlk_admin where qlk_admin.userlog_admin = '"+name+"' AND qlk_admin.pwlog_admin = '"+pass+"';";
												
		try {
			ConnectDB.getInstance().open();
			resultSet = ConnectDB.getInstance().executeQuery(query, arrObj);
			if(resultSet.next()) {
				return true;
			}
			ConnectDB.getInstance().close();
		} catch (SQLException ex) {
			ConnectDB.getInstance().displayError(ex);
		}
		return false;
	}
	
	public AdminModel getAdminModel(String username, String password) {
		AdminModel result = null;
		ArrayList<Object> obj = new ArrayList<>();
		String query = "SELECT * FROM qlk_admin where qlk_admin.userlog_admin = '"+username+"' "
											+ "AND qlk_admin.pwlog_admin = '"+password+"';";
		
		try {
			ConnectDB.getInstance().open();
			resultSet = ConnectDB.getInstance().executeQuery(query, obj);
			while(resultSet.next()) {
				result = (new AdminModel(resultSet.getInt("id_admin"),
						resultSet.getInt("id_role"),
											resultSet.getString("ho_admin"),
											resultSet.getString("ten_admin"),
											resultSet.getString("tenmaychu_admin"),
											resultSet.getString("userlog_admin"),
											resultSet.getString("pwlog_admin")));
			}
			
			ConnectDB.getInstance().close();
		} catch (SQLException e) {
			ConnectDB.getInstance().displayError(e);
		}
		return result;
	}
}
