import java.util.Scanner;
import java.text.DecimalFormat;

public class DataType {
    // Basic - IMPORTANT - Casting

    public static final int HOUR_OF_DAY = 24;
    public static void main(String[] args) {
        System.out.println(HOUR_OF_DAY);

        byte byteNumber = 100;//8bits
        short shortNumber16bytes = 1;//16bits
        float floatNumber = 10f;
        boolean boolValue = true;
        char charValue = 'a';//16bits
        // Wrapperclass như: Character, Integer,..
        
        //ép kiểu rộng: byte → short → int → long → float → double
        int i = 100;    
        float f = i; // chuyển từ kiểu dữ liệu int lên kiểu float
        System.out.println("Gia tri bien i = " + i);
        System.out.println("Gia tri bien f = " + f);
        //ép kiểu tường minh: từ lớn về nhỏ có thể mất mát dữ liệu
        double d = 100.04;  
        int i1 = (int) d;
        System.out.println("Giá tri bien i = " + i1);

        //casting: str->char[]
        String str = "Hello world";
        char[] charStr = str.toCharArray();
        System.out.println(charStr);

        Scanner scanner = new Scanner(System.in);
        i1 = scanner.nextInt();
        d = scanner.nextFloat();
        System.out.println("Giá tri bien i = " + i1);
        System.out.println("Gia tri bien d = " + d);

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        System.out.println("Gia tri bien d = " + decimalFormat.format(d));
        //ít hơn số lượng # ở phần thập phân thì sẽ in bình thường format k ảnh hưởng
    }
}
