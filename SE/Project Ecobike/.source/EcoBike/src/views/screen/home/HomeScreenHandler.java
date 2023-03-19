package views.screen.home;

import java.io.IOException;    
import java.util.logging.Logger;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import entity.db.AIMSDB;
import entity.dockitem.Bike;
import entity.dockitem.Dock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import services.BikeServices;
import services.DockServices;
import utils.Configs;
import utils.GlobalStore;
import utils.Utils;
import views.base.BaseScreenHandler;
import views.rent.ErrorScreenHandler;
import views.rent.ScanBarcodeHandler;
import views.rent.ViewBikeScreenHandler;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable{

    public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());
    @FXML
    private VBox vBoxDock;
    
    @FXML
    private TextField textdocksearch;
    
    @FXML
    private Button docksearchbutton;
    
    @FXML
    private Button rentbutton;
    
    @FXML
    private Button viewbikebutton;
    
    @FXML
    private Button gobackbutton;

    private List<DockItemHandler> homeItems;
    private List<List<BikeItemHandler>> bikeItems;
    
    public void fetchDatabase() throws SQLException, IOException {
		List<Dock> dockList = new DockServices().getAllDock();
    	this.bikeItems = new ArrayList<List<BikeItemHandler>>();
        this.homeItems = new ArrayList<>();
        int count = 0;
        for (Object object : dockList) {
        	Dock dock = (Dock)object;
            DockItemHandler m1 = new DockItemHandler(this.stage, Configs.DOCKITEM_PATH, dock, count, this);
            m1.setHomeScreenHandler(this);
            this.homeItems.add(m1);

			List<Bike> bikeList = new BikeServices().getAllBike(dock.getDockId());
			this.bikeItems.add(new ArrayList<BikeItemHandler>());
			for (Object object1 : bikeList) {
            	Bike bike = (Bike)object1;
            	BikeItemHandler m2 = new BikeItemHandler(Configs.BIKEITEM_PATH, bike, this);
                this.bikeItems.get(count).add(m2);
            }
			count++;
        }
    }
	
	public HomeScreenHandler(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
        try {
        	viewbikebutton.setVisible(false);
        	fetchDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        addHomeItems(this.homeItems);
        docksearchbutton.setOnMouseClicked(e -> {
        	addHomeItems(this.homeItems);
        });
        rentbutton.setOnMouseClicked(e -> {
        	ScanBarcodeHandler scanbarcodeHandler;
            try {
                scanbarcodeHandler = new ScanBarcodeHandler(this.stage, Configs.SCANBARCODE_PATH);
                scanbarcodeHandler.setScreenTitle("Scan bar code");
                scanbarcodeHandler.setHomeScreenHandler(this);
                scanbarcodeHandler.show();
            } catch (IOException e1) {
    			e1.printStackTrace();
            }
        });
        viewbikebutton.setOnMouseClicked(e -> {
        	ViewBikeScreenHandler viewbikescreenhandler;
            try {
                viewbikescreenhandler = new ViewBikeScreenHandler(this.stage, Configs.VIEWBIKE_PATH);
                viewbikescreenhandler.setHomeScreenHandler(this);
                viewbikescreenhandler.setScreenTitle("View renting bike");
                viewbikescreenhandler.show();
            } catch (IOException e1) {
    			e1.printStackTrace();
            }
        });
        gobackbutton.setOnMouseClicked(e -> {
        	addHomeItems(this.homeItems);
        });
    }

    public void hide(int index) {
		showBikeItem(index);
    }
    
    public void updateState() {
    	try {
			fetchDatabase();
	    	updateButton();
			addHomeItems(this.homeItems);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updateButton() {
    	if(GlobalStore.isRenting() == true) {
    		viewbikebutton.setVisible(true);
    		rentbutton.setVisible(false);
    	} else {
    		viewbikebutton.setVisible(false);
    		rentbutton.setVisible(true);
    	}
    }
    
    public void initialize(URL arg0, ResourceBundle arg1) { // Run before constructor
    	
	}
    public void showBikeItem(int index){
    	gobackbutton.setDisable(false);
        ArrayList mediaItems = (ArrayList)((ArrayList) bikeItems.get(index)).clone();
        vBoxDock.getChildren().clear();
        if(mediaItems.size() == 0) {
			try {
	        	EmptyHandler err = new EmptyHandler(Configs.EMPTY_PATH, "No Item");
	        	vBoxDock.getChildren().add(err.getContent());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            while(!mediaItems.isEmpty()){
            	BikeItemHandler media = (BikeItemHandler) mediaItems.get(0);
                vBoxDock.getChildren().add(media.getContent());
                mediaItems.remove(media);
            }
        }
        return;
    }
	
	 public void addHomeItems(List items){
    	gobackbutton.setDisable(true);
        ArrayList mediaItems = (ArrayList)((ArrayList) items).clone();
        List filteredItems;
        if(textdocksearch.getText().trim() == "") {
        	filteredItems = mediaItems;
        	filteredItems.forEach(me -> {
	            DockItemHandler media = (DockItemHandler) me;
	            if(GlobalStore.isRenting() == true) {
            		media.viewbikebutton.setVisible(false);
            		media.returnbikebutton.setVisible(true);
            		if(media.dock.getNumberOfBike() >= 10) {
            			media.returnbikebutton.setDisable(true);
            		}
            	} else {
            		media.viewbikebutton.setVisible(true);
            		media.returnbikebutton.setVisible(false);
            	}
	        });
        } else {
            filteredItems = new ArrayList<>();
        	mediaItems.forEach(me -> {
	            DockItemHandler media = (DockItemHandler) me;
	            if (media.dockname.getText().trim().contains(textdocksearch.getText().trim())){
	            	if(GlobalStore.isRenting() == true) {
	            		media.viewbikebutton.setVisible(false);
	            		media.returnbikebutton.setVisible(true);
	            		if(media.dock.getNumberOfBike() >= 10) {
	            			media.returnbikebutton.setDisable(true);
	            		}
	            	} else {
	            		media.viewbikebutton.setVisible(true);
	            		media.returnbikebutton.setVisible(false);
	            	}
	            	filteredItems.add(media);
	            }
	        });
        }
        vBoxDock.getChildren().clear();
        while(!filteredItems.isEmpty()){
            DockItemHandler media = (DockItemHandler) filteredItems.get(0);
            vBoxDock.getChildren().add(media.getContent());
            filteredItems.remove(media);
        }
        return;
    }
}
