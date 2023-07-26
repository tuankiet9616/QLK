package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomePageController implements Initializable {

	private Stage stage;
	private Parent root;

	@FXML
	VBox vboxHome, voxMain;
	@FXML
	private Pane panePage;

	@FXML
	private List<Button> menus;

	@FXML
	private BorderPane mainPane;

	@FXML
	private Label lbClose, lbMaximize, lbMinimize, lbRestore;

	@FXML
	private MaterialDesignIconView dsgIconMaximize, dsgIconMinimize;

	@FXML
	private Button btnTrangChu;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		lbiconClose = GlyphsDude.createIconLabel(MaterialDesignIcon.CLOSE, "CLose", "18px", "18px", ContentDisplay.CENTER);
//		loadFXML("TrangChu");
		loadFXML("TrangChu");
	}

	public void loadFXML(String fileName) {

		try {
//			root = FXMLLoader.load(getClass().getResource(fileName));
			root = FXMLLoader.load(getClass().getResource("/application/fxml/" + fileName + ".fxml"));
			voxMain.getChildren().clear();
			voxMain.getChildren().addAll(root);
//			stage = new Stage();
//			Scene scene = new Scene(root);
//			stage.setScene(scene);
//			stage.initStyle(StageStyle.UNDECORATED);
//			stage.show();
//			stage.setTitle(fileName);
//			voxMain.getChildren().addAll(null);
			if (root == null) {
				throw new Exception("Not found page");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void btnActionTrangChu(ActionEvent event) {
		Object souceObject = event.getSource();
		Button btnEvent;
		if (souceObject instanceof Button) {
			btnEvent = (Button) souceObject;
		} else {
			return;
		}
		String id = btnEvent.getId();
		switch (id) {
		case "btnTrangChu": {
			loadFXML("TrangChu");
//			root = loadFXML("TrangChu");
//			
//			voxMain.getChildren().clear();
//			voxMain.getChildren().setAll(root);

			break;
		}
		case "btnMuaHang": {
			loadFXML("MuaHang");
//			root = loadFXML("MuaHang");
//			voxMain.getChildren().clear();
//			voxMain.getChildren().setAll(root);
			break;

		}
		case "btnBanHang": {
			loadFXML("BanHang");
//			root = loadFXML("BanHang");
//			voxMain.getChildren().clear();
//			voxMain.getChildren().setAll(root);
			break;

		}
		case "btnDanhMuc": {
			loadFXML("DanhMuc");
//			root = loadFXML("DanhMuc");
//			voxMain.getChildren().clear();
//			voxMain.getChildren().setAll(root);
			break;

		}
		case "btnTongHop": {
			loadFXML("TongHop");
//			root = loadFXML("TongHop");
//			voxMain.getChildren().clear();
//			voxMain.getChildren().setAll(root);
			break;

		}
		case "btnHeThong": {
			loadFXML("HeThong");
//			root = loadFXML("HeThong");
//			voxMain.getChildren().clear();
//			voxMain.getChildren().setAll(root);
			break;
		}
		case "btnBaoCao": {
			loadFXML("BaoCao");
//			root = loadFXML("BaoCao");
//			voxMain.getChildren().clear();
//			voxMain.getChildren().setAll(root);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);
		}
//		try {
//			if(event.getSource() == btnTrangChu) {
//				
//				root = loadFXML("TrangChu");
//				voxMain.getChildren().setAll(root);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();

	}

	@FXML
	private void close(MouseEvent mouseEvent) {
		stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		stage.close();
	}

	@FXML
	private void maximize(MouseEvent mouseEvent) {
		stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		stage.setMaximized(true);
		if (stage.isMaximized()) {
			lbRestore.setVisible(true);
			lbMaximize.setVisible(false);
		} else {

			lbRestore.setVisible(true);
		}
	}

	@FXML
	private void restore(MouseEvent mouseEvent) {
		stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		stage.setMaximized(false);
		stage.setWidth(1280);
		stage.setHeight(800);
		if (stage.isMaximized() == false) {
			lbRestore.setVisible(false);
			lbMaximize.setVisible(true);
		}
	}

	@FXML
	private void minimize(MouseEvent mouseEvent) {
		stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		stage.setIconified(true);
	}

}
