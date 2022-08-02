package hust.soict.globalict.lab02;

import java.util.Scanner;

public class Ex5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int isExit = 0;
		int monthInt = 0;
		while(isExit == 0) {
			isExit = 1;
			System.out.print("Input month: ");
			String month = scanner.nextLine();
			System.out.print("Input year: ");
			int year = scanner.nextInt();
			switch(month) {
				case "January":case "Jan":case "1":case "Jan.":
				case "March":case "Mar.":case "Mar":case "3":
				case "May":case "5":
				case "July":case "Jul":case "7":
				case "August":case "Aug":case "Aug.":case "8":
				case "October":case "Oct":case "Oct.":case "10":
				case "December":case "Dec":case "Dec.":case "12":
					monthInt = 31;
					break;
				case "February":case "Feb":case "Feb.":case "2":
					if(year % 4 == 0 && (year % 100 !=0 || year % 400 == 0)) {
						monthInt = 29;
					}else
						monthInt = 28;
					break;
				case "April":case "Apr.":case "Apr":case "4":
				case "June":case "Jun":case "6":
				case "September":case "Sept":case "Sep":case "9":
				case "November":case "Nov":case "Nov.":case "11":
					monthInt = 30;
					break;
				default: 
					isExit = 0;
					break;
			}
		}
		scanner.close();
		System.out.println("Result: " + monthInt);
	}
}
