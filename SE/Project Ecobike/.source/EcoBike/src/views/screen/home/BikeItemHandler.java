package views.screen.home;

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
import views.base.FXMLScreenHandler;

public class BikeItemHandler extends FXMLScreenHandler implements Initializable{
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
    
    private HomeScreenHandler home;
    private Bike bike;
    
    public BikeItemHandler(String screenPath, Bike bike, HomeScreenHandler home) throws IOException{
        super(screenPath);
        this.bike = bike;
        this.home = home;
        
        String[] status = {"Bad", "OK", "Good"};
        
        bikecode.setText(String.format("Code: %s", bike.getBike_code()));
        licensePlate.setText(String.format("License: %s", bike.getLicense_plate()));
        statusText.setText(String.format("Status: %s", status[bike.getStatus()]));
        biketype.setText(String.format("%s %s", bike.getBikeType() == 0 ? "Normal Bike" : "Electronic Bike", bike.getBikeType() == 0 ? "" : " - Battery " + (Integer.toString(((eBike)bike).getBattery()) + "%")));
        biketype2.setText(String.format("Type: %s", bike.getTypeWheel() == 1 ? "Single" : "Double"));
        
        File file = new File(bike.getImage());
		Image im = new Image(file.toURI().toString());
		imagebike.setImage(im);
    }
    
    public void initialize(URL arg0, ResourceBundle arg1) {	}
}
