import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetInterface {
    // Collection Framework trong java
    
    public static void main(String[] args){
        //SortedSet hay Set nó đều là Interface nên dùng cái nào với class TreeSet nó đều lưu được trạng
        //thái đã sắp xếp vì TreeSet luôn tự sắp xếp cho ta. Nhưng nếu lưu bằng Set thì các hàm hay ho của
        //SortedSet ta éo thao tác được vì interface nó k định nghĩa các phương thức đó. Nên thg dùng Set
        //với HashSet và SortedSet với TreeSet đúng kiểu.
        SortedSet<String> sortedSetString = new TreeSet<String>();
        sortedSetString.add("Monday");
        sortedSetString.add("Tuesday");
        sortedSetString.add("Wednesday");
        sortedSetString.add("Thursday");

        System.out.println("sortedSetString: ");
        System.out.println(sortedSetString);
        SortedSet<String> subset = sortedSetString.subSet("Thursday", "Wednesday");//đối số 2 lầ ptu cuối + 1
        System.out.println(subset);
        subset = sortedSetString.headSet("Wednesday");//nó éo nhận index mà là giá trị
        System.out.println(subset);
        subset = sortedSetString.tailSet("Tuesday");
        System.out.println(subset);
        String minVal = sortedSetString.first();
        System.out.println(minVal + " " + sortedSetString.last());
    }
}
