package hust.soict.globalict.test.media;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import java.util.Iterator;

public class TestMediaCompareTo {
	public static void main(String args[]) {
		java.util.Collection<DigitalVideoDisc> collection = new java.util.ArrayList<DigitalVideoDisc>();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc ("Funny","Fiction","Hieu",90, 90);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Doctor Strange","Adventure","Tuan",80, 190);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc ("Mulan","History","Raser",10, 20);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc ("Deadpool","Fiction","Minh",90,190);
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		collection.add(dvd4);
		Iterator<DigitalVideoDisc> iterator = collection.iterator();
		System.out.println("--------------------------------");
		System.out.println ("The DVDs currently in the order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		java.util.Collections.sort((java.util.List<DigitalVideoDisc>)collection);
		iterator = collection.iterator();
		System.out.println("-----------------------------------");
		System.out.println ("The DVDs in sorted order are: ");
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).toString());
		}
		System.out.println("-----------------------------------");
	}
}
