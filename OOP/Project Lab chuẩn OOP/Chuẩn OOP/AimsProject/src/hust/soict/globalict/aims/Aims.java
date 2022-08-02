package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.factory.BookCreation;
import hust.soict.globalict.aims.media.factory.CDCreation;
import hust.soict.globalict.aims.media.factory.DVDCreation;
import hust.soict.globalict.aims.media.factory.MediaCreation;
import hust.soict.globalict.aims.order.Order;

public class Aims {
	public static Media createMedia(MediaCreation mc) {
		return mc.createMediaFromConsole();
	}
	public static void showAdminMenu() {
		System.out.println("Product Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new item");
		System.out.println("2. Delete item by id");
		System.out.println("3. Display the items list");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void showOptions() {
		System.out.println("Choose type of item: ");
		System.out.println("--------------------------------");
		System.out.println("1. Compact disc");
		System.out.println("2. Digital Video Disc");
		System.out.println("3. Book");
		System.out.println("0. Stop");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void showUserMenu() {
		System.out.println("Welcome to AIMS Store: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Search for an item from the list by title");
		System.out.println("3. Add item to order by id (id in the list of available items of the store");
		System.out.println("4. Remove item from order by id (id in the order)");
		System.out.println("5. Display the order information");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("---Admin App---");
		int n = -1;
		List<Media> itemList = new ArrayList<Media>();
		List<String> kind = new ArrayList<String>();
		while(n != 0) {
			showAdminMenu();
			n = scanner.nextInt();
			switch(n) {
				case 1: {
					int n2 = -1;
					while(n2 != 0) {
						showOptions();
						n2 = scanner.nextInt();
						switch(n2) {
							case 1: {
								CompactDisc cd = (CompactDisc)createMedia(new CDCreation());
								itemList.add(cd);
								kind.add("CD");
								break;
							}
							case 2: {
								Media dvd = (DigitalVideoDisc)createMedia(new DVDCreation());
								itemList.add(dvd);
								kind.add("DVD");
								break;
							}
							case 3: {
								Media book = (Book)createMedia(new BookCreation());
								itemList.add(book);
								kind.add("Book");
								break;
							}
						}
					}
					break;
				}
				case 2: {
					System.out.println("Input ID: ");
					int id = scanner.nextInt();
					for(int i = 0; i < itemList.size(); i++) {
						if(itemList.get(i).getId() == id) {
							itemList.remove(itemList.get(i));
							kind.remove(i);
						}
					}
					break;
				}
				case 3: {
					for(int i = 0; i < itemList.size(); i++) {
						System.out.print((i + 1) + ". ");
						System.out.println(itemList.get(i));
					}
					break;
				}
				default: {
					n = 0;
					break;
				}
			}
		}
		
		System.out.println("---User App---");
		n = -1;
		List<Order> listOrder = new ArrayList<Order>();
		int index = -1;
		while(n != 0) {
			showUserMenu();
			n = scanner.nextInt();
			switch(n) {
				case 1: {
					Order anUserOrder = Order.createOrder();
					listOrder.add(anUserOrder);
					index++;
					if(anUserOrder != null) {
						System.out.println("New order is created");
					}
					break;
				}
				case 2: {
					scanner.nextLine();
					System.out.println("Input title to search: ");
					String title = scanner.nextLine();
					for(int i = 0; i < itemList.size(); i++) {
						String currentTitle = itemList.get(i).getTitle();
						System.out.println(title);
						System.out.println(currentTitle);
						if(Objects.equals(currentTitle, title)) {
							System.out.println(itemList.get(i).getId() + " - " + kind.get(i) 
							+ " - " + itemList.get(i).getTitle() + " - " + itemList.get(i).getCategory()
							+ " - " + itemList.get(i).getCost());
						}
					}
					break;
				}
				case 3: {
					Order temp = listOrder.get(index);
					System.out.println("Input ID: ");
					int idSearch = scanner.nextInt();
					for(int i = 0; i < itemList.size(); i++) {
						int id = itemList.get(i).getId();
						if(id == idSearch) {
							temp.addMedia(itemList.get(i));
						}
					}
					break;
				}
				case 4: {
					Order temp = listOrder.get(index);
					System.out.println("Input ID: ");
					int idSearch = scanner.nextInt();
					temp.removeById(idSearch);
					break;
				}
				case 5: {
					for(int i = 0; i < listOrder.size(); i++) {
						System.out.println("Order " + (i + 1) + ": ");
						listOrder.get(i).printList();
					}
					break;
				}
			}
		}
		
		scanner.close();
	}
}
