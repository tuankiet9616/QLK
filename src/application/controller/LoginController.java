package application.controller;

import java.net.InetAddress;
import java.sql.SQLException;

import application.DAO.AdminDAO;
import application.DAO.NotificationDAO;
import application.DAO.UserDAO;
import application.config.ConfigDateTime;
import application.model.UserModel;
import application.service.ConnectDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class LoginController {

	private Stage stage;
	private Scene scene;
	UserModel userModel;
	
	
	@FXML
	private TextField txtIpAddress;

	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtPassWord;

	@FXML
	private TextField txtGetDataSql;

	@FXML
	private Button btnDangNhap;

	@FXML
	private Button btnCheckIp;

	// Check Login Dang nhap
	public void validLogin(ActionEvent event) throws SQLException {

		Window owner = btnDangNhap.getScene().getWindow();

		UserDAO checkUserDAO = new UserDAO();
		AdminDAO checkAdmin = new AdminDAO();
		
		NotificationDAO notificationDAO = new NotificationDAO();
		boolean check = true;

		String name = txtUserName.getText();
		String pass = txtPassWord.getText();
		
		String strDate = ConfigDateTime.getInstance().DateNow + " " + ConfigDateTime.getInstance().TimeNow;
		try {
			
			if (checkUserDAO.checkLoginUser(name, pass)) {
				loadFxmlFormUser();
			}if(checkAdmin.checkLoginAdmin(name, pass)) {
				loadFxmlFormUser();
			}else {
				showAlert(AlertType.ERROR, owner, "FORM ERROR: ", "Login Failed");
			}
			// Tạo ra thông báo đăng nhập cho user
			notificationDAO.getInstance().insertThongBao("Login Success: Xin chao " + name + " dang nhap vao",strDate, 1);
			
		} catch (SQLException e) {
			ConnectDB.getInstance().displayError(e);
		}

		stage = (Stage) btnDangNhap.getScene().getWindow();
		// Đóng stage của Login
		stage.close();

	}
	
	// Get HostAddress and check IP Address
	public void checkIpAddressAdmin(ActionEvent event) {
		Window owner = btnCheckIp.getScene().getWindow();
		String ipAddressString = "";

		if (txtIpAddress.equals("")) {
			showAlert(AlertType.ERROR, owner, "Form Error", "Địa chỉ máy chủ không được bỏ trống");
		} else {
			try {
				InetAddress ipAddress = InetAddress.getLocalHost();
				ipAddressString = ipAddress.getHostAddress();
				txtIpAddress.setText(ipAddressString);

			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	// Form loadFxml khi dang nhap thanh cong
	public void loadFxmlOption() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/MainHome.fxml"));
			stage = new Stage();
			scene = new Scene(root);
			stage.getIcons().add(new Image("A:\\QLK DV\\JavaFORM\\QLK_DANGVIET_AL\\Images\\icon.png"));
			stage.setTitle("Quản lý kho - Admin");
			stage.centerOnScreen();
			stage.setFullScreen(false);
			stage.setScene(scene);
			stage.show();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void loadFxmlFormUser() {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/MainHome.fxml"));
			stage = new Stage();
			scene = new Scene(root);
			stage.getIcons().add(new Image("A:\\QLK DV\\JavaFORM\\QLK_DANGVIET_AL\\Images\\icon.png"));
			stage.setTitle("Form User");
			String cssString = getClass().getResource("/application/application.css").toExternalForm();
			scene.getStylesheets().add(cssString);
			stage.centerOnScreen();
			stage.setFullScreen(false);
			stage.setScene(scene);
			stage.setResizable(true);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	// method: Alert, thong bao.
	private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}
