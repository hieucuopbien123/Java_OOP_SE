package hust.soict.globalict.aims.utils;
import java.util.Arrays;

import hust.soict.globalict.test.utils.MyDate;

public class DateTest {
	public static void main(String[] args) {
		MyDate d1 = new MyDate(18, 1, 2001);
		MyDate d2 = new MyDate("February 18th 2019");
		MyDate d3 = new MyDate();
		
		d1.print();
		d2.print();
		d3.print();
		
		d1.setDay(9);
		d1.setMonth(2);
		d1.setYear(2000);
		d1.print();
		
		MyDate testPrintMyDate = new MyDate(2,4,1990);
		testPrintMyDate.print();
		testPrintMyDate.print("d/M/yyyy");
		
		System.out.println("Compare 18/2/2019 and 2/4/1990: " + DateUtil.compareTwoDate(d1, testPrintMyDate));
		MyDate[] sortedDates = DateUtil.sortDates(d1, d2, d3, testPrintMyDate);
		System.out.println("After sorting: ");
		for(int i = 0; i < sortedDates.length; i++) {
			sortedDates[i].print();
		}
	}
}
