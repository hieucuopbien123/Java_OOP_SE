package hust.soict.globalict.lab02;

import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		for(int i = 1; i <= n; i++) {
			int temp = i;
			while(n - temp != 0) {
				System.out.print(" ");
				temp++;
			}
			for(int j = 0; j < (i-1)*2+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}