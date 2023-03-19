package subsystem;

import entity.card.Card;
import entity.card.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

public class InterbankSubsystem implements InterbankInterface {

	private InterbankSubsystemController ctrl;
	
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}
	
	public PaymentTransaction deposit(Card card, int amount, String contents) {
		return ctrl.deposit(card, amount, contents);
	}
//	/**
//	 * Represent the controller of the subsystem
//	 */
//
//	/**
//	 * Initializes a newly created {@code InterbankSubsystem} object so that it
//	 * represents an Interbank subsystem.
//	 */
//	public InterbankSubsystem() {
//		String str = new String();
//		this.ctrl = new InterbankSubsystemController();
//	}
//
//	/**
//	 * @see InterbankInterface#payOrder(entity.payment.CreditCard, int,
//	 *      java.lang.String)
//	 */
//	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
//		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
//		return transaction;
//	}
//
//	/**
//	 * @see InterbankInterface#refund(entity.payment.CreditCard, int,
//	 *      java.lang.String)
//	 */
//	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
//		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
//		return transaction;
//	}
}
