package hust.soict.globalict.aims.media;

public class Track implements Playable{
	private String title;
	private long length;
	public Track() { }
	public Track(String title, long length){
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public long getLength() {
		return length;
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public boolean equals(Object o) {
		return this.title == ((Track) o).getTitle() && this.length == ((Track) o).getLength();
	}
}
