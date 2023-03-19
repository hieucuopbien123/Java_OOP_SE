package views.rent;

import java.io.File;
import utils.Utils;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import entity.card.Card;
import entity.dockitem.Bike;
import entity.dockitem.eBike;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.GlobalStore;
import views.base.BaseScreenHandler;

public class ViewBikeScreenHandler extends BaseScreenHandler implements Initializable {
	@FXML
	private ImageView logo;
	@FXML 
	private ImageView bikeimage;
	@FXML 
	private Text bikecode;
	@FXML
	private Text licenseplate;
	@FXML
	private Text statusText;
	@FXML
	private Text biketype;
	@FXML
	private Text customername;
	@FXML
	private Text cardnum;
	@FXML
	private Text rentaltime;
	@FXML
	private Text price;
	@FXML
	private Text depositedamount;
	@FXML
	private Button returnbikebutton;
	
	public ViewBikeScreenHandler(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
    }
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		logo.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});
		returnbikebutton.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});

        String[] status = {"Bad", "OK", "Good"};
		Bike bike = GlobalStore.getBike();
		Card card = GlobalStore.getCard();
        File file = new File(bike.getImage());
		Image im = new Image(file.toURI().toString());
		bikeimage.setImage(im);
		bikecode.setText(String.format("Code: %s", bike.getBike_code()));
		licenseplate.setText(String.format("License plate: %s", bike.getLicense_plate()));
        statusText.setText(String.format("Status: %s", status[bike.getStatus()]));
        biketype.setText("Type: " + (bike.getTypeWheel() == 1 ? "Single " : "Double ") + (bike.getBikeType() == 0 ? "normal bike" : ("electronic bike - " + ((eBike)bike).getBattery() + "%")));
        customername.setText(String.format("Customer: %s", card.getCardholder_name()));
        cardnum.setText(String.format("Card number: %s", card.getCard_number()));
        
        // Set thời gian timer
        long now = new Date().getTime();
    	long interval = (now - GlobalStore.getRentalTime())/1000;
    	long hour = interval/3600;
    	long minute = (interval%3600)/60;
    	long second = interval%60;
    	String hourStr = Long.toString(hour).length() < 2 ? "0" + Long.toString(hour) : Long.toString(hour);
    	String minuteStr = Long.toString(minute).length() < 2 ? "0" + Long.toString(minute) : Long.toString(minute);
    	String secondStr = Long.toString(second).length() < 2 ? "0" + Long.toString(second) : Long.toString(second);
    	rentaltime.setText(hourStr + ":" + minuteStr + ":" + secondStr);
        
        // Tính giá tiền
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
        price.setText("Estimated cost: " + nf.format(Math.floor(Utils.calculateFee(interval, bike.getBikeType(), bike.getTypeWheel()))) + " VNĐ");
    	
    	
        Timer myTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
            		Bike bike = GlobalStore.getBike();
            		Card card = GlobalStore.getCard();
                	long now = new Date().getTime();
                	long interval = (now - GlobalStore.getRentalTime())/1000;
                	String hour = Long.toString(interval/3600).length() < 2 ? "0" + Long.toString(interval/3600) : Long.toString(interval/3600);
                	String minute = Long.toString((interval%3600)/60).length() < 2 ? "0" + Long.toString((interval%3600)/60) : Long.toString((interval%3600)/60);
                	String second = Long.toString(interval%60).length() < 2 ? "0" + Long.toString(interval%60) : Long.toString(interval%60);
                	rentaltime.setText(hour + ":" + minute + ":" + second);
                	
                    price.setText("Estimated cost: " + nf.format(Math.floor(Utils.calculateFee(interval, bike.getBikeType(), bike.getTypeWheel()))) + " VNĐ");
                });
            }
        };
        myTimer.scheduleAtFixedRate(task,1000,1000);

		NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
        depositedamount.setText("Deposited amount: " + nf1.format(GlobalStore.getDepositedAmount()) + " VNĐ");
	}
}
