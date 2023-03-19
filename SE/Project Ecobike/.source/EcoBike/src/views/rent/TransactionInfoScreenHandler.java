package views.rent;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import entity.card.Card;
import entity.db.AIMSDB;
import entity.dockitem.Bike;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import utils.GlobalStore;
import views.base.BaseScreenHandler;
import views.screen.home.HomeScreenHandler;

public class TransactionInfoScreenHandler extends BaseScreenHandler implements Initializable{
	@FXML
	private ImageView logo;
	
	@FXML 
	private TextField cardholdername;
	
	@FXML
	private TextField cardnum;
	
	@FXML
	private TextField issuingbank;
	
	@FXML
	private TextField securitycode;
	
	@FXML
	private Button confirmbutton;

	@FXML
	private Text message;
	
	@FXML
	private TextField cvvCode;
	
	public TransactionInfoScreenHandler(Stage stage, String screenPath, HomeScreenHandler home) throws IOException {
		super(stage, screenPath);
		this.setHomeScreenHandler(home);
		logo.setOnMouseClicked(e -> {
			homeScreenHandler.show();
		});
	}
	
	public boolean checkCardName(String cardname) {
		if(cardname.length() < 2 || !cardname.matches("[a-z A-Z]+")) {
			message.setText("Wrong username!");
			Timer myTimer = new Timer();
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                Platform.runLater(() -> {
	                	message.setText("");
	                });
	            }
	        };
	        myTimer.schedule(task, 1000);
			return false;
		}
		return true;
	}
	public boolean checkCardNumber(String carnum) {
		if(carnum.length() < 5 || carnum.contains("[a-zA-Z]+")) {
			message.setText("Wrong card number!");
			Timer myTimer = new Timer();
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                Platform.runLater(() -> {
	                	message.setText("");
	                });
	            }
	        };
	        myTimer.schedule(task, 1000);
			return false;
		}
		return true;
	}
	public boolean checkSecurityCode(String securityCode) {
		if(securityCode.length() < 3) {
			message.setText("Security code wrong!");
			Timer myTimer = new Timer();
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                Platform.runLater(() -> {
	                	message.setText("");
	                });
	            }
	        };
	        myTimer.schedule(task, 1000);
			return false;
		}
		return true;
	}
	public boolean checkIssuingbank(String issuingbank) {
		if(issuingbank.length() < 2) {
			message.setText("Bank not exist!");
			Timer myTimer = new Timer();
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                Platform.runLater(() -> {
	                	message.setText("");
	                });
	            }
	        };
	        myTimer.schedule(task, 1000);
			return false;
		}
		return true;
	}
	public boolean checkCVVCode(String ccvcode) {
		if(ccvcode.length() < 3 || ccvcode.contains("[a-zA-Z]+")) {
			message.setText("CCV code is wrong!");
			Timer myTimer = new Timer();
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                Platform.runLater(() -> {
	                	message.setText("");
	                });
	            }
	        };
	        myTimer.schedule(task, 1000);
			return false;
		}
		return true;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		confirmbutton.setOnMouseClicked(e -> {
			if(!checkCardName(cardholdername.getText())) {
				return;
			}
			if(!checkCardNumber(cardnum.getText())) {
				return;
			}
			if(!checkIssuingbank(issuingbank.getText())) {
				return;
			}
			if(!checkCVVCode(cvvCode.getText())) {
				return;
			}
			if(!checkSecurityCode(securitycode.getText())) {
				return;
			}
			
			try {
				// Lưu card vào database
				// Thực tế phải check card hợp lệ bằng cách gửi tới server trước r mới lưu vào database chứ kp ai cũng lưu vào tùy tiện khi gõ
				Statement stm = AIMSDB.getConnection().createStatement();
		        String pattern = "yyyy-MM-dd";
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		        Calendar c = Calendar.getInstance();
		        c.setTime(new Date());
		        c.add(Calendar.YEAR, 1);
				stm.executeUpdate("BEGIN\r\n"
						+ "	IF NOT EXISTS (SELECT * FROM Card WHERE card_number = '" + cardnum.getText().trim() + "')\r\n"
						+ "	BEGIN\r\n"
						+ "		INSERT INTO Card VALUES\r\n"
						+ "		(N'" + cardnum.getText() + "', N'" + cardholdername.getText() + "', '" + simpleDateFormat.format(c.getTime()) + "', N'" + issuingbank.getText() + "', '" + securitycode.getText() + "', " + cvvCode.getText() + ")\r\n"
						+ "	END\r\n"
						+ "END");
				// Lưu card vào global đỡ phải fetch 
		        Card card = new Card(cardholdername.getText(), cardnum.getText(), c.getTime(), issuingbank.getText(), securitycode.getText(), Integer.valueOf(cvvCode.getText()));
		        GlobalStore.setCard(card);
				// Chuyển trang
				ConfirmInfoPaymentHandler cfScreen = new ConfirmInfoPaymentHandler(this.stage, Configs.CONFIRMINFO_PATH);
				cfScreen.setScreenTitle("Confirm to deposit");
        		cfScreen.setHomeScreenHandler(this.homeScreenHandler);
        		cfScreen.setTxScreenHandler(this);
        		cfScreen.show();
			} catch (SQLException | IOException e1) {
				e1.printStackTrace();
			}
		});
	}
}
