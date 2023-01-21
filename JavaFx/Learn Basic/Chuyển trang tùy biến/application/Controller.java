package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
	Parent root;
	Stage stage;
	Scene scene;
	
	public void submit(ActionEvent event) throws IOException {
		System.out.print(0);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Show.fxml"));
		root = loader.load();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
