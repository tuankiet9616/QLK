package application.model;

public class RoleModel {
	private int idRole;
	private String roleName;
	private int roleType;
	private int roleAccess;
	
	public RoleModel() {}
	
	public RoleModel(int idRole, String roleName, int roleType, int roleAccess) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
		this.roleType = roleType;
		this.roleAccess = roleAccess;
	}
	
	
}
