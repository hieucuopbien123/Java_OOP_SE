package hust.soict.globalict.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}
	public DigitalVideoDisc(String title, String category, String director) {
		super(title, category, director);
	}
	public DigitalVideoDisc(String title, String category, String director, long length, float cost) {
		super(title, category, director, length, cost);
	}

	public boolean search(String title) {
		String titleList[] = title.split(" ");
		for(int i = 0; i < titleList.length; i++) {
			if(!this.getTitle().contains(title)) {
				return false;
			}
		}
		return true;
	}
	public String toString() {
		return "dvd - " + super.toString() + " - " + getLength();
	}
//	public void inputInfo() {
//		Scanner scanner = new Scanner(System.in);
//		super.inputInfo(scanner);
//		System.out.println("Input length: ");
//		length = scanner.nextInt();
//		System.out.println("Input director: ");
//		scanner.nextLine();
//		director = scanner.nextLine();
//	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public int compareTo(Object o){
		return Float.compare(this.getCost(), ((DigitalVideoDisc) o).getCost());
	}
}
