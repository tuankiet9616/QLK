package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.DAO.NotificationDAO;
import application.model.NotificationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.util.Callback;

public class TrangChuController implements Initializable {
	NotificationDAO notifDAO = new NotificationDAO();
	private final String cssString = getClass().getResource("/application/fxml/style.css").toExternalForm();
	@FXML
	private TableView<NotificationModel> tbDataThongBao;
	@FXML
	private TableColumn<NotificationModel, String> tcNoidung, tcNgayGio, tcAction;
	@FXML
	private TableColumn<NotificationModel, Integer> tcId, tcTrangThai;
	ObservableList<NotificationModel> data = FXCollections.observableArrayList();
	ArrayList<NotificationModel> arr = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getClass().getResource(cssString);
		loadDataThongBao();

	}

	private void loadDataThongBao() {

		addDataThongBao();
		tcId.setCellValueFactory(new PropertyValueFactory<>("idNotificaion"));
		tcNoidung.setCellValueFactory(new PropertyValueFactory<>("scriptNotifi"));
		tcNgayGio.setCellValueFactory(new PropertyValueFactory<>("dateTimeNotifi"));
		tcTrangThai.setCellValueFactory(new PropertyValueFactory<>("statusFor"));

//		tcAction.setCellFactory(new Callback<TableColumn<NotificationModel,String>, TableCell<NotificationModel,String>>() {
//			
//			@Override
//			public TableCell<NotificationModel, String> call(TableColumn<NotificationModel, String> param) {
//				final TableCell<NotificationModel, String> cell =  new TableCell<>() {
//					private Button btnDelete = new Button("Delete");
//					
//					@Override
//					protected void updateItem(String item, boolean empty) {
//						super.updateItem(item, empty);
//						if(empty) {
//							setGraphic(null);
//						}else {
//							setGraphic(btnDelete);
//							btnDelete.setOnAction(e -> {
////								notifDAO.deleteNotification(getTab);
//								System.out.println("Click test Delete Alert in TrangChu: "+getIndex());
//							});
//						}
//					};
//				};
//				
//				return cell;
//			}
//			
//		});
		tbDataThongBao.setItems(data);
	}

	private void addDataThongBao() {

		arr = notifDAO.getInstance().getListNotifi();
		if (arr != null) {
			for (int i = 0; i < arr.size(); i++) {
				data.addAll(FXCollections.observableArrayList(arr.get(i)));
			}
		} else {
			System.out.println("Error: arr is null");
		}

	}

}
