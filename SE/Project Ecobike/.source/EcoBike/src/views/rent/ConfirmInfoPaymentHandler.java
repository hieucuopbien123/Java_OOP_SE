package views.rent;

import java.io.IOException; 
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import controller.PaymentController;
import entity.card.Card;
import entity.card.PaymentTransaction;
import entity.db.AIMSDB;
import entity.dockitem.Bike;
import entity.dockitem.eBike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import utils.GlobalStore;
import views.base.BaseScreenHandler;
import views.screen.home.HomeScreenHandler;
 
public class ConfirmInfoPaymentHandler extends BaseScreenHandler implements Initializable{
	@FXML
	private ImageView logo;
	
	@FXML
	private Text customername;
	
	@FXML
	private Text cardnum;
	
	@FXML
	private Text balance;
	
	@FXML
	private Text bikecode;
	
	@FXML
	private Text biketype;
	
	@FXML
	private Text status;
	
	@FXML 
	private Text depositcost;
	
	@FXML
	private Text total;
	
	@FXML
	private Button confirmdeposit;
	
	private int depositPrice;
	
    public PaymentController getBController() {
        return (PaymentController) super.getBController();
    }
	
	protected TransactionInfoScreenHandler txScreenHandler;
	public void setTxScreenHandler(TransactionInfoScreenHandler txScreenHandler) {
		this.txScreenHandler = txScreenHandler;
		setBController(new PaymentController());
	}
	
	public ConfirmInfoPaymentHandler(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Bike bike = GlobalStore.getBike();
		Card card = GlobalStore.getCard();
		
		logo.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});
		
		customername.setText(card.getCardholder_name());
		cardnum.setText(card.getCard_number());
		balance.setText("1,000,000 VNĐ");
		bikecode.setText(bike.getBike_code());
		biketype.setText((bike.getTypeWheel() == 1 ? "Single " : "Double ") + (bike.getBikeType() == 0 ? "normal bike" : ("electronic bike - " + ((eBike)bike).getBattery() + "%")));
		if(bike.getTypeWheel() == 1 && bike.getBikeType() == 0) {
			this.depositPrice = 400000;
		} else if(bike.getTypeWheel() == 1 && bike.getBikeType() == 1) {
			this.depositPrice = 700000;
		} else if(bike.getTypeWheel() == 2 && bike.getBikeType() == 0) {
			this.depositPrice = 550000;
		} else {
			this.depositPrice = 800000;
		}
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		depositcost.setText(nf.format(this.depositPrice));
		total.setText(nf.format(this.depositPrice));
		confirmdeposit.setOnMouseClicked(e -> {
			try {
				// POST thanh toán tới server
				PaymentController paymentController = getBController();
				PaymentTransaction paymentTransaction = paymentController.deposit(card, this.depositPrice, "Deposit");
				
				if(paymentTransaction.getErrorCode() != "00") {
					throw new Error(String.format("Error code is %s", paymentTransaction.getErrorCode()));
				}
				
				boolean result = true;
				// Chuyển trang
				if(result == false) {
					String message = "Not enough balance";
		        	ErrorScreenHandler errorHandler;
		            try {
		            	errorHandler = new ErrorScreenHandler(this.stage, Configs.ERR_SCREEN, message);
		            	errorHandler.setScreenTitle("Fail Transaction");
		            	errorHandler.setHomeScreenHandler(homeScreenHandler);
		            	errorHandler.setTxScreenHandler(this.txScreenHandler);
		            	errorHandler.show();
		            } catch (IOException e1) {
		    			e1.printStackTrace();
					}
				} else {
					String message = "You can go back to check your bike renting status";
		        	SuccessDepositHandler successDepositHandler;
		            try {
		            	// Lưu vào database
				        String pattern = "yyyy-MM-dd";
				        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		            	Statement stm = AIMSDB.getConnection().createStatement();
						stm.executeUpdate("INSERT INTO xTransaction VALUES\r\n"
							+ "(N'" + bike.getBike_code() + "', N'" + card.getCard_number() + "', '" + simpleDateFormat.format(new Date()) + "', N'Deposit', " + this.depositPrice + ")"
						);
						ResultSet res = stm.executeQuery("SELECT * FROM Dock \r\n"
								+ "WHERE Dock.dock_id = " + bike.getDockId());
						int numberOfBikeInDock = 0;
						while (res.next()) {
							numberOfBikeInDock = res.getInt("number_of_bike");
				        }
						stm.executeUpdate("\r\n"
							+ "UPDATE Dock\r\n"
							+ "SET number_of_bike = " + (numberOfBikeInDock - 1) + ", number_of_empty_spot = " + (11 - numberOfBikeInDock) + "\r\n"
							+ "WHERE dock_id = " + bike.getDockId() +";");
						stm.executeUpdate("\r\n"
							+ "UPDATE Bike\r\n"
							+ "SET is_renting = 1 WHERE Bike.bike_code = " + bike.getBike_code()
						);
						System.out.printf("\r\n"
								+ "UPDATE Dock\r\n"
								+ "SET number_of_bike = " + (numberOfBikeInDock - 1) + ", number_of_empty_spot = " + (11 - numberOfBikeInDock) + "\r\n"
								+ "WHERE dock_id = " + bike.getDockId() +";");
		            	
		            	GlobalStore.setRenting(true);
		            	GlobalStore.setRentalTime((new Date().getTime()));
		            	GlobalStore.setDepositedAmount(this.depositPrice);
		            	
		            	homeScreenHandler.updateState();
		            	successDepositHandler = new SuccessDepositHandler(this.stage, Configs.SUCCESSDEPOSIT_PATH, message);
		            	successDepositHandler.setHomeScreenHandler(homeScreenHandler);
		            	successDepositHandler.setScreenTitle("Success Transaction");
		            	successDepositHandler.show();
		            } catch (IOException | SQLException e1) {
		    			e1.printStackTrace();
					}
				}
			} catch (Exception err) {
				err.printStackTrace();
			}
		});
	}
}
