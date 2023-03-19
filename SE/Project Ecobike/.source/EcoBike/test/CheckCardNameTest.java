import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import views.rent.TransactionInfoScreenHandler;
import views.screen.home.HomeScreenHandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.stage.Stage;

class CheckCardNameTest {

	private TransactionInfoScreenHandler txInfoScreenHandler;
	@BeforeEach
	void setUp() throws Exception {
		txInfoScreenHandler = new TransactionInfoScreenHandler(null, "", null);
	}
	@Test
	public void test() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardName("Nguyen Thu Hieu");
		//then
		assertEquals(true, isValid);
	}
	@Test
	public void test1() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardName("Nguyen Thu Hieu123");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test2() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardName("");
		//then
		assertEquals(false, isValid);
	}
	@Test
	public void test3() {
		//when
		boolean isValid = txInfoScreenHandler.checkCardName("a");
		//then
		assertEquals(false, isValid);
	}
}
