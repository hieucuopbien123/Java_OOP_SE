package String;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class First {
    public static void main(String[] args) {
        // Thao tác với string
        
        String str1 = "a::b::c::d:e";
        String result[] = str1.split("::");
        //1 là regexp tách ra, 2 là số lượng max con muốn tách, nếu k truyền 2 sẽ tách toàn bộ con
        System.out.println("Res: " + Arrays.toString(result));//Casting [] thành string

        System.out.println(str1.contains("a::b"));
        System.out.println("Hello".toLowerCase());
        System.out.println("Hello".startsWith("He"));//endsWith

        // Collection Framework trong java
        ArrayList<Integer> intArrList = new ArrayList<Integer>();
        intArrList.add(2);
        intArrList.add(1);
        ArrayList<Integer> cloneIntList = (ArrayList<Integer>) intArrList.clone();
        //clone trả ra 1 biến Object nên phải chủ động cast lớn thành nhỏ 
        System.out.println(cloneIntList.get(0));
        cloneIntList.add(4);
        cloneIntList.removeAll(intArrList);

        System.out.println(cloneIntList.subList(0, 1));

        intArrList.sort(Comparator.naturalOrder());
        System.out.println(intArrList);

        Integer[] intArray = new Integer[100];
        intArrList.toArray(intArray);//khi truyền tham số vào sẽ lưu vào tham số đó ở dạng đúng
        //Còn nếu dùng intArrList.toArray(); sẽ ra mảng các Object
        System.out.println(intArray[0]);

        System.out.println(intArrList.toString());
        
        System.out.println(intArrList.retainAll(cloneIntList));//lấy giao 2 tập, trả true nếu mảng có bị thay đổi
        //bởi hàm này
        System.out.println(cloneIntList.containsAll(intArrList));
    }
}
