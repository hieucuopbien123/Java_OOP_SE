package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import java.sql.Connection;
import utils.*;

public class AIMSDB {

	private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
	private static Connection connect = null;

    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		connect = DriverManager.getConnection(
    				"jdbc:sqlserver://localhost:1433;databaseName=IDSProject;encrypt=true;trustServerCertificate=true;username=123456;password=123456"
    				);
            // LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } 
        return connect;
    }
    

    public static void main(String[] args) {
        AIMSDB.getConnection();
    }
}
