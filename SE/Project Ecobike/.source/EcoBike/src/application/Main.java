package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Configs;
import views.screen.home.HomeScreenHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	HomeScreenHandler homeHandler;
	@Override
	public void start(Stage primaryStage) {
		try {
			// initialize the scene
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(Configs.SPLASH_SCREEN_PATH));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Welcome");
			primaryStage.show();

			// Load splash screen with fade in effect
			FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), root);
			fadeIn.setFromValue(0);
			fadeIn.setToValue(1);
			fadeIn.setCycleCount(1);

			// Finish splash with fade out effect
			FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), root);
			fadeOut.setFromValue(1);
			fadeOut.setToValue(0);
			fadeOut.setCycleCount(1);

			// After fade in, start fade out
			fadeIn.play();

			fadeIn.setOnFinished((e) -> {
				try {
					homeHandler = new HomeScreenHandler(primaryStage, Configs.HOME_PATH);
					fadeOut.play();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});

			// After fade out, load actual content
			fadeOut.setOnFinished((e) -> {
				homeHandler.setScreenTitle("Home Screen");
				homeHandler.show();
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
