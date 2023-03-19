package views.screen.home;

import java.io.IOException;

import entity.dockitem.Bike;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import views.base.FXMLScreenHandler;

public class EmptyHandler extends FXMLScreenHandler{

	@FXML
	private Text message;
	
    public EmptyHandler(String screenPath, String message) throws IOException{
    	super(screenPath);
    	this.message.setText(message);
    }
}
