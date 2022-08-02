package application2;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(8);
		pane.setHgap(8);
		
		Label nameLabel = new Label("Age:");
		//dùng style inline
//		nameLabel.setStyle("-fx-text-fill: #e8e8e8");
		nameLabel.setId("bold-label");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		Label passwordLabel = new Label("Password:");
		GridPane.setConstraints(passwordLabel, 0, 1);
		
		TextField nameInput = new TextField("Bucky");
		GridPane.setConstraints(nameInput, 1, 0);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button button = new Button("Login");
		GridPane.setConstraints(button, 1, 2);
		button.setOnAction(e -> {
			isInt(nameInput, nameInput.getText());
			//sử dụng style có sẵn
			//có 2 theme có sẵn thì 1 cái đang dùng, cái còn lại là CASPIAN.
			setUserAgentStylesheet(STYLESHEET_CASPIAN);
		});
		
		pane.getChildren().addAll(nameLabel, passwordLabel, nameInput, passInput, button);
		
		Scene scene = new Scene(pane, 300, 300);
		//thêm file css vào và các class bên trong có thể dùng or custom style thoải mái
		scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}	
	public static boolean isInt(TextField textField, String data) {
		try {
			Integer age = Integer.parseInt(data);
			System.out.println("Your age is " + data);
			textField.getStyleClass().remove("error");
			return true;
		}catch(NumberFormatException e) {
			System.out.println(data + " is not a number");
			//thêm class style
			textField.getStyleClass().add("error");
			return false;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}