package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		
		//Ở đây ta cho controller độc lập nhau được
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
		Parent root = loader.load();
		Controller controller = loader.getController();
		//chú ý là lấy controller phải lấy sau khi loader.load() nhé vì load đc trc mới lấy được controller
		
		//Tạo 1 instacen controller mà chơi cx được. Cái trên chỉ là controller tạo sẵn trong view thì lấy thôi thì nếu 
		//trong view có dùng gì liên kết với controller thì controller đổi sẽ hiển thị khác được. Hoàn toàn tùy biến
//		Controller controller = new Controller();

		Scene scene = new Scene(root);
		//Viết chữ k dấu cho đỡ lỗi
		//có thể dùng lamba expression là (event -> {switch() case luôn})
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
					case W:
						controller.moveUp();
						break;
					case S:
						controller.moveDown();
						break;
					case A:
						controller.moveLeft();
						break;
					case D:
						controller.moveRight();
						break;
					default:
						break;
				}		
			}	
		});

		stage.setScene(scene);
		stage.show();
	}	

	public static void main(String[] args) {
		launch(args);
	}
}