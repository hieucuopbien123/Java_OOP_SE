package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.db.AIMSDB;
import entity.dockitem.Dock;

public class DockServices {
    public List<Dock> getAllDock() throws SQLException{
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("Select * from Dock");
        ArrayList<Dock> medium = new ArrayList<>();
        while (res.next()) {
            Dock dock = new Dock()
                .setDockname(res.getString("name"))
            	.setAddress(res.getString("address"))
            	.setArea(res.getInt("area"))
            	.setNumberOfBike(res.getInt("number_of_bike"))
            	.setDistance(res.getInt("distance"))
            	.setImg(res.getString("img"))
            	.setDockId(res.getInt("dock_id"));
            medium.add(dock);
        }
        return medium;
    }
}
