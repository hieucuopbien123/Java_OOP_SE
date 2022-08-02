package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private StringProperty userName = new SimpleStringProperty(this, "firstname", "");

	public StringProperty firstNameProperty() {
		return userName;
	}
	public String getFirstName() {
		return userName.get();
	}
	public void setFirstName(String firstName) {
		this.userName.set(firstName);
	}
	
}
