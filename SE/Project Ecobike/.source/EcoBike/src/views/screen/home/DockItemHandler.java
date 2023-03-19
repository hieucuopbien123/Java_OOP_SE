package views.screen.home;

import java.io.File; 
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import entity.card.Card;
import entity.db.AIMSDB;
import entity.dockitem.Bike;
import entity.dockitem.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import utils.GlobalStore;
import utils.Utils;
import views.base.BaseScreenHandler;
import views.base.FXMLScreenHandler;
import views.rent.ErrorScreenHandler;
import views.rent.SuccessDepositHandler;

public class DockItemHandler extends BaseScreenHandler implements Initializable{
    @FXML
    protected Text dockname;
    
    @FXML
    protected ImageView imageDock;
    
    @FXML
    protected Text distanceText;
    
    @FXML
    protected Text addressText;
    
    @FXML
    protected Text BikeInfo;
    
    @FXML
    protected Button viewbikebutton;
    
    @FXML
    protected Button returnbikebutton;
    
    private HomeScreenHandler home;
    
    private int index;

    protected Dock dock;	
    
	public DockItemHandler(Stage stage, String screenPath, Dock dock, int index, HomeScreenHandler home) throws IOException{
        super(stage, screenPath);
        this.dock = dock;
        this.index = index;
        this.home = home;
        addressText.setText(String.format("Address: %s", dock.getAddress()));
        distanceText.setText(String.format("Distance: %dm - Time to go: %dm - Area: %dm2", dock.getDistance(), (dock.getDistance()/100), dock.getArea()));
        BikeInfo.setText(String.format("Available: %d bikes\nEmpty space: %d", dock.getNumberOfBike(), (10 - dock.getNumberOfBike())));
        dockname.setText(dock.getDockname());
		File file = new File(dock.getImg());
		Image im = new Image(file.toURI().toString());
        imageDock.setImage(im);
    }
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		viewbikebutton.setOnMouseClicked(e -> {
			this.home.hide(index);
		});
		returnbikebutton.setOnMouseClicked(e -> {
			boolean result = true;
			// Chuyển trang
			if(result == false) {
				String message = "Network Error connection";
	        	ErrorScreenHandler errorHandler;
	            try {
	            	errorHandler = new ErrorScreenHandler(this.stage, Configs.ERR_SCREEN, message);
	            	errorHandler.setHomeScreenHandler(homeScreenHandler);
	            	errorHandler.setTxScreenHandler(homeScreenHandler);
	            	errorHandler.show();
	            } catch (IOException e1) {
	    			e1.printStackTrace();
				}
			} else {
				String message = "You can go back homepage to rent bike again";
	        	SuccessDepositHandler successDepositHandler;
            	GlobalStore.setRenting(false);
	            try {
	            	// Lưu xTransaction mới
	            	Bike bike = GlobalStore.getBike();
	            	Card card = GlobalStore.getCard();
	            	String pattern = "yyyy-MM-dd";
			        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	            	Statement stm = AIMSDB.getConnection().createStatement();
	            	
	            	// Tính giá tiền để lưu tx
	                long now = new Date().getTime();
	            	long interval = (now - GlobalStore.getRentalTime())/1000;
	            	double tempPrice = Utils.calculateFee(interval, bike.getBikeType(), bike.getTypeWheel());
	            	
	                ResultSet res = stm.executeQuery("INSERT INTO xTransaction \r\n"
	                	+ "OUTPUT Inserted.tx_id\r\n"
	                	+ "VALUES\r\n"
						+ "(N'" + bike.getBike_code() + "', N'" + card.getCard_number() + "', '" + simpleDateFormat.format(new Date()) + "', N'Return bike', " 
						+ Integer.toString((int)(tempPrice)) + ")"
					);
	                res.next();
	                int tx = res.getInt("tx_id");
	            	
	            	// Lưu rental mới ref tới nó
	                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	                System.out.printf("INSERT INTO Rental\r\n"
	                		+ "VALUES (" + tx + ", N'" + simpleDateFormat2.format(new Date(GlobalStore.getRentalTime())) + "', N'" + simpleDateFormat2.format(new Date()) + "')");
	                stm.executeUpdate("INSERT INTO Rental\r\n"
                		+ "VALUES (" + tx + ", N'" + simpleDateFormat2.format(new Date(GlobalStore.getRentalTime())) + "', N'" + simpleDateFormat2.format(new Date()) + "')");
					
	            	// Update bike
	                stm.executeUpdate("\r\n"
						+ "UPDATE Bike\r\n"
						+ "SET is_renting = 0, dock_id = " + dock.getDockId() + "WHERE Bike.bike_code = " + bike.getBike_code()
					);
	                
	            	// Update dock
					stm.executeUpdate("\r\n"
						+ "UPDATE Dock\r\n"
						+ "SET number_of_bike = " + (dock.getNumberOfBike() + 1) + ", number_of_empty_spot = " + (9 - dock.getNumberOfBike()) + "\r\n"
						+ "WHERE dock_id = " + dock.getDockId() +";");
	                
	                // Update trang homepage
					HomeScreenHandler homeHandler = new HomeScreenHandler(this.stage, Configs.HOME_PATH);
					homeHandler.setScreenTitle("Home Screen");
					homeHandler.updateButton();
	            	
	            	
//	            	homeScreenHandler.updateState();
	            	successDepositHandler = new SuccessDepositHandler(this.stage, Configs.SUCCESSDEPOSIT_PATH, message);
	            	successDepositHandler.setHomeScreenHandler(homeHandler);
	            	successDepositHandler.show();
	            } catch (IOException | SQLException e1) {
	    			e1.printStackTrace();
				}
			}
		});
	}
}