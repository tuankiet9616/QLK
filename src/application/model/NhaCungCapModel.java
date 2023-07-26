package application.model;

public class NhaCungCapModel {
	private int idNCC;
	private String tenNCC;
	private String tenDaiDien;	
	private String addressNCC;
	private String sdtNCC;
	private String faxNCC;
	private String emailNCC;
	
	
	
	public NhaCungCapModel(int idNCC, String tenNCC, String tenDaiDien, String addressNCC, String sdtNCC, String faxNCC,
			String emailNCC) {
		super();
		this.idNCC = idNCC;
		this.tenNCC = tenNCC;
		this.tenDaiDien = tenDaiDien;
		this.addressNCC = addressNCC;
		this.sdtNCC = sdtNCC;
		this.faxNCC = faxNCC;
		this.emailNCC = emailNCC;
	}
	public String getTenDaiDien() {
		return tenDaiDien;
	}
	public void setTenDaiDien(String tenDaiDien) {
		this.tenDaiDien = tenDaiDien;
	}
	public String getSdtNCC() {
		return sdtNCC;
	}
	public void setSdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}
	public String getFaxNCC() {
		return faxNCC;
	}
	public void setFaxNCC(String faxNCC) {
		this.faxNCC = faxNCC;
	}
	public String getEmailNCC() {
		return emailNCC;
	}
	public void setEmailNCC(String emailNCC) {
		this.emailNCC = emailNCC;
	}
	public int getIdNCC() {
		return idNCC;
	}
	public void setIdNCC(int idNCC) {
		this.idNCC = idNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getAddressNCC() {
		return addressNCC;
	}
	public void setAddressNCC(String addressNCC) {
		this.addressNCC = addressNCC;
	}
	
	
}
