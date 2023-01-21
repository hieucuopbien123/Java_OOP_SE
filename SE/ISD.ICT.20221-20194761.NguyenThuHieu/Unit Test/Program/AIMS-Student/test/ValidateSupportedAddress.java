import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceRushOrderController;

class ValidateSupportedAddress {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}
	@ParameterizedTest
	@CsvSource({
		"Hanoi,true",
		"hanoi,true",
		"ha noi,true",
		"Ha Noi, true",
		"HaiPhong,false",
		"#$HaNoi,false"
	})

	public void test(String address, boolean expected) {
		//when
		boolean isValid = placeRushOrderController.validateSupportedAddress(address);
		//then
		assertEquals(expected, isValid);
	}

}
