package utils;

import entity.card.Card;
import entity.dockitem.Bike;

public class GlobalStore {
	private static Card card;
	private static Bike bike;
	private static boolean isRenting = false;
	private static long rentalTime;
	private static int depositedAmount;
	
	public static long getRentalTime() {
		return rentalTime;
	}
	public static void setRentalTime(long rentalTime) {
		GlobalStore.rentalTime = rentalTime;
	}
	public static int getDepositedAmount() {
		return depositedAmount;
	}
	public static void setDepositedAmount(int depositedAmount) {
		GlobalStore.depositedAmount = depositedAmount;
	}
	public static boolean isRenting() {
		return isRenting;
	}
	public static void setRenting(boolean isRenting) {
		GlobalStore.isRenting = isRenting;
	}
	public static void setCard(Card card) {
		GlobalStore.card = card;
	}
	public static Card getCard(){
		return card;
	}
	public static void setBike(Bike bike) {
		GlobalStore.bike = bike;
	}
	public static Bike getBike(){
		return bike;
	}
}
