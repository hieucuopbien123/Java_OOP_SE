package application2;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Form.fxml"));
			Parent root = loader.load();	
			Scene scene = new Scene(root);
			
			primaryStage.setOnCloseRequest(event -> {//lamba function của java
				event.consume();
				logout(primaryStage);	
				//Nếu k có event consume thì nó luôn thực hiện chức năng của event này là tắt cửa sổ.
				//Khi dùng event.consume tức là tính năng cũ mặc định của event này k còn hoạt động nx mà thực hiện trong hàm
			});
			
			//Thực tế có rất nhiều các hàm bắt các event có sẵn của các comps mà ta có thể dùng. Nó nhận vào 1 hàm mà sẽ thực thi mỗi khi có 
			//sự kiện đó

			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Ta muốn k chỉ ấn logout mà ấn nút X đỏ cũng tắt thì phải dùng sự kiện setOnCloseRequest
	//Khi dùng trong file main thì thao tác với stage thoải mái có trong file main mà k cần phải lấy từ biến bind hay event gì cả
	//Khi k còn bindEvent thì dùng như bth chứ k còn bắt ActionEvent nx
    public void logout(Stage stage){	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Do you want to save before exiting?");
		
		if (alert.showAndWait().get() == ButtonType.OK){
			System.out.println("You successfully logged out");
			stage.close();
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
