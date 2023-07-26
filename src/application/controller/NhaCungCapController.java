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

public class NhaCungCapController implements Initializable {
	Scene scene;
	Stage stage;
    @FXML
    private Button btnSave,btnReset;
    @FXML
    private TextField txtTenNCC,txtTenDaiDien,txtDiaChi,txtEmail,txtFax,txtSdt;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    private void cls(MouseEvent event) {
    	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
}
