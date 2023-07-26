package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NhomHangHoaController implements Initializable {
	Scene scene;
	Stage stage;
	 @FXML
	 private TextField txtIdNhomHH,txtTenNhom,txtSoLuong,txtDonVi;
	 @FXML
	 private Button btnSave,btnReset;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
    @FXML
    public void close(MouseEvent event) {
    	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
	
}
