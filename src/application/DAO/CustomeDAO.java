package application.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import application.model.CustomModel;
import application.service.ConnectDB;

public class CustomeDAO {
	private static CustomeDAO instance;
	ResultSet result;

	public CustomeDAO getInstance() {
		if (instance == null) {
			return instance = new CustomeDAO();
		}
		return instance;
	}

	public CustomeDAO() {
	}

	// GetList Data Khach Hang
	public ArrayList<CustomModel> getListCustom() {
		ArrayList<CustomModel> lstArr = new ArrayList<>();
		ArrayList<Object> arrObjects = new ArrayList<>();
//		String query = "SELECT id_khachhang,ho_khachhang,ten_khachhang,diachi_khachhang,email_khachhang,tengiaodich_khachhang,sdt_khachhang,stk_nganhang,ten_nganhang\r\n"
//				+ "from qlk_khachhang,qlk_nganhang;";
		String query = "SELECT * FROM qlk_khachhang";
		try {
			ConnectDB.getInstance().open();
			result = ConnectDB.getInstance().executeQuery(query, arrObjects);
			while (result.next()) {
				lstArr.add(new CustomModel(result.getInt("id_khachhang"), result.getString("maso_khachhang"),
						result.getString("ho_khachhang"), result.getString("ten_khachhang"),
						result.getString("diachi_khachhang"), result.getString("email_khachhang"),
						result.getString("tengiaodich"), result.getString("sdt_khachhang"),
						result.getString("stk_nganhang"), result.getString("ten_nganhang"),
						result.getString("fax_khachhang")));
			}
			ConnectDB.getInstance().close();
		} catch (SQLException e) {
			ConnectDB.getInstance().displayError(e);
		}
		return lstArr;
	}

	public LinkedList<CustomModel> find(String value) {
		LinkedList<CustomModel> rs = new LinkedList<>();
		ArrayList<Object> arrObj = new ArrayList<>();
		String qString = "select * from qlk_khachhang where qlk_khachhang.maso_khachhang = '" + value + "'"
				+ "or qlk_khachhang.ho_khachhang='" + value + "' or qlk_khachhang.ten_khachhang = '" + value + "';";
		try {
			ConnectDB.getInstance().open();
			result = ConnectDB.getInstance().executeQuery(qString, arrObj);
			while (result.next()) {
				rs.add(new CustomModel(result.getInt("id_khachhang"), result.getString("maso_khachhang"),
						result.getString("ho_khachhang"), result.getString("ten_khachhang"),
						result.getString("diachi_khachhang"), result.getString("email_khachhang"),
						result.getString("tengiaodich"), result.getString("sdt_khachhang"),
						result.getString("stk_nganhang"), result.getString("ten_nganhang"),
						result.getString("fax_khachhang")));
			}
			ConnectDB.getInstance().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ArrayList<CustomModel> findCusBy(String cusCode) {
		ArrayList<CustomModel> arr = new ArrayList<>();
		ArrayList<Object> arrObj = new ArrayList<>();
		String qString = "SELECT * FROM qlk_khachhang where qlk_khachhang.maso_khachhang= '" + cusCode + "'";
		try {
			ConnectDB.getInstance().open();
			result = ConnectDB.getInstance().executeQuery(qString, arrObj);
			while (result.next()) {
				arr.add(new CustomModel(result.getInt("id_khachhang"), result.getString("maso_khachhang"),
						result.getString("ho_khachhang"), result.getString("ten_khachhang"),
						result.getString("diachi_khachhang"), result.getString("email_khachhang"),
						result.getString("tengiaodich"), result.getString("sdt_khachhang"),
						result.getString("stk_nganhang"), result.getString("ten_nganhang"),
						result.getString("fax_khachhang")));
			}
			ConnectDB.getInstance().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	// Insert KhachHang
	public CustomModel insertCustom(String codeCus, String firstName, String lastName, String address, String email,
			String nameTrade, String numberPhone, String numAccBank, String nameAccBank, String fax) {
		CustomModel rsCus = new CustomModel(codeCus, firstName, lastName, address, email, nameTrade, numberPhone,
				numAccBank, nameAccBank, fax);
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "INSERT INTO qlk_khachhang(maso_khachhang,ho_khachhang,ten_khachhang,diachi_khachhang,email_khachhang,tengiaodich,sdt_khachhang,stk_nganhang,ten_nganhang,fax_khachhang) \r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?);";

		try {
			ConnectDB.getInstance().open();
			PreparedStatement stm = ConnectDB.getInstance().getconn().prepareStatement(query);
			stm.setString(1, codeCus);
			stm.setString(2, firstName);
			stm.setString(3, lastName);
			stm.setString(4, address);
			stm.setString(5, email);
			stm.setString(6, nameTrade);
			stm.setString(7, numberPhone);
			stm.setString(8, numAccBank);
			stm.setString(9, nameAccBank);
			stm.setString(10, fax);

			stm.executeUpdate();

			stm.close();
			ConnectDB.getInstance().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsCus;
	}

	// Update cus by Id
	public boolean updateCus(String codeCus, String firstName, String lastName, String address, String email,
			String nameTrade, String numberPhone, String numAccBank, String nameAccBank, String fax) {
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "UPDATE qlk_khachhang where";
		ConnectDB.getInstance().open();
		int rs = ConnectDB.getInstance().executeUpdate(query, arrObj);
		ConnectDB.getInstance().close();
		return rs > 0;
	}

	// Delete cus by ID
	public boolean deleteCus(String id) {
		ArrayList<CustomModel> arrayList = new ArrayList<>();
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "";
		ConnectDB.getInstance().open();
		int rs = ConnectDB.getInstance().executeUpdate(query, arrObj);
		ConnectDB.getInstance().close();
		return rs > 0;
	}

	// Insert KhachHang by boolean
	public boolean insertCustomBy(String codeCus, String firstName, String lastName, String address, String email,
			String nameTrade, String numberPhone, String numAccBank, String nameAccBank, String fax) {
		ArrayList<Object> arr = new ArrayList<>();
		String query = "INSERT INTO qlk_khachhang(maso_khachhang,ho_khachhang,ten_khachhang,diachi_khachhang,email_khachhang,tengiaodich,sdt_khachhang,stk_nganhang,ten_nganhang,fax_khachhang) \r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?);";
		try {
			ConnectDB.getInstance().open();
			arr.add(1, codeCus);
			arr.add(2, firstName);
			arr.add(3, lastName);
			arr.add(4, address);
			arr.add(5, email);
			arr.add(6, nameTrade);
			arr.add(7, numberPhone);
			arr.add(8, numAccBank);
			arr.add(9, nameAccBank);
			arr.add(10, fax);
			int rs = ConnectDB.getInstance().executeUpdate(query, arr);
			ConnectDB.getInstance().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
