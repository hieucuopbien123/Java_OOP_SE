package subsystem.interbank;

import java.util.Date;
import java.util.Map;

import common.exception.InternalServerErrorException;
import common.exception.InvalidCardException;
import common.exception.InvalidTransactionAmountException;
import common.exception.InvalidVersionException;
import common.exception.NotEnoughBalanceException;
import common.exception.NotEnoughTransactionInfoException;
import common.exception.SuspiciousTransactionException;
import common.exception.UnrecognizedException;
import entity.card.Card;
import entity.card.PaymentTransaction;
import utils.Configs;
import utils.MyMap;
import utils.Utils;

public class InterbankSubsystemController {
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();
//	private static final String PUBLIC_KEY = "AQzdE8O/fR8=";
//	private static final String SECRET_KEY = "BUXj/7/gHHI=";
	private static final String PAY_COMMAND = "pay";
	private static final String VERSION = "1.0.0";
	
	private String generateData(Map<String, Object> data) {
		return ((MyMap) data).toJSON();
	}
	
	public PaymentTransaction deposit(Card card, int amount, String contents) {
		// Mock API
		return new PaymentTransaction("00", card, "", "", 0, "");
//		
//		Map<String, Object> transaction = new MyMap();
//		try {
//			transaction.putAll(MyMap.toMyMap(card));
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		transaction.put("cardCode", card.getCard_number());
//		transaction.put("owner", card.getCardholder_name());
//		transaction.put("cvvCode", card.getCvvCode());
//		transaction.put("dateExpirated", card.getExpiration_date());
//		transaction.put("command", PAY_COMMAND);
//		transaction.put("transactionContent", contents);
//		transaction.put("amount", amount);
//		transaction.put("createdAt", Utils.getToday());
//
//		Map<String, Object> requestMap = new MyMap();
//		requestMap.put("version", VERSION);
//		requestMap.put("transaction", transaction);
//
//		String responseText = interbankBoundary.query(Configs.PROCESS_TRANSACTION_URL, generateData(requestMap));
//		MyMap response = null;
//		try {
//			response = MyMap.toMyMap(responseText, 0);
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		}
//		return makePaymentTransaction(response);
	}

	private PaymentTransaction makePaymentTransaction(MyMap response) {
		if (response == null)
			return null;
		MyMap transcation = (MyMap) response.get("transaction");
		Card card = new Card((String) transcation.get("owner"), (String) transcation.get("cardCode"), 
				new Date() , "", "", 
				Integer.parseInt((String) transcation.get("cvvCode")));
		PaymentTransaction trans = new PaymentTransaction((String) response.get("errorCode"), card,
				(String) transcation.get("transactionId"), (String) transcation.get("transactionContent"),
				Integer.parseInt((String) transcation.get("amount")), (String) transcation.get("createdAt"));

		switch (trans.getErrorCode()) {
		case "00":
			break;
		case "01":
			throw new InvalidCardException();
		case "02":
			throw new NotEnoughBalanceException();
		case "03":
			throw new InternalServerErrorException();
		case "04":
			throw new SuspiciousTransactionException();
		case "05":
			throw new NotEnoughTransactionInfoException();
		case "06":
			throw new InvalidVersionException();
		case "07":
			throw new InvalidTransactionAmountException();
		default:
			throw new UnrecognizedException();
		}

		return trans;
	}

}