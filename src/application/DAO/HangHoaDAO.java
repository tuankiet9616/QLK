package application.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import application.model.HangHoaModel;
import application.service.ConnectDB;

public class HangHoaDAO {
	private static HangHoaDAO instance;
	private ResultSet result;
	public HangHoaDAO getInstance() {
		if(instance == null) {
			return instance = new HangHoaDAO();
		}
		return instance;
	}
	
	//Lay danh sach HangHoa
	public ArrayList<HangHoaModel> getListHangHoa(){
		ArrayList<HangHoaModel> lstArr = new ArrayList<>();
		ArrayList<Object> arrObj = new ArrayList<>();
		String query = "SELECT * FROM qlk_hanghoa";
		try {
			ConnectDB.getInstance().open();
			result = ConnectDB.getInstance().executeQuery(query, arrObj);
			while(result.next()) {
				lstArr.add(new HangHoaModel(result.getInt("id_hanghoa"),
						result.getString("ma_hanghoa"),
						result.getString(""), query, query, query, 0, 0, 0, 0));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lstArr;
	}
	
	//lay dang sach Ncc va NhomHangHoa
	//Lay danh sach HangHoa theo
	//Insert HangHoa
	//Delete HangHoa
	//Update HangHoa
	
}
