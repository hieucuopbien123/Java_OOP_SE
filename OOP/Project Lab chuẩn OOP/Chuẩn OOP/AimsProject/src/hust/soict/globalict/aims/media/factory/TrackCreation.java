package hust.soict.globalict.aims.media.factory;

import java.util.Scanner;

import hust.soict.globalict.aims.media.Track;

public class TrackCreation {
	public Track createNewTrack(int i) {
		System.out.println("Input data of track " + i + ": ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Title of track: ");
		String title = sc.nextLine();
		System.out.println("Length of track: ");
		long length = Long.parseLong(sc.nextLine());
		return new Track(title, length);
	}
}
