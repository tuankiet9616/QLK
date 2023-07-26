package application.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import application.model.CustomModel;
import application.model.NotificationModel;
import application.service.ConnectDB;

public class NotificationDAO {
	ResultSet resultSet;

	private static NotificationDAO instance;

	public NotificationDAO getInstance() {
		if (instance == null) {
			return instance = new NotificationDAO();
		}
		return instance;
	}

	public NotificationDAO() {

	}

	// Lay thong tin tu danh sach Thong Bao
	public ArrayList<NotificationModel> getListNotifi() {
		ArrayList<NotificationModel> arrayNotification = new ArrayList<>();
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "SELECT * FROM qlk_thongbao";

		try {
			ConnectDB.getInstance().open();
			resultSet = ConnectDB.getInstance().executeQuery(query, arrObj);
			while (resultSet.next()) {
				arrayNotification.add(
						new NotificationModel(resultSet.getInt("id_thongbao"), resultSet.getString("noidung_thongbao"),
								resultSet.getString("ngay_gio"), resultSet.getInt("trangthai_taikhoan")));
			}

			ConnectDB.getInstance().close();
		} catch (SQLException e) {
			ConnectDB.getInstance().displayError(e);
		}

		return arrayNotification;
	}

	public boolean deleteNotification(int id) {
		ArrayList<NotificationModel> arr = NotificationDAO.instance.getListNotifi();
		String query = "DELETE FROM qlk_thongbao where qlk_thongbao.id_thongbao = " + id + ";";
		ArrayList<Object> arrObj = new ArrayList<>();
		ConnectDB.getInstance().open();
		int rs = ConnectDB.getInstance().executeUpdate(query, arrObj);
		ConnectDB.getInstance().close();
		return rs > 0;

	}
//	public String convertDatetime(String dateString) {
//		String query = "SELECT CONVERT(Datetime,'"+dateString+"',103)";
//		ArrayList<Object> arr = new ArrayList<>();
//		ConnectDB.getInstance().open();
//		String rs = ConnectDB.getInstance().executeQuery(query);
//		return rs;
//	}

	// Tao Thong bao moi INSERT
	public boolean insertThongBao(String script, String dateString, int statusFor) {
		String query = "INSERT INTO qlk_thongbao (noidung_thongbao,ngay_gio,trangthai_taikhoan) " + "VALUES('" + script
				+ "',CONVERT(datetime,'" + dateString + "')," + statusFor + ");";
		ArrayList<Object> arr = new ArrayList<>();
		ConnectDB.getInstance().open();
		int result = ConnectDB.getInstance().executeUpdate(query, arr);
		ConnectDB.getInstance().close();
		return result > 0;
	}
}
