package application2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller2 {
	
	@FXML
	Label myName;
	@FXML
	private AnchorPane scenePane;
	@FXML
	private Button logoutButton;
	//Ta k cần thao tác gì với LogoutButton thì cx k cần khai báo ở đây trừ khi kiểu ấn thì đổi màu hay gì thì mới cần biến đổi đối tượng 
	//view thành đối tượng Model
	
	Stage stage;
	
	public void display(String userName) {
		myName.setText("Hello " + userName);
	}
	
	public void logout(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		//Ta có thể lấy stage từ event như Controller1 or dùng 1 biến Stage gắn chặt id với Stage hiện tại
		if (alert.showAndWait().get() == ButtonType.OK){
			stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("Logout successfully");
			stage.close();
		}
	}
	
	
	public void moveUp() {
		
		System.out.println("MOVIN' UP!");
	}
	
	public void moveDown() {
		
		System.out.println("MOVIN' DOWN!");
	}
	
	public void moveLeft() {
		
		System.out.println("MOVIN' LEFT!");
	}
	
	public void moveRight() {
		
		System.out.println("MOVIN' RIGHT!");
	}
}
