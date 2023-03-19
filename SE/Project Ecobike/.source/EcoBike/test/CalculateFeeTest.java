import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import views.rent.ViewBikeScreenHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateFeeTest {

	private ViewBikeScreenHandler txInfoScreenHandler;
	@BeforeEach
	void setUp() throws Exception {
		txInfoScreenHandler = new ViewBikeScreenHandler(null, "");
	}
	@Test
	public void test() {
		//when
		String fee = txInfoScreenHandler.calculateFee(1000, 1, 1);
		//then
		assertEquals("15,000", fee);
	}
	@Test
	public void test1() {
		//when
		String fee = txInfoScreenHandler.calculateFee(1000, 1, 2);
		//then
		assertEquals("20,000", fee);
	}
	@Test
	public void test2() {
		//when
		String fee = txInfoScreenHandler.calculateFee(3000, 0, 1);
		//then
		assertEquals("16,000", fee);
	}
	@Test
	public void test3() {
		//when
		String fee = txInfoScreenHandler.calculateFee(7500, 0, 2);
		//then
		assertEquals("46,500", fee);
	}
}
