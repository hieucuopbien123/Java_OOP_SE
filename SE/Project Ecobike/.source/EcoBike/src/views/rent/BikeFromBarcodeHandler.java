package views.rent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.dockitem.Bike;
import entity.dockitem.Dock;
import entity.dockitem.eBike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import utils.GlobalStore;
import views.base.BaseScreenHandler;
import views.base.FXMLScreenHandler;
import views.screen.home.HomeScreenHandler;

public class BikeFromBarcodeHandler extends BaseScreenHandler implements Initializable{
	@FXML
    protected ImageView imagebike;
    
    @FXML
    protected Text bikecode;
    
    @FXML
    protected Text licensePlate;
    
    @FXML
    protected Text statusText;
    
    @FXML
    protected Text biketype;
    
    @FXML
    protected Text biketype2;
    
    @FXML 
    protected Button rentthisbikebutton;
    
    private Bike bike;
    
    public BikeFromBarcodeHandler(Stage stage, String screenPath, Bike bike) throws IOException{
        super(stage, screenPath);
        this.bike = bike;
        
        String[] status = {"Bad", "OK", "Good"};
        
        bikecode.setText(String.format("%s", bike.getBike_code()));
        licensePlate.setText(String.format("License: %s", bike.getLicense_plate()));
        statusText.setText(String.format("Status: %s", status[bike.getStatus()]));
        biketype.setText(String.format("%s %s", bike.getBikeType() == 0 ? "Normal Bike" : "eBike -", bike.getBikeType() == 0 ? "" : "Battery " + (Integer.toString(((eBike)bike).getBattery()) + "%")));
		biketype2.setText(String.format("Type: %s", bike.getTypeWheel() == 1 ? "Single" : "Double"));
        File file = new File(bike.getImage());
		Image im = new Image(file.toURI().toString());
		imagebike.setImage(im);
		if(bike.getIs_renting() == 1) {
			rentthisbikebutton.setText("This bike is rented");
			rentthisbikebutton.setDisable(true);
		}
    }
    
    public void initialize(URL arg0, ResourceBundle arg1) {	
    	rentthisbikebutton.setOnMouseClicked(e -> {
            try {
				GlobalStore.setBike(bike);
        		TransactionInfoScreenHandler txScreen = new TransactionInfoScreenHandler(this.stage, Configs.TRANSINFO_PATH, this.homeScreenHandler);
        		txScreen.setScreenTitle("Choose payment method");
                txScreen.show();
            } catch (IOException e1) {
    			e1.printStackTrace();
            }
    	});
    }
}
