package subsystem;

import entity.card.Card;
import entity.card.PaymentTransaction;

public interface InterbankInterface {
	
	public abstract PaymentTransaction deposit(Card card, int amount, String contents);
	
}
