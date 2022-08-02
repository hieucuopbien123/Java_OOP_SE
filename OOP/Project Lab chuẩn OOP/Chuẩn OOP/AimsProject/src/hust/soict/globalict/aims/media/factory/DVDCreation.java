package hust.soict.globalict.aims.media.factory;

import java.util.Scanner;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class DVDCreation implements MediaCreation {
	@Override
	public Media createMediaFromConsole() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Media Title: ");
		String title = sc.nextLine();
		System.out.println("Media Category: ");
		String category = sc.nextLine();
		System.out.println("Media Price: ");
		float cost = Float.parseFloat(sc.nextLine());
		System.out.println("DVD Director: ");
		String director = sc.nextLine();
		System.out.println("DVD Length: ");
		long length = Long.parseLong(sc.nextLine());
		DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
		System.out.println("Do you want to play the DVD(Yes type number 1, No type number 0): ");
		int op = sc.nextInt();
		if(op == 1) {
			newDVD.play();
		}
		return newDVD;
	}
	
}
