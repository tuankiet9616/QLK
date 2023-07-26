package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		String cssString = getClass().getResource("application.css").toExternalForm();
		
		  try {
			  
		  Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/Login.fxml"));
		  Scene scene = new Scene(root);
		  scene.getStylesheets().add(cssString);
		  
		  stage.setScene(scene);
		  stage.setTitle("Đăng Nhập");
		  stage.centerOnScreen();
		  stage.setResizable(false);
		  stage.getIcons().add(new Image("A:\\QLK DV\\JavaFORM\\QLK_DANGVIET_AL\\Images\\icon.png"));
		  stage.setFullScreenExitKeyCombination(null);
		  stage.show();
		  
		  }catch(Exception e) {
			  e.printStackTrace(); 
			  }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
