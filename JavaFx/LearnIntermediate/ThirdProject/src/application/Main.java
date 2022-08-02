package application;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class Main extends Application {
	Button button;
	@Override
	public void start(Stage primaryStage) {
		try {
			Label label2 = new Label();
			Circle circle = new Circle();
			circle.setRadius(50);
			ContextMenu contextMenu = new ContextMenu();
			MenuItem item1 = new MenuItem("Menu item 1");
			item1.setOnAction(event -> {
				label2.setText("Selected menu item 1");
			});
			MenuItem item2 = new MenuItem("Menu item 2");
			item2.setOnAction(event -> {
				label2.setText("Selected menu item 2");
			});
			contextMenu.getItems().addAll(item1, item2);
			circle.setOnContextMenuRequested(event -> {
				contextMenu.show(circle, event.getScreenX(), event.getScreenY());
			});
			//Còn có CheckMenuItem, RadioMenuItem, SeparatorMenuItem. Dùng Radio phải có ToggleGroup trong 1 nhóm cho nó
			//Sự kiện onShowing, setOnHidden,... bắt các lúc trước và sau bấm hiện ra cái menu và ẩn đi.
			
			IntegerProperty x = new SimpleIntegerProperty(3);
			IntegerProperty y = new SimpleIntegerProperty();
			y.bind(x.multiply(10));
			System.out.println(x.get() + " - " + y.get());
			x.set(5);
			System.out.println(x.get() + " - " + y.get());
			
			Person person = new Person();
			person.firstNameProperty().addListener((v, old, newVal) -> {
				System.out.println("v: " + v);
				System.out.println("old: " + old);
				System.out.println("new: " + newVal);
			});
			
			button = new Button("Submit");
			button.setOnAction(e -> person.setFirstName("test"));
			
			TextField input = new TextField();
			input.setMaxWidth(200);
			Label label = new Label("Content");
			label.textProperty().bind(input.textProperty());
			
			VBox layout = new VBox(10);
			layout.getChildren().addAll(circle, label2, button, input, label);
			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout, 400, 350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
