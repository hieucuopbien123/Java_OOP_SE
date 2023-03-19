import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import views.rent.TransactionInfoScreenHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckSecurityCodeTest {

	private TransactionInfoScreenHandler txInfoScreenHandler;
	@BeforeEach
	void setUp() throws Exception {
		txInfoScreenHandler = new TransactionInfoScreenHandler(null, "", null);
	}
	@Test
	public void test() {
		//when
		boolean isValid = txInfoScreenHandler.checkCVVCode("Nguyen Thu Hieu");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test1() {
		//when
		boolean isValid = txInfoScreenHandler.checkCVVCode("12");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test2() {
		//when
		boolean isValid = txInfoScreenHandler.checkCVVCode("12!!12");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test3() {
		//when
		boolean isValid = txInfoScreenHandler.checkCVVCode("123 456 789");
		//then
		assertEquals(true, isValid);
	}
}
