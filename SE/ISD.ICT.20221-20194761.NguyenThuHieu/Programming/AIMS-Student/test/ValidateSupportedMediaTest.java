import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PlaceRushOrderController;
import entity.media.Media;
import entity.order.OrderMedia;

class ValidateSupportedMediaTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@Test
	public void test() {
		//when
		OrderMedia orderMedia = null;
		boolean isValid = placeRushOrderController.validateSupportedMedia(orderMedia);
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test1() throws SQLException {
		//when
		Media media1 = new Media(1,"One","Music",5,12,"DVD");
		OrderMedia orderMedia1 = new OrderMedia(media1, 1, 5);
		boolean isValid = placeRushOrderController.validateSupportedMedia(orderMedia1);
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test2() throws SQLException {
		//when
		Media media2 = new Media(2,"Two","Music",5,12,"DVD");
		OrderMedia orderMedia2 = new OrderMedia(media2, 2, 10);
		boolean isValid = placeRushOrderController.validateSupportedMedia(orderMedia2);
		//then
		assertEquals(true, isValid);
	}
	@Test
	public void test3() throws SQLException {
		//when
		Media media3 = new Media(3,"Three","Music",5,12,"DVD");
		OrderMedia orderMedia3 = new OrderMedia(media3, 3, 15);
		boolean isValid = placeRushOrderController.validateSupportedMedia(orderMedia3);
		//then
		assertEquals(true, isValid);
	}
	@Test
	public void test4() throws SQLException {
		//when
		Media media4 = new Media(4,"Four","Music",14,12,"DVD");
		OrderMedia orderMedia4 = new OrderMedia(media4, 1, 14);
		boolean isValid = placeRushOrderController.validateSupportedMedia(orderMedia4);
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test5() throws SQLException {
		//when
		Media media5 = new Media(5,"Five","Music",2,12,"DVD");
		OrderMedia orderMedia5 = new OrderMedia(media5, 4, 8);
		boolean isValid = placeRushOrderController.validateSupportedMedia(orderMedia5);
		//then
		assertEquals(false, isValid);
	}

}
