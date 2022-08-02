package application2;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

//K dùng fxml
public class Main extends Application implements EventHandler<ActionEvent>{
	Button button;
	Button button2;
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			Scene scene = new Scene(root, 400, 400);
			
			button = new Button();
			button2 = new Button();
			//Thực tế button set vào 1 class EventHandler là được. Khi có sự kiện nó sẽ tự tìm đến hàm handle của class đó để chạy
			//Có thể truyền dạng anonymous như bài trước or truyền lamba function cx đc, or tạo 1 class riêng và import r truyền vào đây
			//miễn class đó implement interface EventHandler
			root.getChildren().add(button);
			root.getChildren().add(button2);
			button.setText("Click me");
			button2.setText("C");
			button.setOnAction(this);
			
			button2.setOnAction(e -> System.out.println("Test"));
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(arg0.getSource() == button) {
			System.out.println("Clicked");
		}
	}
}
