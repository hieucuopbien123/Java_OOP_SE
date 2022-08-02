package hust.soict.globalict.aims.media.factory;

import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;

public class BookCreation implements MediaCreation {
	@Override
	public Media createMediaFromConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Media Title: ");
		String title = sc.nextLine();
		System.out.println("Media Category: ");
		String category = sc.nextLine();
		System.out.println("Media Price: ");
		float cost = Float.parseFloat(sc.nextLine());
		Book newBook = new Book(title, category, cost);
		System.out.println("Input number of authors: ");
		int n5 = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n5; i++) {
			System.out.println("Input author name " + (i + 1) + ": ");
			String authorName = sc.nextLine();
			newBook.addAuthor(authorName);
		};
		return newBook;
	}
}
