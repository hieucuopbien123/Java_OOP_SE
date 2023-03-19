package views.rent;

import java.io.IOException; 
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.dockitem.Bike;
import entity.dockitem.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.BikeServices;
import utils.Configs;
import utils.GlobalStore;
import views.base.BaseScreenHandler;
import views.screen.home.BikeItemHandler;
import views.screen.home.DockItemHandler;
import views.screen.home.EmptyHandler;

public class ScanBarcodeHandler extends BaseScreenHandler implements Initializable{
	@FXML
	private ImageView logo;
	
	@FXML 
	private TextField barcodeinput;
	
	@FXML 
	private Button viewbikebutton;
	
	@FXML
	private HBox bikeinfo;

	public ScanBarcodeHandler(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
    }
	public void initialize(URL arg0, ResourceBundle arg1) {
		logo.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});
		viewbikebutton.setOnMouseClicked(e -> {
			try {
				bikeinfo.getChildren().clear();
				// Lưu vào global
				Bike bike = new BikeServices().getBikeById(barcodeinput.getText().trim());
				
				// Chuyển trang
				BikeFromBarcodeHandler m = new BikeFromBarcodeHandler(this.stage, Configs.BIKEFROMBARCODE_PATH, bike);
				m.setHomeScreenHandler(this.homeScreenHandler);
				bikeinfo.getChildren().add(m.getContent());
			} catch (Exception e1) {
				try {
		        	EmptyHandler empty = new EmptyHandler(Configs.EMPTY_PATH, "No Item Matches");
		        	bikeinfo.getChildren().add(empty.getContent());
				} catch (IOException er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				}
				e1.printStackTrace();
			}
		});
	}
}
