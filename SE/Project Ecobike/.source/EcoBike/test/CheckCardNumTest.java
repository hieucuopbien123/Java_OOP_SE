import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import views.rent.TransactionInfoScreenHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class checkCardNumber {

	private TransactionInfoScreenHandler txInfoScreenHandler;
	@BeforeEach
	void setUp() throws Exception {
		txInfoScreenHandler = new TransactionInfoScreenHandler(null, "", null);
	}
	@Test
	public void test() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardNumber("1234");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test1() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardNumber("Hello");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test2() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardNumber("");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test3() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardNumber("0312456783544");
		//then
		assertEquals(true, isValid);
	}
}
