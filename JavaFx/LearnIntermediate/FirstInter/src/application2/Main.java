package application2;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		HBox topMenu = new HBox();
		Button button1 = new Button("Button1");
		topMenu.getChildren().add(button1);
		VBox leftMenu = new VBox();
		Button button2 = new Button("Button2");
		leftMenu.getChildren().add(button2);
		BorderPane pane = new BorderPane();
		pane.setTop(topMenu);
		pane.setLeft(leftMenu);
		Scene scene = new Scene(pane, 200, 200);
		stage.setScene(scene);
		stage.show();
		//cái BorderPane chia màn hình thành top center left right bottomm, có nhiều loại pane mà mỗi loại cho 1 kiểu khác nhau
	}	

	public static void main(String[] args) {
		launch(args);
	}
}