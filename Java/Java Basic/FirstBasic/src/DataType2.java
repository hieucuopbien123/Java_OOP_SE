import java.util.Scanner;

public class DataType2 {
    // Basic - IMPORTANT - Input scanner
    
    public static void main(String[] args){
        int number = 0;
        for(;number < 5; ++number, number++){//có thể for(;;){<code>} miễn là có đủ đk dừng
            System.out.println(number);
        }

        String str = new String("  Hello");
        System.out.println(str.length());
        str = str.concat(" World");//có thể dùng +
        System.out.println(str);
        System.out.println(str.charAt(10));
        System.out.println(str.compareTo("Hello World"));
        System.out.println(str.equals("Hello World"));

        //k tồn tại trả ra -1
        System.out.println(str.indexOf("o"));
        System.out.println(str.lastIndexOf("o"));
        System.out.println(str.replace('H', 'J'));//k đổi chuỗi cũ
        System.out.println(str.replace("World", "Hieu"));
        System.out.println(str.trim());
        System.out.println(str.substring(5));
        System.out.println(str.substring(5, 11));

        Scanner scanner = new Scanner(System.in);

        char hNext = scanner.next().charAt(0);//next k cũng là nhập vào string nhưng tính chất hơi khác
        scanner.nextLine();
        String hNextLine = scanner.nextLine();
        System.out.println(hNext);
        System.out.println(hNextLine);
        scanner.close();
        //pb: nextLine nhận vào 1 dòng và chỉ kết thúc khi ấn enter. Nó luôn lấy dòng đầu tiên trước cái
        //enter đầu tiên bất chấp dòng đầu trống
        //next buộc đầu vào phải có chữ, nếu ấn enter liên tục thì nó éo care mà phải có chữ xong ấn enter 
        //mới được. Tức là nếu bộ đệm có sẵn enter k ảnh hưởng tới nó. Nhưng cái enter cuối cùng nó k lấy 
        //mà sẽ lưu vào đệm cho cái tiếp theo. Nch là nó bỏ enter ở đệm và lưu lại 1 cái enter cuối ở đệm

        System.out.println(Character.isUpperCase(str.charAt(0)));
        System.out.println(Character.isLowerCase(str.charAt(0)));
        System.out.println(Character.isDigit(str.charAt(0)));

        // primitive mà dùng new chỉ có thể là tạo mảng thôi chú k thì vô dụng
        char[] kyTus = new char[] {'a', 'b', 'c', 'd', 'e'};
        char[] kyTus1 = new char[6];
        int[] array1 = {2, 10, 3, 9, 8};
        System.out.println(kyTus[0]);
        char kyTus2[] = new char[6];

        int[][] b2Chieu = new int[4][5];
        int a2Chieu[][] = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        int c2Chieu[][] = {{1, 2}, {3, 4}, {5, 6}};
        System.out.print(a2Chieu[2][1] + "\n" + "End of Line");
        //print dùng in String, println dùng in số nguyên nhưng thật ra dùng thế éo nào cx đc
        //khi dùng + thì 1 cái là string sẽ convert hiểu là cộng string
    }
}
