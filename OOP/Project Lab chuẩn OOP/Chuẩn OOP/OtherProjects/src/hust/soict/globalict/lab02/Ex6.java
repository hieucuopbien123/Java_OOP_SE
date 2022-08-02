package hust.soict.globalict.lab02;

import java.util.Scanner;

public class Ex6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int average = 0;
		int arrInt[] = {1789, 1, 2035, 1899, 1456, 2013};
		for(int i = 1; i < arrInt.length; i++) {
			int temp = arrInt[i];
			for(int j = i - 1; j >= 0; j--) {
				if(arrInt[j] >= temp) {
					arrInt[j + 1] = arrInt[j];
					if(j == 0) {
						arrInt[0] = temp; 
					}
				}else {
					arrInt[j + 1] = temp;
					break;
				}
			}
		}
		for(int i = 0; i < arrInt.length; i++) {
			sum += arrInt[i];
			System.out.print(arrInt[i] + "\t");
		}
		System.out.println("\nSum: " + sum + "\n" + "Average: " +
		Double.valueOf(sum)/arrInt.length);
		
	}
}
