package hust.soict.globalict.aims.order;
import java.util.ArrayList; 
import java.util.List; 

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.test.utils.MyDate;

public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;
	private MyDate dateOrdered;
	public static final int MAX_LIMITTED_ORDERS = 5;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	private static int nbOrders = 0;
	private Media luckyItem = null;
	private Order() {
		dateOrdered = new MyDate();
		if(nbOrders < MAX_LIMITTED_ORDERS)
			nbOrders++;
	}
	public static Order createOrder() {
		if(nbOrders < MAX_LIMITTED_ORDERS) {
			return new Order();
		}
		else {
			System.out.println("Number of orders excess the MAX_LIMITTED_ORDERS");
			return null;
		}
	}
	
	public void addMedia(Media disc) {
		if(itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			if(!itemsOrdered.contains(disc)){
				itemsOrdered.add(disc);
				System.out.println("The disc has been added");
			}
		}
		if(itemsOrdered.size() >= 9) {
			System.out.println("The order is almost full");
		}
	}
	public void removeMedia(Media disc) {
		itemsOrdered.remove(disc);
	}
	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i) != luckyItem) {
				sum += itemsOrdered.get(i).getCost();
			}
		}
		return sum;
	}
	
	public void printList() {
		getALuckyItem();
		System.out.println("\nDate: " 
				+ dateOrdered.getDay() + " " + dateOrdered.getMonth() + " " + dateOrdered.getYear() + "\n"
				+ "Ordered Items:");
		
		for(int i = 0; i < itemsOrdered.size(); i++) {
			System.out.print((i + 1) + ". ");
			if(itemsOrdered.get(i) == luckyItem) {
				System.out.print(itemsOrdered.get(i));
				System.out.println(" - Lucky Item!");
			}else {
				System.out.println(itemsOrdered.get(i));
			}
		}
		
		System.out.println("Total cost: " + totalCost());
		System.out.println("");
	}
	
	public Media getALuckyItem() {
		if(luckyItem == null) {
			int randomIndex;
			if(itemsOrdered.size() != 0) {
				randomIndex = (int)(Math.random()*itemsOrdered.size());
				if(randomIndex == itemsOrdered.size()) {
					randomIndex--;
				}
				luckyItem = itemsOrdered.get(randomIndex);
			}else
				randomIndex = -1;
			return luckyItem;
		} else {
			return luckyItem;
		}
	}
	public void removeById(int idArg) {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == idArg) {
				itemsOrdered.remove(itemsOrdered.get(i));
				System.out.println("Item removed.");
				return;
			}
		}
		System.out.println("This item not existed in the order!!");
	}
}
