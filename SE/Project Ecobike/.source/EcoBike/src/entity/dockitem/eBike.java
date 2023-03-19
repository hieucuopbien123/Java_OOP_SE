package entity.dockitem;

public class eBike extends Bike {
    int battery;

	public int getBattery() {
		return battery;
	}
	public Bike setBattery(int battery) {
		this.battery = battery;
		return this;
	}
}
