package application;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
	
	@FXML
	private ImageView myImageView;
	Image myImage = new Image(getClass().getResourceAsStream("tinkerbellgarden2.png"));
	
	public void displayImage() {
		myImageView.setImage(myImage);
	}
	
	public void moveUp() {
		
		System.out.println("MOVIN' UP!");
	}
	
	public void moveDown() {
		
		System.out.println("MOVIN' DOWN!");
	}
	
	public void moveLeft() {
		
		System.out.println("MOVIN' LEFT!");
	}
	
	public void moveRight() {
		
		System.out.println("MOVIN' RIGHT!");
	}

}