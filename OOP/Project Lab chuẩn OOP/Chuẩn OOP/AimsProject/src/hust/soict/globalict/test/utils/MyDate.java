package hust.soict.globalict.test.utils;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MyDate {
	private int day, month, year;
	
	public MyDate(int day, int month, int year) {
		super();
		if(day < 0 || day > 31 || month < 0 || month > 12) {
			System.out.println("Error\n");
			day = month = year = 0;
		}
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate() {
		super();
		Calendar cal = Calendar.getInstance();
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		this.month = cal.get(Calendar.MONTH) + 1;
		this.year = cal.get(Calendar.YEAR) + 1;
	}
	
	public MyDate(String date) {
		super();
		String[] eles = date.split(" ");
		String month = eles[0].substring(0, 3);
		String day = eles[1].substring(0, eles[1].length() - 2);
		String year = eles[2];
		switch(month) {
			case "Jan": month = "1"; break;
			case "Feb": month = "2"; break;
			case "Mar": month = "3"; break;
			case "Apr": month = "4"; break;
			case "May": month = "5"; break;
			case "Jun": month = "6"; break;
			case "Jul": month = "7"; break;
			case "Aug": month = "8"; break;
			case "Sep": month = "9"; break;
			case "Oct": month = "10"; break;
			case "Nov": month = "11"; break;
			case "Dec": month = "12"; break;
		}
		this.day = Integer.parseInt(day);
		this.month = Integer.parseInt(month);
		this.year = Integer.parseInt(year);
		if(this.day < 0 || this.day > 31 || this.month < 0 || this.month > 12) {
			System.out.println("Error\n");
			this.day = this.month = this.year = 0;
		}
	}
	
	public MyDate(String day, String month, String year) {
		super();
		this.day = Integer.parseInt(day);
		this.month = Integer.parseInt(month);
		this.year = Integer.parseInt(year);
		if(this.day < 0 || this.day > 31 || this.month < 0 || this.month > 12) {
			System.out.println("Error\n");
			this.day = this.month = this.year = 0;
		}
	}
	
	public void print() {
		String suffix;
		switch(this.day%10) {
			case 1:
				suffix = "st";
				break;
			case 2: 
				suffix = "nd";
				break;
			case 3: 
				suffix = "rd";
				break;
			default:
				suffix = "th";
				break;
		}

		String monthStr;
	    switch(this.month){
	        case 1: 
	        	monthStr = "January";
	            break;
	        case 2: 
	        	monthStr = "February";
	            break;
	        case 3: 
	        	monthStr = "March";
	            break;
	        case 4: 
	        	monthStr = "April";
	            break;
	        case 5: 
	        	monthStr = "May";
	            break;
	        case 6: 
	        	monthStr = "June"; 
	            break;
	        case 7: 
	        	monthStr = "July";
	            break;
	        case 8: 
	        	monthStr = "August";
	            break;
	        case 9: 
	        	monthStr = "September";
	            break;
	        case 10: 
	        	monthStr = "October";
	            break;
	        case 11: 
	        	monthStr = "November";
	            break;
	        case 12: 
	        	monthStr = "December";
	            break;
	        default: 
	        	monthStr = "";
	        	break;
	    }
	    System.out.println(monthStr + " " + day + suffix + " " + year);
	}
	
	public void print(String format) {
		String monthStr;
	    switch(this.month){
	        case 1: 
	        	monthStr = "Jan";
	            break;
	        case 2: 
	        	monthStr = "Feb";
	            break;
	        case 3: 
	        	monthStr = "Mar";
	            break;
	        case 4: 
	        	monthStr = "Apr";
	            break;
	        case 5: 
	        	monthStr = "May";
	            break;
	        case 6: 
	        	monthStr = "Jun"; 
	            break;
	        case 7: 
	        	monthStr = "Jul";
	            break;
	        case 8: 
	        	monthStr = "Aug";
	            break;
	        case 9: 
	        	monthStr = "Sep";
	            break;
	        case 10: 
	        	monthStr = "Oct";
	            break;
	        case 11: 
	        	monthStr = "Nov";
	            break;
	        case 12: 
	        	monthStr = "Dec";
	            break;
	        default: 
	        	monthStr = "";
	        	break;
	    }
	    format = format.replaceAll("yyyy", String.valueOf(this.year));
		format = format.replaceAll("dd", this.day < 10 ? "0" + String.valueOf(this.day) : String.valueOf(this.day));
		format = format.replaceAll("d", String.valueOf(this.day));
		format = format.replaceAll("MMM", monthStr);
		format = format.replaceAll("MM", this.month < 10 ? "0" + String.valueOf(this.month) : String.valueOf(this.month));
		format = format.replaceAll("mm", this.month < 10 ? "0" + String.valueOf(this.month) : String.valueOf(this.month));
		int indexM;
		if((indexM = format.indexOf('M')) != -1 && format.charAt(indexM) != 'a') {//avoid Mar and May
			format = format.replaceAll("M", String.valueOf(this.month));
		}
		System.out.println(format);
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		if(day < 0 || day > 31) {
			return;
		}
		this.day = day;
	}

	public void setMonth(int month) {
		if(month < 0 || month > 12)
			return;
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public void setMyDate(String date) {
		String[] eles = date.split(" ");
		String month = eles[0].substring(0, 3);
		String day = eles[1].substring(0, eles[1].length() - 2);
		String year = eles[2];
		switch(month) {
			case "Jan": month = "1"; break;
			case "Feb": month = "2"; break;
			case "Mar": month = "3"; break;
			case "Apr": month = "4"; break;
			case "May": month = "5"; break;
			case "Jun": month = "6"; break;
			case "Jul": month = "7"; break;
			case "Aug": month = "8"; break;
			case "Sep": month = "9"; break;
			case "Oct": month = "10"; break;
			case "Nov": month = "11"; break;
			case "Dec": month = "12"; break;
		}
		this.day = Integer.parseInt(day);
		this.month = Integer.parseInt(month);
		this.year = Integer.parseInt(year);
	}
}
