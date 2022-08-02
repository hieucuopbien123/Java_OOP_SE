package hust.soict.globalict.aims.media.factory;

import java.util.Scanner;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class CDCreation implements MediaCreation {
	@Override
	public Media createMediaFromConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Media Title: ");
		String title = sc.nextLine();
		System.out.println("Media Category: ");
		String category = sc.nextLine();
		System.out.println("Media Price: ");
		float cost = Float.parseFloat(sc.nextLine());
		System.out.println("CD Director: ");
		String director = sc.nextLine();
		System.out.println("CD Length: ");
		long length = Long.parseLong(sc.nextLine());
		System.out.println("CD artist: ");
		String artist = sc.nextLine();
		CompactDisc newCompactDisc = new CompactDisc(title, category, director, length, cost, artist);
		System.out.println("Input number of tracks in CD: ");
		int numberOfDisc = sc.nextInt();
		for(int i = 0; i < numberOfDisc; i++) {
			TrackCreation trackCreation = new TrackCreation();
			Track track = trackCreation.createNewTrack(i + 1);
			newCompactDisc.addTrack(track);
		}
		System.out.println("Do you want to play the CD(Yes type number 1, No type number 0): ");
		int op = sc.nextInt();
		if(op == 1) {
			newCompactDisc.play();
		}
		return newCompactDisc;
	}
}
