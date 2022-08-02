package hust.soict.globalict.aims.media;

import java.util.Scanner;

public abstract class Media implements Comparable<Object>{
	private String title;
	private String category;
	private float cost;
	private int id;
	private static int increaseID = 0;
	public Media() {
		super();
		id = ++increaseID;
	}
	public Media(String title) {
		super();
		id = ++increaseID;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public Media(String title, String category) {
		super();
		id = ++increaseID;
		this.title = title;
		this.category = category;
	}
	public Media(String title, String category, float cost) {
		super();
		id = ++increaseID;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public String toString() {
		return title + " - " + category + " - " + cost + "$" + " - " + "[id = " + id + "]";
	}
	public boolean equals(Object o) {
		return this.id == ((Media) o).getId();
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.title.compareTo(((Media)o).getTitle());
	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public void setCost(float cost) {
//		this.cost = cost;
//	}
//	public void inputInfo(Scanner scanner) {
//		System.out.println("Input title: ");
//		title = scanner.nextLine();
//		System.out.println("Input category: ");
//		category = scanner.nextLine();
//		System.out.println("Input cost: ");
//		cost = scanner.nextFloat();
//	}
}
