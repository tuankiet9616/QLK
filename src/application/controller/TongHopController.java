package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class TongHopController implements Initializable {
	private final String cssString = getClass().getResource("/application/fxml/style.css").toExternalForm();
	@FXML
	private TabPane tabTongHop;
	@FXML
	private Tab tabQuanLyHangTon,tabPhieuKK;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
	}
	private AnchorPane loadTab(String fileName) {
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/fxml/" + fileName + ".fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}

	private void init() {
		tabTongHop.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == tabQuanLyHangTon) {
				tabQuanLyHangTon.setContent(loadTab("TongHop"));
			} else if (newValue == tabPhieuKK) {
				tabPhieuKK.setContent(loadTab("TabPhieuKiemKho"));
			}
		});
	}
	
}
