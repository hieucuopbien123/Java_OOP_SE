import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PlaceRushOrderController;
import entity.media.Media;
import entity.order.OrderMedia;

class ChangeFormulaShippingFeesTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}
	@Test
	public void test() throws SQLException {
		//when
		OrderMedia orderMedia = null;
		int isValid = placeRushOrderController.changeFormualaShippingFees(orderMedia);
		//then
		assertEquals(0, isValid);
	}
	@Test
	public void test1() throws SQLException {
		//when
		Media media1 = new Media(1,"One","Music",5,12,"DVD");
		OrderMedia orderMedia1 = new OrderMedia(media1, 2, 10);
		int isValid = placeRushOrderController.changeFormualaShippingFees(orderMedia1);
		//then
		assertEquals(20, isValid);
	}
	@Test
	public void test2() throws SQLException {
		//when
		Media media2 = new Media(2,"Two","Music",2,12,"DVD");
		OrderMedia orderMedia2 = new OrderMedia(media2, 3, 15);
		int isValid = placeRushOrderController.changeFormualaShippingFees(orderMedia2);
		//then
		assertEquals(30, isValid);
	}
	@Test
	public void test3() throws SQLException {
		//when
		Media media3 = new Media(3,"Three","Music",7,12,"DVD");
		OrderMedia orderMedia3 = new OrderMedia(media3, 5, 10);
		int isValid = placeRushOrderController.changeFormualaShippingFees(orderMedia3);
		//then
		assertEquals(50, isValid);
	}
}
