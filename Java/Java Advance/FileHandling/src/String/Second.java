package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        // Collection Framework trong java
        
        HashMap<Integer, String> languages = new HashMap<>();
        languages.put(1, "java");
        languages.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(languages);

        // Basic
        System.out.println(Math.acos(0.5));//asin, cos, sin, tan, sqrt, cbrt(căn bậc 3)

        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        System.out.println(Math.addExact(a, 100));//subtractExact, multiplyExact
        System.out.println(Math.pow(2,2));
        System.out.println(Math.min(2,3));//max
        System.out.println(Math.floor(2.9));//ceil, round
        System.out.println(Math.random());
        System.out.println(Math.toRadians(45));//tương tự toDegrees nhận góc radian vào
        System.out.println(Math.log(10));//là ln(10);
        System.out.println(Math.log10(10));
        System.out.println(Math.hypot(3,4));//trả ra cạnh huyền của tam giác vuông 2 cạnh 3, 4
        System.out.println(Math.copySign(10, -1));//lấy sign của arg2 ghép với value của arg1

        Object obj = new Object();
        System.out.println(obj.getClass());//xem mọi biến thuộc class nào
        System.out.println(obj.toString());//tra ra: <tên class>@<hashCode của object>
        System.out.println(obj.hashCode());//ra decimal
        
        //Thao tác với string
        System.out.println(String.format("0x%08X", obj.hashCode()));//hiển thị số nào dạng hex

        String[] array = {"Python", "Java", "C"};
        String[] array1 = {"Python", "Java", "C"};
        System.out.println("Use for the whole array: " + array.toString());
        System.out.println("Use for one element: " + array[0].toString()); 

        System.out.println(array.equals(array1));//ss giá trị

        String s1 = new String("hello");//heap có 1 "hello"
        String s2 = "hello";//String Pool có 1 "hello"
        String s3 = s1.intern();//tìm trong pool có thì trả về,nếu k thì thêm nó vào pool và trả về tham chiếu 
        // trong pool. Tức lúc này s3 chính bằng s2 r còn gì
        
        System.out.println(s1 == s2);//false vì reference là khác nhau
        System.out.println(s2 == s3);//true vì reference là giống nhau

        String strTest = "helo";
        System.out.println(strTest.matches(".elo"));
    }
}
