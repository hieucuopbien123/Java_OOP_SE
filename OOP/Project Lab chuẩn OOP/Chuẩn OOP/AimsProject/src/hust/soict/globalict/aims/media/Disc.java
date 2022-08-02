package hust.soict.globalict.aims.media;

import java.util.Scanner;

public class Disc extends Media{
	private String director;
	private long length;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public long getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Disc(String title){
		super(title);
	}
	public Disc(){
		super();
	}
	public Disc(String title, String category){
		super(title, category);
	}
	public Disc(String title, String category, String director){
		super(title, category);
		this.director = director;
	}
	public Disc(String title, String category, String director, long length, float cost){
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
//	@Override
//	public void inputInfo(Scanner scanner) {
//		System.out.println("Input title: ");
//		title = scanner.nextLine();
//		System.out.println("Input category: ");
//		category = scanner.nextLine();
//		System.out.println("Input cost: ");
//		cost = scanner.nextFloat();
//	}
}
