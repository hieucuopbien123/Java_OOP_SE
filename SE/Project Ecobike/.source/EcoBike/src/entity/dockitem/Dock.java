package entity.dockitem;

public class Dock {
    String dockname;
    String address;
    Integer area;
    int numberOfBike;
    int distance;
    String img;
    int dockid;

    public int getDockId() {
    	return dockid;
    }
    public Dock setDockId(int dockId) {
    	this.dockid = dockId;
    	return this;
    }
    public String getDockname() {
    	return dockname;
    }
    public Integer getArea() {
		return area;
	}
	public Dock setArea(Integer area) {
		this.area = area;
		return this;
	}
	public int getNumberOfBike() {
		return numberOfBike;
	}
	public Dock setNumberOfBike(int numberOfBike) {
		this.numberOfBike = numberOfBike;
		return this;
	}
	public int getDistance() {
		return distance;
	}
	public Dock setDistance(int distance) {
		this.distance = distance;
		return this;
	}
	public String getImg() {
		return img;
	}
	public Dock setImg(String img) {
		this.img = img;
		return this;
	}
	public Dock setDockname(String _dockname) {
    	dockname = _dockname;
    	return this;
    }
    public String getAddress() {
    	return address;
    }
    public Dock setAddress(String _address) {
    	address = _address;
    	return this;
    }
}
