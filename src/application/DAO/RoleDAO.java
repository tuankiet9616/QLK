package application.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.RoleModel;
import application.service.ConnectDB;

public class RoleDAO {
private static RoleDAO instance;
	
	ResultSet resultSet;
	
	public static RoleDAO getInstance(){
		if(instance == null) {
			return instance = new RoleDAO();
		}
		
		return instance;
	}
	
	public ArrayList<RoleModel> getListRole() throws SQLException{
		ArrayList<RoleModel> arrRole = new ArrayList<>();
		ArrayList<Object> obj = new ArrayList<>();
		
		String query = "SELECT * FROM qlk_user_role;";
		
		try {
			ConnectDB.getInstance().open();
			resultSet = ConnectDB.getInstance().executeQuery(query, obj);
			while(resultSet.next()) {
				arrRole.add(new RoleModel(resultSet.getInt("id_role"),
										  resultSet.getString("role_name"),
										  resultSet.getInt("role_type"),
										  resultSet.getInt("role_access")));
			}
			ConnectDB.getInstance().close();
		} catch (SQLException e) {
			ConnectDB.getInstance().displayError(e);
		}
		return arrRole;
	}
	// Check Role User
	public boolean checkRoleUser(int checkId) {
			ArrayList<Object> arrObj = new ArrayList<>();
		
			String query = "select * from qlk_user,qlk_user_role where qlk_user.id_role = "+checkId+";";
		
			try {
				ConnectDB.getInstance().open();
				resultSet = ConnectDB.getInstance().executeQuery(query, arrObj);
				if (resultSet.next()) {
					return true;
				}
				ConnectDB.getInstance().close();
				
			} catch (SQLException exception) {
				exception.printStackTrace();
			} 
		
		return false;
	}
	
	// Check Role Admin
		public boolean checkRoleAdmin(int checkId) {
				ArrayList<Object> arrObj = new ArrayList<>();
			
				String query = "select * from qlk_admin,qlk_user_role where qlk_admin.id_role = "+checkId+";";
			
				try {
					ConnectDB.getInstance().open();
					resultSet = ConnectDB.getInstance().executeQuery(query, arrObj);
					if (resultSet.next()) {
						return true;
					}
					ConnectDB.getInstance().close();
					
				} catch (SQLException exception) {
					exception.printStackTrace();
				} 
			
			return false;
		}
	
	// get role by ID User or Admin
	public RoleModel getRoleDAO(int id) {
		RoleModel result = null;
		ArrayList<Object> obj = new ArrayList<>();
		String query = "SELECT * FROM qlk_user_role WHERE qlk_user_role.id_role = "+id+";";
		try {
			ConnectDB.getInstance().open();
			resultSet = ConnectDB.getInstance().executeQuery(query, obj);
			while(resultSet.next()) {
				result = new RoleModel(resultSet.getInt("id_role"),
									 resultSet.getString("role_name"),
									 resultSet.getInt("role_type"),
									 resultSet.getInt("role_access"));
			}
			ConnectDB.getInstance().open();
		} catch (SQLException e) {
			ConnectDB.getInstance().displayError(e);
		}
	
		return result;
	}
	
}
