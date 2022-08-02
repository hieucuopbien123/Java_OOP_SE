package hust.soict.globalict.aims.utils;
import hust.soict.globalict.test.utils.MyDate;

public class DateUtil {
	public static int compareTwoDate(MyDate date1, MyDate date2) {
		if(date1.getYear() > date2.getYear()) 
			return 1;
		else if(date1.getYear() < date2.getYear()) 
			return -1;
		else if(date1.getMonth() > date2.getMonth()) 
			return 1;
		else if(date1.getMonth() < date2.getMonth())
			return -1;
		else if(date1.getDay() > date2.getDay())
			return 1;
		else if(date1.getDay() < date2.getDay())
			return -1;
		else 
			return 0;
	}
	public static MyDate[] sortDates(MyDate...dates) {
		for(int i = 0; i < dates.length; i++) {
			for(int j = i + 1; j < dates.length; j++) {
				if(compareTwoDate(dates[i], dates[j]) > 0) {
					MyDate temp = dates[j];
					dates[j] = dates[i];
					dates[i] = temp;
				}
			}
		}
		return dates;
	}
}
