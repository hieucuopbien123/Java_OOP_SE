import java.util.Random;
import java.util.StringTokenizer;

// Basic - MathLib
// Thao tác với string

public class MathLib {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println("|-11.03| = " + Math.abs(-11.03f));
        System.out.println(Math.max(1, 2));//min
        System.out.println(Math.sqrt(2.6));
        System.out.println(Math.pow(2,6));
        System.out.println(Math.sin(Math.PI * 90 / 180));//sin 90 độ vì nó nhận vào radian
        System.out.println(Math.cos(Math.PI * 90 / 180));
        System.out.println(Math.tan(Math.PI * 60 / 180));//tan góc 90 sẽ ra số cực lớn vì vô cực. Có thể dùng sin/cos

        //dùng class random này tốt hơn là dùng Math.random chỉ cho từ 0-1 mà phải cast sang int nên mỗi lần lấy từ
        //0 đến 5 thì phải: (int)(Math.random()*5
        Random rd = new Random();
        int number = rd.nextInt();  // trả về 1 số nguyên bất kỳ cả âm dương
        int number1 = rd.nextInt(90);//trả về số nguyên bất kỳ từ 0 đến 89    
        int number2 = rd.nextInt(90) - 45;//trả về số nguyên bất kỳ từ -45 -> 44 
        System.out.println(number + " _ " + number1 + " _ " + number2);
        System.out.println(rd.nextFloat());//trong [0.0f, 1.0f]
        System.out.println(rd.nextDouble());//trong [0.0d, 1.0d]
        System.out.println(rd.nextLong());
        System.out.println(rd.nextBoolean());


        StringBuilder stringBuilder = new StringBuilder();//tạo 1 string builder rỗng lưu được 16 ký tự
        StringBuilder stringBuilder1 = new StringBuilder(90);//tạo lưu được 90
        StringBuilder stringBuilder2 = new StringBuilder("Hello");//tạo lưu được 5 + 16 ký tự
		
        //nối chuỗi thay thế cho dấu + => nên dùng khi cần nối nhiều đặc biệt là thao tác với file or data từ internet
        for (int i = 0; i < 5; i++) {
            stringBuilder.append("Hello lan " + (i + 1));
            stringBuilder.append("\t");
        }
        System.out.println(stringBuilder);

        boolean bool = false;
        stringBuilder2.insert(3, bool);
        System.out.println("Insert boolean: " + stringBuilder2);

        char ch = 'v';
        stringBuilder2.insert(2, ch);
        System.out.println("Insert char: " + stringBuilder2);
            
        double doubleNumber = 6.1d;
        stringBuilder2.insert(9, doubleNumber);
        System.out.println("Insert double: " + stringBuilder2);
            
        char[] ch1 = {'a', 'e', 'f'};
        stringBuilder2.insert(6, ch1);
        System.out.println("Insert char[]: " + stringBuilder2);
            
        char[] str1 = {'d', 'a', 'b', 'c'};
        stringBuilder2.insert(5, str1, 2, 2);
        System.out.println("Insert char[]: " + stringBuilder2);

	    stringBuilder2.delete(3, 8); //từ start đến end-1
        stringBuilder2.deleteCharAt(7);
        stringBuilder2.reverse();//đảo ngược
        System.out.println("Delete: " + stringBuilder2);

        
        //5 phương thức phổ biến của class StringTokenizer
        StringTokenizer stringTokenizer = new StringTokenizer("Hello World");
	    StringTokenizer stringTokenizer2 = new StringTokenizer("Hello,\nWorld,\nHi", ",");  
	    StringTokenizer stringTokenizer3 = new StringTokenizer("Hello\tWorld\tHi", "\t", false);
        System.out.println(stringTokenizer2.countTokens());
        //returnDelims là true thì các ký tự phân cách cũng thành token, ngược lại thì k
        while(stringTokenizer2.hasMoreTokens()){
            System.out.println(stringTokenizer2.nextToken());//lấy token hiện tại và đi tới token kế tiếp
        }//= với: hasMoreElements, nextElement
    }
}
