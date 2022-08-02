package hust.soict.globalict.aims;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

public class DiskTest {
	public static void main(String[] args) {
		Order anOrder = Order.createOrder();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
		anOrder.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Jogn Musker", 90, 18.99f);
		anOrder.addMedia(dvd3);
		
		CompactDisc cd1 = new CompactDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addMedia(cd1);
		
		CompactDisc cd2 = new CompactDisc("Star Wars", "George Lucas", "Science Fiction", 124, 24.95f);
		anOrder.addMedia(cd2);
		
		//test function getLuckyItem
		anOrder.getALuckyItem();
		anOrder.printList();
		
		//test function search
		System.out.println(dvd1.search("King"));
		System.out.println(dvd1.search("King1"));
	}
}
