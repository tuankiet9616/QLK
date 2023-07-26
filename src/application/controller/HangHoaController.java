package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HangHoaController implements Initializable {
	private final String cssString = getClass().getResource("/application/fxml/style.css").toExternalForm();
	Stage stage;
	Scene scene;
	@FXML
	private Button btnAddNCC,btnAddNhomHang;
	@FXML
	private VBox voxDanhMuc;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getClass().getResource(cssString);
		actioneEvent();
	}
	
	private void addNCC() {
		
	}
	private void actioneEvent() {
		btnAddNCC.setOnMouseClicked(e2->{
			try {
//				loadFXMLAddNCC();
				loadFXML("NhaCungCap");
				System.out.println("NCC");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btnAddNhomHang.setOnMouseClicked(e->{
			try {
//				loadFXMLAddNhomHangHoa();
				loadFXML("NhomHang");
				System.out.println("NCC");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
	}
	private void loadFXML(String fileName) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/"+fileName+".fxml"));
			stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setTitle(fileName);
//			voxDanhMuc.getChildren().addAll(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
