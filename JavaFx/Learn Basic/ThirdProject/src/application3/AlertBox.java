package application3;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Làm chay mà k dùng Alert của JavaFx
public class AlertBox {
	
	static boolean check;
	
	public static boolean display(String title, String message) {
		Stage window = new Stage();//stage thực ra là window
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message);
		
		
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(e -> {
			check = true;
			window.close();
		});
		Button noButton = new Button("No");
		noButton.setOnAction(e -> {
			check = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return check;
	}
}
