package application.controller;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class MuaHangController implements Initializable {
	
	@FXML
	private TabPane tabMuaHang;
	@FXML
	private Button btnPlusRow;
	@FXML
	private GridPane gridHH;
	@FXML
	private Tab tabKiemKeHangNhap,tabDatHang;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gridFirst();
		addRow();
		init();
	}
	private AnchorPane loadTab(String fileName) {
		AnchorPane root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/fxml/"+fileName+".fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	private void init() {
		tabMuaHang.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == tabKiemKeHangNhap) {
				tabKiemKeHangNhap.setContent(loadTab("TabKiemKeHangNhap"));
			}else if(newValue == tabDatHang) {
				tabDatHang.getContent();
			}
		});
	}
	private void gridFirst() {
    	int col = 10;
    	String[] text = {"","STT","Mã hàng hóa","Tên sản phẩm","Đơn vị","Kích thước","Độ dài","Số lượng","Đơn giá","Thành tiền"};
//    	ArrayList<String> lstString = new ArrayList<>();
//    	System.err.println("text: "+text[1]);
    	gridHH.setHgap(0);
    	gridHH.setVgap(0);
    	gridHH.setAlignment(Pos.TOP_LEFT);
    	gridHH.setBorder(new Border(new BorderStroke(Paint.valueOf("#24425A"),BorderStrokeStyle.SOLID,new CornerRadii(1),new BorderWidths(2))));
    	gridHH.add(lbStt(1), 1, 1);
    	for(int i=0;i < col; i++) {
    		gridHH.add(setLabel(text[i]),i,0);
    	}
    }
	 private Label lbStt(int stt) {
	    	Label lbLabel = new Label();
	    	String string = Integer.toString(stt);
	    	lbLabel.setStyle("-fx-text-fill:#24425A");
	    	lbLabel.setText(string);
	    	return lbLabel;
	    }
	 private Label setLabel(String text) {
	    	Label label = new Label();
	    	label.setText(text);
//	    	label.setAlignment(Pos.CENTER);
	    	label.setStyle("-fx-text-fill:#24425A");
	    	return label;
	    }
	 int row = 1;
	 int colt = 0;
	 private void addRow() {
		 btnPlusRow.setOnMouseClicked(e->{
	    		row++;
	    			addCustom(lbStt(row), colt+1, row);
	    			addCustom(cbMHH("cbbMaSanPham"), colt+2, row);
	    			addCustom(txtField("txtTenSanPham","Tên sản phẩm"), colt+3, row);
	    			
	    			addCustom(txtField("txt2","Đơn vị"), colt+4, row);
	        		addCustom(txtField("txt3","Kích thước"), colt+5, row);
	        		addCustom(txtField("txt4","Độ dài"), colt+6, row);
	    			
	    			addCustom(txtField("txt5","Số lượng"), colt+7, row);
	    			addCustom(txtField("txt6","Đơn giá"), colt+8, row);
	    			addCustom(txtField("txt7","Tổng = col7 * col8"), colt+9, row);
	    	});
	 }
	 private Node cbMHH(String string) {
		 ComboBox<String> cb = new ComboBox<>();
//	    	ArrayList<Object> arrCb = new ArrayList<>();
//	    	arrCb.add(cb);
	    	cb.setId("cbbMaHangHoa");
	    	cb.setMinWidth(150);
	    	
//	    	cb.setItems(data);
	    	return cb;
	}
	private void addCustom(Node node,int col,int row) {
		 gridHH.setHgap(0);
		 gridHH.setVgap(0);
		 gridHH.setAlignment(Pos.TOP_LEFT);
		 gridHH.add(node, col, row);
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
