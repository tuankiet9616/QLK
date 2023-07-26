package application.model;

public class NotificationModel {
	private int idNotificaion;

	private String scriptNotifi;

	private String dateTimeNotifi;

	private int statusFor;

	public NotificationModel(int idNotificaion, String scriptNotifi, String dateTimeNotifi, int statusFor) {
		super();
		this.idNotificaion = idNotificaion;
		this.scriptNotifi = scriptNotifi;
		this.dateTimeNotifi = dateTimeNotifi;
		this.statusFor = statusFor;
	}

	public int getIdNotificaion() {
		return idNotificaion;
	}

	public void setIdNotificaion(int idNotificaion) {
		this.idNotificaion = idNotificaion;
	}

	public String getScriptNotifi() {
		return scriptNotifi;
	}

	public void setScriptNotifi(String scriptNotifi) {
		this.scriptNotifi = scriptNotifi;
	}

	public String getDateTimeNotifi() {
		return dateTimeNotifi;
	}

	public void setDateTimeNotifi(String dateTimeNotifi) {
		this.dateTimeNotifi = dateTimeNotifi;
	}

	public int getStatusFor() {
		return statusFor;
	}

	public void setStatusFor(int statusFor) {
		this.statusFor = statusFor;
	}

}
