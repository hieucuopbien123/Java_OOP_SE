package entity.dockitem;

public class Bike {
    String bike_code;
    String license_plate;
    Integer status;
	String image;
	int is_renting;
    int typeWheel = 1; // 2 là đôi, 1 là đơn
    int bikeType = 0; // 0 là thường, 1 là điện
    int dock_id;
    
    public Bike setDockId(int dock_id) {
    	this.dock_id = dock_id;
    	return this;
    }
    public int getDockId() {
    	return dock_id;
    }
    public Bike setIs_renting(int is_renting) {
    	this.is_renting = is_renting;
    	return this;
    }
    public int getIs_renting() {
    	return this.is_renting;
    }    
    public String getBike_code() {
		return bike_code;
	}
	public Bike setBike_code(String bike_code) {
		this.bike_code = bike_code;
		return this;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public Bike setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
		return this;
	}
	public Integer getStatus() {
		return status;
	}
	public Bike setStatus(Integer status) {
		this.status = status;
		return this;
	}
	public String getImage() {
		return image;
	}
	public Bike setImage(String image) {
		this.image = image;
		return this;
	}
	public Bike setTypeWheel(int typeWheel) {
		this.typeWheel = typeWheel;
		return this;
	}
	public int getTypeWheel() {
		return typeWheel;
	}
	public Bike setBikeType(int bikeType) {
		this.bikeType = bikeType;
		return this;
	}
	public int getBikeType() {
		return bikeType;
	}
}
