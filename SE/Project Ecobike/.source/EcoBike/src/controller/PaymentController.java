package controller;

import entity.card.Card;
import entity.card.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;

public class PaymentController extends BaseController {
	private InterbankInterface interbank;
	
	public PaymentTransaction deposit(Card card, int amount, String content) {
		try {
			this.interbank = new InterbankSubsystem();
			return this.interbank.deposit(card, amount, content);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
