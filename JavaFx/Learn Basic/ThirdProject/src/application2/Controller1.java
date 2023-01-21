package application2;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller1 {
	
	@FXML
	TextField myNameInput;
	Parent root;
	Stage stage;
	Scene scene;
	
	//Cái này đơn giản là gọi 1 hàm của controller B trong controller A khi controller A có sự kiện gì. Rất ez
	public void submit(ActionEvent event) throws IOException {
		String name = myNameInput.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Show.fxml"));
		root = loader.load();
		
		//Mỗi fxml có 1 controller riêng. Do đó ta dùng biến FXMLLoader để load cái scene.fxml đó thì 
		//có thể thao tác rất nhiều thứ với cái scene đó như lấy controller của nó ra
		//Controller object này rất mạnh. Có thể thao tác với mọi properties cũng như functions của controller của scene đó.
		//Đây cx là tính năng chính giúp các controller, các scene tương tác được với nhau
		Controller2 controller2 = loader.getController();
		controller2.display(name);
		
		//Lấy data từ cái event đó là bth. Bh ta lấy hẳn stage của scene chứa event đó
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
