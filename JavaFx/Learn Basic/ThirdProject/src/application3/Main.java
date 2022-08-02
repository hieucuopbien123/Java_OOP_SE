package application3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Alert box k dùng fxml
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	Button button;
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Test");
		button = new Button("Click Me");
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		button.setOnAction(e -> {
			boolean result = AlertBox.display("Title", "Content");
			System.out.println(result);
		});
		Scene scene = new Scene(layout, 300, 300);
		stage.setScene(scene);
		stage.show();
	}
}
