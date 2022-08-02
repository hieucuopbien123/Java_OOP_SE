package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Arrays;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	public Book() {
		super();
	}
	public void setContent(String content) {
		this.content = content;
		processContent();
	}
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category) {
		super(title, category);
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public static Book createBook() {
		return new Book();
	}
	public void processContent() {
		String[] temp = this.content.split(" ");
		Arrays.sort(temp);
		contentTokens.addAll(Arrays.asList(temp));
		for(int i=0;i<contentTokens.size();i++){
			if(wordFrequency.get(contentTokens.get(i)) == null)
				wordFrequency.put(contentTokens.get(i), 1);
			else 
				wordFrequency.put(contentTokens.get(i), wordFrequency.get(contentTokens.get(i)) + 1);
		}
	}
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
		}
	}
	public String toString() {
		String fixString = "Book - " + super.toString() + " - Authors: " + authors.toString() + " - Content Length: "
				+ String.valueOf(content.length()) + ".\n";
		String tokenList = String.join(",", contentTokens);
		String wFre = "\nWord Fre: \n";
		for (Entry<String, Integer> entry : wordFrequency.entrySet()) {
			String key = entry.getKey();
		    int value = entry.getValue();
		    wFre += key + " - " + String.valueOf(value)+ "\n";
		}
		return fixString + tokenList + wFre;
	}
//	public void inputInfo() {
//		Scanner scanner = new Scanner(System.in);
//		super.inputInfo(scanner);
//		System.out.println("Input number of authors: ");
//		int n5 = scanner.nextInt();
//		scanner.nextLine();
//		for(int i = 0; i < n5; i++) {
//			System.out.println("Input author " + (i + 1) + ": ");
//			String authorName = scanner.nextLine();
//			addAuthor(authorName);
//		};
//	}

}
