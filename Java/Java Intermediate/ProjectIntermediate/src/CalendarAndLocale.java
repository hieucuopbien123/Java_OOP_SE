import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.DecimalFormat;

// Thao tác với Date và Locale

public class CalendarAndLocale {
    public static void main(String[] args){
        //Date
        Calendar cal = Calendar.getInstance();//biến lưu giá trị cũng lấy luôn thời gian hiện tại
        Date date = cal.getTime();//đổi ra Date nếu thích nhưng getDay, getMonth, getYear,.. của Date bị deprecated cả r
        System.out.println(date);
        
        //cách lấy chuẩn
        System.out.println("Ngay hien tai la: " + cal.get(Calendar.DAY_OF_MONTH));//lấy từng phần, trả ra int
        System.out.println(cal.get(Calendar.MONTH) + 1);//tháng trong java hiện từ 0-11 nên phải + 1
        System.out.println(cal.get(Calendar.YEAR) + 1);
        System.out.println(cal.get(Calendar.HOUR));
	    System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        cal.set(Calendar.HOUR_OF_DAY, 10);//đổi tưng phần
        cal.set(2016, Calendar.APRIL, 30, 20, 23, 8);//đổi mọi thứ
        System.out.println(cal.getTime());//lấy thời gian update
        //vì Calendar cũng chỉ là 1 biến lưu mà thay đổi giá trị biến đó thôi, mặc định khai báo thì nó set tg trong máy
        //Date chỉ là 1 kiểu biến lấy để in tất cả ra màn hình 1 lúc mà thôi
        cal.add(Calendar.MONTH, 4);//thêm 4 tháng
        cal.add(Calendar.MINUTE, -3);//giảm 3 phút

    	cal.set(Calendar.MONTH, Calendar.DECEMBER);
        System.out.println("Thoi gian hien tai sau khi thay doi là: " + cal.getTime());
        // tăng tháng sử dụng phương thức roll() => lúc này tháng sẽ là tháng 1 và năm vẫn giữ nguyên
        cal.roll(Calendar.MONTH, 1);
        System.out.println("Thoi gian hien tai sau khi thay doi là: " + cal.getTime());

        
        //SimpleDateFormat chỉ là định nghĩa cách hiển thị
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Dinh dang: " + sdf.format(date));

        //ngày tháng mà có 1 chữ số sẽ k thêm số 0 đằng trước như vd trên
        SimpleDateFormat sdf1 = new SimpleDateFormat("d/M/yyyy");
        System.out.println("Dinh dang: " + sdf1.format(date));

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    System.out.println("Dinh dang: " + sdf2.format(date));

        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");//k có > 12 h đâu mà dùng pm
	    System.out.println("Dinh dang: " + sdf3.format(date));


        //Format
        NumberFormat nf = NumberFormat.getInstance();//lấy locale là của máy tính hiện tại
        Locale locale = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(locale);//lấy locale nước Anh

        Locale currentLocale = Locale.getDefault();
        System.out.println(currentLocale.getDisplayLanguage());//ngôn ngữ
	    System.out.println(currentLocale.getDisplayCountry());//quốc gia
        System.out.println(currentLocale.getLanguage());//mã ngôn ngữ
	    System.out.println(currentLocale.getCountry());//mã quốc gia
        System.out.println(System.getProperty("user.country"));
	    System.out.println(System.getProperty("user.language"));
        //getProperty trả về chuỗi mã gồm nhiều thông tin hệ thống như ta lấy các mã như trên

        Locale localeEN = new Locale("en", "EN");
        NumberFormat formatLocaleEn = NumberFormat.getInstance(localeEN);
        long longNumber = 12345678L;//phương Tây thì các phần ngăn cách là phẩy
        String str1 = formatLocaleEn.format(longNumber);
        System.out.println("So " + longNumber + " sau khi dinh dang = " + str1);

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat formatLocaleVn = NumberFormat.getInstance(localeVN);
        double doubleNumber1 = 1090097879678.17d;//VN ngược vs My
        String str2 = formatLocaleVn.format(doubleNumber1);//format nhận kiểu số lol nào cx đc
        System.out.println("So " + doubleNumber1 + " sau khi dinh dang = " + str2);


        double currency = 101.999f;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String str = currencyFormat.format(currency);
        System.out.println("So " + currency + " sau khi dinh dang = " + str);

        long vnd = 10000000L;
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        str = currencyVN.format(vnd);
        System.out.println("So " + vnd + " sau khi đinh dang = " + str);


        System.out.println("Type currency of " + System.getProperty("user.country") + //gọi vào hệ thống
            " is " + currencyFormat.getCurrency());

        // Locale[] arr = Locale.getAvailableLocales();
        // for (Locale loc : arr) {
        //     System.out.println("Quoc gia: " + loc.getDisplayCountry() + 
        //         ", Ma quoc gia: " + loc.getCountry() +
        //         ", Ngon ngu: " + loc.getDisplayLanguage() +
        //         ", Ma ngon ngu: " + loc.getLanguage());
        // }

        //setCurrency đổi từ đơn vị tiền quốc gia này sang khu vực khác
        //Currency.getInstance(<vùng>) trả ra biến Currency của vùng nào
	    currencyFormat.setCurrency(Currency.getInstance(localeVN));
        String str3 = currencyFormat.format(doubleNumber1);
        System.out.println(str3);

        double percentageDoubleNumber = 0.758d;
        NumberFormat numEN = NumberFormat.getPercentInstance();
        String percentageEN = numEN.format(percentageDoubleNumber);
	    System.out.println("So " + percentageDoubleNumber + " o dang phan tram = " + percentageEN);	

        NumberFormat numf = NumberFormat.getNumberInstance();
        numf.setMaximumFractionDigits(2);//làm tròn đến 2 chữ số thập phân
        numf.setRoundingMode(RoundingMode.UP);//trong java.math.RoundingMode; Tương tự có DOWN
        System.out.println("Che đo làm tròn: " + numf.getRoundingMode());
        System.out.println("523.454 sau khi làm tròn = " + numf.format(523.454));
        
        //getPercentInstance phần trăm, getInstance format số cả int cả thập phân, getCurrencyInstance tiền, 
        //getNumberInstance làm tròn và chuyên format số thập phân

        String pattern = "###,###.##";
        locale = new Locale("en", "EN");
        //DecimalFormat là 1 dạng cụ thể của NumberFormat
        DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(localeVN);
        dcf.applyPattern(pattern);// áp dụng mẫu pattern = "###,###.##"" cho dcf. Chỉ cần phần thập phân
        //giống chứ phần nguyên thì éo, locale nó đè applyPattern
        System.out.println(doubleNumber1 + " - " + dcf.format(doubleNumber1));

        String patternCurrency = "$###";	// khi hiển thị sẽ có ký tự "$" đứng đầu
        DecimalFormat dcfCurrency = new DecimalFormat(patternCurrency);
        String strCurrency = dcfCurrency.format(vnd);
        System.out.println("So " + currency + " sau khi dinh dang tien te = " + strCurrency);
        
        double percent = 0.08987692d;
        // định dạng số với 2 chữ số ở phần thập phân
        // còn phần nguyên không phụ thuộc vào phần nguyên được khai báo trong pattern
        String patternPercent = "###.##%";	// khi hiển thị sẽ có ký tự "%" đứng cuối
        DecimalFormat dcfPercent = new DecimalFormat(patternPercent);
        String strPercent = dcfPercent.format(percent);
        System.out.println("So " + percent + " sau khi dinh dang phan tram = " + strPercent);
    }
}
