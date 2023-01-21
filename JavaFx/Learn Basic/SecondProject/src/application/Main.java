package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
//		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		// File Main.fxml k ở trong dự án nên phải thêm / ở đầu. Nếu copy vào trong package application thì có thể bỏ / đi
		Scene scene = new Scene(root,600,600,Color.LIGHTSKYBLUE);
//		Scene scene = new Scene(root);//k để kích thước thì nó sẽ hiện kích thước min phải hiện hết scene

		Image icon = new Image("icon.png");
		
	    Text text = new Text();
	    text.setText("WHOOOOOA!!");
	    text.setX(50);
	    text.setY(50);
	    text.setFont(Font.font("Verdana",50));
	    text.setFill(Color.LIMEGREEN);
	  
	    Line line = new Line();
	    line.setStartX(200);
	    line.setStartY(200);
	    line.setEndX(500);
	    line.setEndY(200);
	    line.setStrokeWidth(5);
	    line.setStroke(Color.RED);
	    line.setOpacity(0.5);
	    line.setRotate(45);
	  
	    Rectangle rectangle = new Rectangle();
	    rectangle.setX(100);
	    rectangle.setY(100);
	    rectangle.setWidth(100);
	    rectangle.setHeight(100);
	    rectangle.setFill(Color.BLUE);
	    rectangle.setStrokeWidth(5);
	    rectangle.setStroke(Color.BLACK);
	  
	    Polygon triangle = new Polygon();
	    triangle.getPoints().setAll(
	    		200.0,200.0,
	    		300.0,300.0,
	    		200.0,300.0
	    );
	    triangle.setFill(Color.YELLOW);
	  
	    Circle circle = new Circle();
	    circle.setCenterX(350);
	    circle.setCenterY(350);
	    circle.setRadius(50);
	    circle.setFill(Color.ORANGE);
	  
	    Image image = new Image("icon.png");
	    ImageView imageView = new ImageView(image);
	    imageView.setX(400);
	    imageView.setY(400);
	    
	    root.getChildren().add(text);
	    root.getChildren().add(line);
	    root.getChildren().add(rectangle);
	    root.getChildren().add(triangle);
	    root.getChildren().add(circle);
	    root.getChildren().add(imageView);
		
//		stage.setWidth(100);
//		stage.setHeight(100);
//		stage.setResizable(false);
//		stage.setX(50);
//		stage.getIcons().add(icon);
//		stage.setTitle("State Demo");
//		stage.setFullScreen(true);
//		stage.setFullScreenExitHint("Press q");
//		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);//static method
	}
}
