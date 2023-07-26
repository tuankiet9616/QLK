package application.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.UserModel;
import application.service.ConnectDB;

public class UserDAO {
ResultSet resultSet;
	
	private static UserDAO instance;
	
	public UserDAO getInstance() {
		if(instance == null) {
			return instance = new UserDAO();
		}
		return instance;
	}
	
	public UserDAO() {
		
	}
	
	//Get List UserModel tu database
	public ArrayList<UserModel> getListUserModel() throws SQLException{
		
		ArrayList<UserModel> arrUserModels = new ArrayList<>();
		ArrayList<Object> arrObjects = new ArrayList<>();
		
		String query = "select * from qlk_user";
		
		try {
				ConnectDB.getInstance().open();
				resultSet = ConnectDB.getInstance().executeQuery(query, arrObjects);
				while(resultSet.next()) {
					arrUserModels.add(new UserModel(resultSet.getInt("id_user"),
													resultSet.getInt("id_role"),
													resultSet.getString("ho_user"),
													resultSet.getString("ten_user"),
													resultSet.getString("userlog_user"),
													resultSet.getString("pwlogin_user"),
													resultSet.getString("tenmaychu_user"),
													resultSet.getString("diachi_user"),
													resultSet.getString("sdt_user"),
													resultSet.getString("bophan_user"),
													resultSet.getString("chidinh_user"),
													resultSet.getInt("trangthai_user")));
				}
				ConnectDB.getInstance().close();
				
			} catch (SQLException exception) {
				exception.printStackTrace();
			}

		return arrUserModels;
	}
	
	//check Login by User and Pass
	public boolean checkLoginUser(String username,String pass) throws SQLException {
		
		ArrayList<Object> arrObj = new ArrayList<>();
		
		String query = "SELECT * FROM qlk_user where qlk_user.userlog_user = '"+username+"' AND qlk_user.pwlogin_user = '"+pass+"'";
		
			try {
				ConnectDB.getInstance().open();
				resultSet = ConnectDB.getInstance().executeQuery(query, arrObj);
				if (resultSet.next()) {
					return true;
				}
				resultSet.close();
				ConnectDB.getInstance().close();
				
			} catch (SQLException exception) {
				exception.printStackTrace();
			} 
		
		return false;
	}
	
	//Get user by user,pass
	public UserModel getUserModel(String user,String pass) {
		UserModel result = null;
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "SELECT * FROM qlk_user where qlk_user.userlog_user= '"+user
											+"'AND qlk_user.pwlogin_user = '"+pass+"'";
		try {
			ConnectDB.getInstance().open();
			resultSet = ConnectDB.getInstance().executeQuery(query, arrObj);
			while(resultSet.next()) {
				result = (new UserModel(resultSet.getInt("id_user"),
						resultSet.getInt("id_role"),
						resultSet.getString("ho_user"),
						resultSet.getString("ten_user"),
						resultSet.getString("userlog_user"),
						resultSet.getString("pwlogin_user"),
						resultSet.getString("tenmaychu_user"),
						resultSet.getString("diachi_user"),
						resultSet.getString("sdt_user"),
						resultSet.getString("bophan_user"),
						resultSet.getString("chidinh_user"),
						resultSet.getInt("trangthai_user")));
			}
			ConnectDB.getInstance().close();
			
		} catch (SQLException ex) {
			ConnectDB.getInstance().displayError(ex);
		}
		return result;
	}
}
