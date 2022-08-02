import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SetInterface {
    // Collection Framework trong java
    
    public static void main(String[] args){
        //Thêm phần tử trùng thì nó tự bỏ phần tử trùng
        //Dùng HashSet default nó khai báo là 16 phần tử nên muốn dùng nhiều hơn nên khai báo rõ số lượng phần
        //tử ra. Dù sao nó cũng tự tăng lên khi dùng 1 lượng phần tử đến ngưỡng
        Set<Integer> hashsetInteger = new HashSet<>();//bỏ kiểu type ở class tự hiểu lấy type ở Interface
        hashsetInteger.add(15);
        hashsetInteger.add(1);
        Set<Integer> treesetInteger = new TreeSet<>();

        System.out.println(hashsetInteger);
        System.out.println(treesetInteger);//in mẹ 1 interface được

        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(2);
        Set<Integer> setInteger = new TreeSet<>(listInteger);
        listInteger.add(3);
        System.out.println(setInteger);

        //lọc thì stream trả ra kiểu Stream<Integer> có các util như filter giúp lọc trả ra 1 stream khác
        //xong gọi collect của stream sẽ trả ra cái gì theo đối số truyền vào từ Stream ở đây là Set từ Stream
        setInteger = listInteger.stream().filter(number -> number % 2 == 1).collect(Collectors.toSet());
        System.out.println(setInteger);

        //Có thẻ duyệt bằng foreach hay iterator như list ez, contains, remove(<giá trị ele>);
        setInteger.clear();
        System.out.println(setInteger.isEmpty());
        System.out.println(setInteger.size());
        System.out.println(setInteger.containsAll(hashsetInteger));

        //Casting từ mảng bth thành collection: List và Set
        Integer[] arraySet1 = {2,10,4,8,5};
        List<Integer> list1 = Arrays.asList(arraySet1);
        Set<Integer> setInteger1 = new HashSet<>(list1);

        setInteger1.addAll(hashsetInteger);
        setInteger1.retainAll(hashsetInteger);//chỉ giữ các phần tử có trong hashsetInteger ở setInteger1(giao)
        setInteger1.removeAll(hashsetInteger);//xóa giao 2 tập và lưu vào setInteger1
    }
}
