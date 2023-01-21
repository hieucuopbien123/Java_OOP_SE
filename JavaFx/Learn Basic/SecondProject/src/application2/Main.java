package application2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Bản switch scene k dùng fxml nhanh hơn nhưng k tốt khi dự án lớn cần MVC
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	Scene scene2;
	Scene scene1;
	
	@Override
	public void start(Stage stage) throws Exception {
		Label label1 = new Label("Welcome to first scene");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> stage.setScene(scene2));
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 200, 200);
		
		Label label2 = new Label("Welcome to second scene");
		Button button2 = new Button("Go to scene 1");
		button2.setOnAction(e -> stage.setScene(scene1));
		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(label2, button2);
		scene2 = new Scene(layout2, 200, 200);
		
		stage.setScene(scene1);
		stage.show();
	}
}
