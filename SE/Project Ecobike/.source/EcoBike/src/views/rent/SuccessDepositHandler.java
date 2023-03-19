package views.rent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entity.dockitem.Bike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import utils.GlobalStore;
import views.base.BaseScreenHandler;

public class SuccessDepositHandler extends BaseScreenHandler implements Initializable {
	@FXML
	private ImageView logo;
	
	@FXML
	private Button gobackbutton;
	
	@FXML
	private Text message;
	
	public SuccessDepositHandler(Stage stage, String screenPath, String message) throws IOException{
        super(stage, screenPath);
        this.message.setText(message);
    }
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		logo.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});
		gobackbutton.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});
	}
}
