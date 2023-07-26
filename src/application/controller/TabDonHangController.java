package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TabDonHangController implements Initializable {

	
	@FXML
    private GridPane gridHangHoa;
	
    @FXML
    private AnchorPane tabPDonHang;
    @FXML
    private Label lbTestLabel;
    @FXML
    private Button btnPlusRow;
    @FXML
    ComboBox<String> cb;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		addRow();
		gridFirst();
		addRow();
	}
	
	@FXML
	private void plus(MouseEvent mouse) {
		
	}
    private void gridFirst() {
    	int col = 10;
    	String[] text = {"","STT","Mã hàng hóa","Tên sản phẩm","Đơn vị","Kích thước","Độ dài","Số lượng","Đơn giá","Thành tiền"};
    	ArrayList<String> lstString = new ArrayList<>();
//    	System.err.println("text: "+text[1]);
    	gridHangHoa.setHgap(0);
    	gridHangHoa.setVgap(0);
    	gridHangHoa.setAlignment(Pos.TOP_LEFT);
    	gridHangHoa.setBorder(new Border(new BorderStroke(Paint.valueOf("#24425A"),BorderStrokeStyle.SOLID,new CornerRadii(1),new BorderWidths(2))));
    	gridHangHoa.add(lbStt(1), 1, 1);
    	for(int i=0;i < col; i++) {
    			gridHangHoa.add(setLabel(text[i]),i,0);
    	}
    }
    private Label setLabel(String text) {
    	Label label = new Label();
    	label.setText(text);
//    	label.setAlignment(Pos.CENTER);
    	label.setStyle("-fx-text-fill:#24425A");
    	return label;
    }
    private Label lbStt(int stt) {
    	Label lbLabel = new Label();
    	String string = Integer.toString(stt);
    	lbLabel.setStyle("-fx-text-fill:#24425A");
    	lbLabel.setText(string);
    	return lbLabel;
    }
    
    private int row = 1;
    private int colt = 0;
    private void addRow() {
    	btnPlusRow.setOnMouseClicked(e->{
    		row++;
    			addCustom(lbStt(row), colt+1, row);
    			addCustom(cbbMaSP("cbbMaSanPham"), colt+2, row);
    			addCustom(txtField("txtTenSanPham","Tên sản phẩm"), colt+3, row);
    			
    			addCustom(txtField("txt2","Đơn vị"), colt+4, row);
        		addCustom(txtField("txt3","Kích thước"), colt+5, row);
        		addCustom(txtField("txt4","Độ dài"), colt+6, row);
    			
    			addCustom(txtField("txt5","Số lượng"), colt+7, row);
    			addCustom(txtField("txt6","Đơn giá"), colt+8, row);
    			addCustom(txtField("txt7","Tổng = col7 * col8"), colt+9, row);
    	});
    }
    private ComboBox<String> cbbMaSP(String id){
//    	String[] typeOption = {"CK/TM","CK - Chuyển khoản","TM - Tiền Mặt"};
//    	ArrayList<String> typeL = new ArrayList<>();
//    	for (String type : typeOption) {
//			typeL.add(type);
//		}
//    	ObservableList<String> data = FXCollections.observableArrayList(typeL);
    	ComboBox<String> cb = new ComboBox<>();
//    	ArrayList<Object> arrCb = new ArrayList<>();
//    	arrCb.add(cb);
    	cb.setId("cbbMaHangHoa");
    	cb.setMinWidth(150);
//    	cb.setItems(data);
    	return cb;
    }
    private void addCustom(Node node,int col,int row) {
    	
    	gridHangHoa.setHgap(0);
    	gridHangHoa.setVgap(0);
    	gridHangHoa.setAlignment(Pos.TOP_LEFT);
    	
    	gridHangHoa.add(node, col, row);
    	GridPane.setMargin(node, new Insets(2, 2, 2, 2));
    	GridPane.setConstraints(node, col, row);
    }
    private TextField txtField(String id,String prom) {
    	TextField text = new TextField();
    	text.setId(id);
    	text.setPromptText(prom);
    	text.setAlignment(Pos.CENTER);
    	return text;
    }
}
