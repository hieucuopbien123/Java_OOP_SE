package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.db.AIMSDB;
import entity.dockitem.Bike;
import entity.dockitem.eBike;

public class BikeServices {
	public List<Bike> getAllBike(int dock_id) throws SQLException{
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("SELECT *\r\n"
        		+ "FROM Bike LEFT JOIN eBike\r\n"
        		+ "ON Bike.bike_code = eBike.id WHERE Bike.dock_id = " + dock_id + "AND Bike.is_renting = 0");
        ArrayList<Bike> medium = new ArrayList<>();
        while (res.next()) {
        	int battery = res.getInt("battery");
        	Bike bike = null;
        	if(battery == 0) {
        		bike = new Bike().setBikeType(0);
        	}else {
        		bike = new eBike().setBattery(battery).setBikeType(1);
        	}
            bike.setBike_code(res.getString("bike_code"))
            	.setLicense_plate(res.getString("license_plate"))
            	.setStatus(res.getInt("status"))
            	.setImage(res.getString("image"))
            	.setTypeWheel(res.getInt("biketype"))
            	.setDockId(res.getInt("dock_id"));
            medium.add(bike);
        }
        return medium;
    }
    
    public Bike getBikeById(String bike_code) throws SQLException{
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("SELECT *\r\n"
        		+ "FROM Bike LEFT JOIN eBike\r\n"
        		+ "ON Bike.bike_code = eBike.id\r\n"
        		+ "WHERE Bike.bike_code = N'" + bike_code + "'");
        System.out.printf("SELECT *\r\n"
        		+ "FROM Bike LEFT JOIN eBike\r\n"
        		+ "ON Bike.bike_code = eBike.id\r\n"
        		+ "WHERE Bike.bike_code = N'" + bike_code + "'");
        res.next();
        int battery = res.getInt("battery");
        Bike bike = null;
    	if(battery == 0) {
    		bike = new Bike().setBikeType(0);
    	}else {
    		bike = new eBike().setBattery(battery).setBikeType(1);
    	}
    	
    	bike.setBike_code(res.getString("bike_code"))
        	.setLicense_plate(res.getString("license_plate"))
        	.setStatus(res.getInt("status"))
        	.setImage(res.getString("image"))
        	.setTypeWheel(res.getInt("biketype"))
    		.setIs_renting(res.getInt("is_renting"))
        	.setDockId(res.getInt("dock_id"));
        return bike;
    }
}
