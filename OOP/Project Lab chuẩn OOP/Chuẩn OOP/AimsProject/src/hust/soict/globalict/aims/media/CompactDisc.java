package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title, String category, String director, long length, float cost, String artist) {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	public CompactDisc() {
		super();
	}
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category) {
		super(title, category);
	}
	public CompactDisc(String title, String category, String director) {
		super(title, category, director);
	}
	public CompactDisc(String title, String category, String director, String artist) {
		super(title, category, director);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	public String toString() {
		return "cd - " + super.toString() + " - " + getLength();
	}
	public void addTrack(Track inputTrack) {
		if(!tracks.contains(inputTrack)){
			tracks.add(inputTrack);
			System.out.println("This track is added successfully to Compact Disc");
		}else {
			System.out.println("This track has already existed in the Compact Disc");
		}
	}
	public void removeTrack(Track inputTrack) {
		if(tracks.contains(inputTrack)){
			tracks.remove(inputTrack);
			System.out.println("This track is removed successfully from Compact Disc");
		}else {
			System.out.println("This track is not existed in the Compact Disc");
		}
	}
	public long getLength() {
		int CDLength = 0;
		for(int i = 0; i < tracks.size(); i++) {
			CDLength += tracks.get(i).getLength();
		}
		return CDLength;
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
		System.out.println("Artist: " + artist);
		System.out.println(this);
		for(int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
		}
	}
	public int getTrackNumbers(){
		return tracks.size(); 
	}
	public int compareTo(Object o) {
		if(Integer.compare(this.getTrackNumbers(),((CompactDisc) o).getTrackNumbers() )!=0)
			return Integer.compare(this.getTrackNumbers(),((CompactDisc) o).getTrackNumbers() );
		else
			return Long.compare(this.getLength(),((CompactDisc) o).getLength() );
		
	}
}
