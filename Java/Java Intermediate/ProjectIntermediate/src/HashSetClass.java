import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashSetClass {
    // Collection Framework trong java
    
    public static void main(String[] args){
        //khởi tạo kích thước ban đầu 16 với hệ số tải 0.75 cx là mặc định. K nên đổi các thông số này
        HashSet<String> hashSetString = new HashSet<>(16, 0.75f);
        hashSetString.add("Hello");
        System.out.println(hashSetString.contains("Hello"));
        hashSetString.clear();
        System.out.println(hashSetString.isEmpty());

        String[] array = new String[hashSetString.size()];
        hashSetString.toArray(array);
        System.out.println(array);
        //phân biệt HashSet toArray lưu ra String[], nhưng ArrayList toArray ra Object[] k được tùy ý

        TreeSet<Character> treeSetCharacter = new TreeSet<>(new HashSet<>());//vô nghĩa vl
        //add, iterator, contains, addAll, remove, clear, isEmpty, subSet, headSet, tailSet, first, last

        //kích thước khởi tạo là 4 và hệ số tải 0.75, cx giống HashSet
        HashMap<Double, Double> hashMap3 = new HashMap<>(4, 0.75f);
        //entrySet, forEach, put, keySet, iterator values, get, remove, replace, putAll, containsValue

        TreeMap<String, Double> treeMap1 = new TreeMap<>();
        //entrySet, forEach, put, values, iterator, keySet, containsValue, remove, replace, putAll, 
    }
}
