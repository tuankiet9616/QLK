package application.model;

public class UserModel {
	private int userID;
	
	private int idRole;
	
	private String userLastName;
	
	private String userFirstName;
	
	private String userLogin;
	
	private String userPass;
	
	private String userNameHost;
	
	private String userAddress;
	
	private String userNumberPhone;
	
	private String userDesignation;
	
	private String userPartDesignation;
	
	private int status_user;

	public UserModel() {
		
	}
	
	public UserModel(int userID,int idRole, String userLastName, String userFirstName, String userLogin, String userPass,
			String userNameHost, String userAddress, String userNumberPhone, String userDesignation,
			String userPartDesignation, int status_user) {
		super();
		this.userID = userID;
		this.idRole = idRole;
		this.userLastName = userLastName;
		this.userFirstName = userFirstName;
		this.userLogin = userLogin;
		this.userPass = userPass;
		this.userNameHost = userNameHost;
		this.userAddress = userAddress;
		this.userNumberPhone = userNumberPhone;
		this.userDesignation = userDesignation;
		this.userPartDesignation = userPartDesignation;
		this.status_user = status_user;
	}
}
