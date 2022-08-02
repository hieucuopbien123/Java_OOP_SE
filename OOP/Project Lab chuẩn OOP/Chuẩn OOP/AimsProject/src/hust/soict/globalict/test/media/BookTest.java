package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book newBook = new Book("Winter","Novel",90);
		newBook.addAuthor("Hieu");
		newBook.addAuthor("Trang");
		newBook.setContent("In publishing and graphic design, Lorem ipsum is a placeholder text commonly "
				+ "used to demonstrate the visual form of a document or a typeface without relying on meaningful content. "
				+ "Lorem ipsum may be used as a placeholder before final copy is available.");
		newBook.processContent();
		System.out.println(newBook.toString());
	}
	

}
