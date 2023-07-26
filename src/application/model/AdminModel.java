package application.model;

public class AdminModel {
	private int adminID;

	private int roleId;

	private String adminLastName;

	private String adminFirstName;

	private String userLogin;

	private String userPass;

	private String userNameHost;
	
	public AdminModel() {}

	public AdminModel(int adminID, int roleId, String adminLastName, String adminFirstName, String userLogin,
			String userPass, String userNameHost) {
		super();
		this.adminID = adminID;
		this.roleId = roleId;
		this.adminLastName = adminLastName;
		this.adminFirstName = adminFirstName;
		this.userLogin = userLogin;
		this.userPass = userPass;
		this.userNameHost = userNameHost;
	}
	
}
