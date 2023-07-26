package application.model;

public class HangHoaModel{
	
	private int idHangHoa;
	private String maHangHoa;
	private String idNhomHH;
	private String tenHangHoa;
	private String maSanXuat;
	private String donvitinh;
	private float kichthuoc;
	private float dodai;
	public float quycach;
	private float giaban;

	public HangHoaModel(int idHangHoa, String maHangHoa, String idNhomHH, String tenHangHoa, String maSanXuat,
			String donvitinh, float kichthuoc, float dodai, float quycach, float giaban) {
		super();
		this.idHangHoa = idHangHoa;
		this.maHangHoa = maHangHoa;
		this.idNhomHH = idNhomHH;
		this.tenHangHoa = tenHangHoa;
		this.maSanXuat = maSanXuat;
		this.donvitinh = donvitinh;
		this.kichthuoc = kichthuoc;
		this.dodai = dodai;
		this.quycach = quycach;
		this.giaban = giaban;
	}
	public int getIdHangHoa() {
		return idHangHoa;
	}
	public void setIdHangHoa(int idHangHoa) {
		this.idHangHoa = idHangHoa;
	}
	public String getMaHangHoa() {
		return maHangHoa;
	}
	public void setMaHangHoa(String maHangHoa) {
		this.maHangHoa = maHangHoa;
	}
	
	public String getIdNhomHH() {
		return idNhomHH;
	}
	public void setIdNhomHH(String idNhomHH) {
		this.idNhomHH = idNhomHH;
	}
	public String getTenHangHoa() {
		return tenHangHoa;
	}
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public String getMaSanXuat() {
		return maSanXuat;
	}
	public void setMaSanXuat(String maSanXuat) {
		this.maSanXuat = maSanXuat;
	}
	
	public String getDonvitinh() {
		return donvitinh;
	}

	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}

	public float getKichthuoc() {
		return kichthuoc;
	}
	public void setKichthuoc(float kichthuoc) {
		this.kichthuoc = kichthuoc;
	}
	public float getDodai() {
		return dodai;
	}
	public void setDodai(float dodai) {
		this.dodai = dodai;
	}
	public float getQuycach() {
		return kichthuoc*dodai;
	}
	public void setQuycach(float quycach) {
		this.quycach = quycach;
	}
	public float getGiaban() {
		return giaban;
	}
	public void setGiaban(float giaban) {
		this.giaban = giaban;
	}
	
	
	
}
