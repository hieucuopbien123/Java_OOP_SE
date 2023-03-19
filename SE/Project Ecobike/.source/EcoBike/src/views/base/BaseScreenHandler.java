package views.base;

import java.io.IOException; 
import java.util.Hashtable;
import java.util.List;

import controller.BaseController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.screen.home.HomeScreenHandler;

public class BaseScreenHandler extends FXMLScreenHandler {

	private Scene scene;
	protected final Stage stage;
	protected HomeScreenHandler homeScreenHandler;
	private BaseController bController;
	
	private BaseScreenHandler(String screenPath) throws IOException {
		super(screenPath);
		this.stage = new Stage();
	}

	public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
		super(screenPath);
		this.stage = stage;
	}

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.content);
		}
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	public void setBController(BaseController bController){
		this.bController = bController;
	}

	public BaseController getBController(){
		return this.bController;
	}
	
	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
	}

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}

}
