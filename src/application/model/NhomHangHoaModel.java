package application.model;

public class NhomHangHoaModel{
	private String idNhomHH;
	private String maNhomHH;
	private String tenNhomHH;
	private int soLuongNHH;

	public NhomHangHoaModel(String idNhomHH, String maNhomHH, String tenNhomHH, int soLuongNHH) {
		super();
		this.idNhomHH = idNhomHH;
		this.maNhomHH = maNhomHH;
		this.tenNhomHH = tenNhomHH;
		this.soLuongNHH = soLuongNHH;
	}


	public String getIdNhomHH() {
		return idNhomHH;
	}


	public void setIdNhomHH(String idNhomHH) {
		this.idNhomHH = idNhomHH;
	}


	public String getMaNhomHH() {
		return maNhomHH;
	}


	public void setMaNhomHH(String maNhomHH) {
		this.maNhomHH = maNhomHH;
	}


	public String getTenNhomHH() {
		return tenNhomHH;
	}


	public void setTenNhomHH(String tenNhomHH) {
		this.tenNhomHH = tenNhomHH;
	}


	public int getSoLuongNHH() {
		return soLuongNHH;
	}


	public void setSoLuongNHH(int soLuongNHH) {
		this.soLuongNHH = soLuongNHH;
	}


	
	
}
