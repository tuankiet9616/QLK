package application.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.DAO.CustomeDAO;
import application.DAO.NotificationDAO;
import application.config.ConfigDateTime;
import application.model.CustomModel;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.util.Callback;

public class BanHangController implements Initializable {

	private final CustomeDAO cusDAO = new CustomeDAO();
	private final NotificationDAO notificationDAO = new NotificationDAO();
	private final String cssString = getClass().getResource("/application/fxml/style.css").toExternalForm();
//	private final CustomModel cusModel = new CustomModel();
	@FXML
	private TableView<CustomModel> tbViewCustom;
	@FXML
	private TableColumn<CustomeDAO, Integer> tcID;
	@FXML
	private TableColumn<CustomeDAO, String> tcCodeCus, tcHoTenKH, tcEmail, tcNumbPhone, tcTGD, tcAddress, tcNameAccBank,
			tcNumbAccBank, tcAction;
	@FXML
	private Button btnReset, btnSave, btnTimKiem, btnRefreshTableView;
	@FXML
	private TextField txtCodeCus, txtFistName, txtLastName, txtEmail, txtNumPhone, txtTenGD, txtDuong, txtHuyen,
			txtTinhTP, txtNameAccBank, txtNumAccBank, txtNumFax;
	@FXML
	private Label lbLabel;
	@FXML
	private TabPane tabBanHang;
	@FXML
	private Tab tabDonHang, tabXuatHang;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getClass().getResource(cssString);
		actionEvnt();
		loadDataCus();
		init();
	}

	private AnchorPane loadTab(String fileName) {
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/fxml/" + fileName + ".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}

	private void init() {
		tabBanHang.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == tabDonHang) {
				tabDonHang.setContent(loadTab("TabDonHang"));
			} else if (newValue == tabXuatHang) {
				tabXuatHang.setContent(loadTab("TabXuatHang"));
			}
		});
	}

	private void loadDataCus() {
//		addListData();
		ObservableList<CustomModel> dataCus = FXCollections.observableArrayList();
		ArrayList<CustomModel> arrCus = new ArrayList<>();
		arrCus = cusDAO.getInstance().getListCustom();
		if (arrCus != null) {
			for (int i = 0; i < arrCus.size(); i++) {
				dataCus.addAll(FXCollections.observableArrayList(arrCus.get(i)));
			}
		} else {
			System.out.println("Error: arr is null");
		}
		tcID.setCellValueFactory(new PropertyValueFactory<>("idCustom"));
		tcCodeCus.setCellValueFactory(new PropertyValueFactory<>("codeCus"));
		tcHoTenKH.setCellValueFactory(new PropertyValueFactory<>("hoten"));
		tcNumbPhone.setCellValueFactory(new PropertyValueFactory<>("numberPhoneCus"));
		tcEmail.setCellValueFactory(new PropertyValueFactory<>("emailCus"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<>("addressCus"));
		tcTGD.setCellValueFactory(new PropertyValueFactory<>("nameTrade"));
		tcNameAccBank.setCellValueFactory(new PropertyValueFactory<>("nameAccBank"));
		tcNumbAccBank.setCellValueFactory(new PropertyValueFactory<>("numAccBank"));

		tcAction.setCellFactory(new Callback<TableColumn<CustomeDAO, String>, TableCell<CustomeDAO, String>>() {
			@Override
			public TableCell<CustomeDAO, String> call(TableColumn<CustomeDAO, String> param) {
				final TableCell<CustomeDAO, String> cell = new TableCell<>() {
					private Button btn = new Button();
					private Button btn2 = new Button();

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {

							btn.setStyle("-fx-background-color:none;-fx-border-color:none");
							btn.setGraphic(new MaterialDesignIconView(MaterialDesignIcon.EYE));
							btn2.setStyle("-fx-background-color:none;-fx-border-color:none");
							btn2.setGraphic(new MaterialDesignIconView(MaterialDesignIcon.PEN));
							HBox hb = new HBox(btn, btn2);
							
							setGraphic(hb);
							btn.setOnAction(e -> {
								System.out.println("click view row");
							});
							btn2.setOnAction(e -> {
								System.out.println("Click update row");
							});
						}
					};
				};
				return cell;
			}
		});
		tbViewCustom.setItems(dataCus);
	}

	private void actionEvnt() {
		btnSave.setOnMouseClicked(e -> {
			try {
				themKhachHang();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btnReset.setOnMouseClicked(e -> {
			try {
				resetDataInputControl();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		btnRefreshTableView.setOnMouseClicked(e -> {
			try {
				loadDataCus();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
	}

	private void resetDataInputControl() {
		txtCodeCus.setText("");
		txtFistName.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtNameAccBank.setText("");
		txtNumAccBank.setText("");
		txtTenGD.setText("");
		txtNumPhone.setText("");
		txtNumFax.setText("");
		txtDuong.setText("");
		txtHuyen.setText("");
		txtTinhTP.setText("");

		lbLabel.setVisible(false);
		if (lbLabel.isVisible() == false) {
			txtCodeCus.setLayoutY(10);
			txtFistName.setLayoutY(10);
			txtLastName.setLayoutY(10);
			txtEmail.setLayoutY(10);
			txtDuong.setLayoutY(10);
			txtHuyen.setLayoutY(10);
			txtTinhTP.setLayoutY(10);
			txtNumPhone.setLayoutY(10);
			txtNameAccBank.setLayoutY(10);
			txtNumAccBank.setLayoutY(10);
			txtTenGD.setLayoutY(10);

		}
	}

	private void themKhachHang() {
		Window own = btnSave.getScene().getWindow();
		String maKH = txtCodeCus.getText();
		String firstNameCus = txtFistName.getText();
		String lastNameCus = txtLastName.getText();
		String emailCus = txtEmail.getText();
		String nameAccBank = txtNameAccBank.getText();
		String numAccBank = txtNumAccBank.getText();
		String nameTrade = txtTenGD.getText();
		String numPhone = txtNumPhone.getText();
		String numFax = txtNumFax.getText();
		String addrStreet = txtDuong.getText();
		String addrWard = txtHuyen.getText();
		String addrCity = txtTinhTP.getText();
		String address = addrStreet.concat(addrWard).concat(addrCity);
		String strDate = ConfigDateTime.getInstance().DateNow + " " + ConfigDateTime.getInstance().TimeNow;

		if (maKH.equals("") || "".equals(maKH)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtCodeCus.setLayoutY(15);
		}
		if (firstNameCus.equals("") || "".equals(firstNameCus)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtFistName.setLayoutY(15);
		}
		if (lastNameCus.equals("") || "".equals(lastNameCus)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtLastName.setLayoutY(15);
		}
		if (emailCus.equals("") || "".equals(emailCus)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtEmail.setLayoutY(15);
		}
		if (addrCity.equals("") || "".equals(addrCity)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtDuong.setLayoutY(15);
		}
		if (addrStreet.equals("") || "".equals(addrStreet)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtHuyen.setLayoutY(15);
		}
		if (numPhone.equals("") || "".equals(numPhone)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtTinhTP.setLayoutY(15);
		}
		if (nameTrade.equals("") || "".equals(nameTrade)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtTenGD.setLayoutY(15);
		}
		if (numAccBank.equals("") || "".equals(numAccBank)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtNumAccBank.setLayoutY(15);
		}
		if (nameAccBank.equals("") || "".equals(nameAccBank)) {
			lbLabel = new Label();
			showAlertByLabel("Not Blank");
			txtNameAccBank.setLayoutY(15);
		} else {
			ArrayList<CustomModel> arrLst = new ArrayList<>();
			CustomModel cs = new CustomModel(maKH, firstNameCus, lastNameCus, emailCus, address, nameTrade, numPhone,
					numAccBank, nameAccBank, numFax);
			arrLst.add(cs);
			try {
				if (arrLst.size() == 0) {
					showAlert(AlertType.ERROR, own, "Error:", "Thông tin nhập không đúng, bị bỏ trống");
				} else {
					cusDAO.insertCustom(maKH, firstNameCus, lastNameCus, emailCus, address, nameTrade, numPhone,
							numAccBank, nameAccBank, numFax);
					notificationDAO.getInstance().insertThongBao(
							"Thêm KH thành công: Khách hàng " + maKH + " đã được nhập vào hệ thống", strDate, 1);
					resetDataInputControl();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void showAlertByLabel(String text) {
		lbLabel.setText(text);
		lbLabel.setVisible(false);
//		lbLabel.setStyle("-fx-fill-text:red");

	}

	private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}