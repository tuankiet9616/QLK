package application.fxml;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.util.Duration;

public class SkinButton extends ButtonSkin {
	
	public SkinButton(Button control) {
		super(control);
		 final FadeTransition fadeIn = new FadeTransition(Duration.millis(500));
	        fadeIn.setNode(control);
	        fadeIn.setToValue(0.5);
	        control.setOnMouseEntered(e -> fadeIn.playFromStart());
	        

	        final FadeTransition fadeOut = new FadeTransition(Duration.millis(300));
	        fadeOut.setNode(control);
	        fadeOut.setToValue(1);
	        control.setOnMouseExited(e -> fadeOut.playFromStart());
	        
//	        control.setOpacity(0.5);
	}
}
