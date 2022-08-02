import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapInterface {
    // Collection Framework trong java
    
    public static void main(String[] args){
        SortedMap<String, String> sortedMapDomain = new TreeMap<>(Collections.reverseOrder());//để xếp ngược lại
	    sortedMapDomain.put(".vn", "Viêt Nam");
        sortedMapDomain.put(".au", "Australia");//tự được sắp xếp r

        Map<String, String> submap = sortedMapDomain.subMap(".vn", ".au");//kbh lấy được phần tử cuối khi dùng sub
        System.out.println(submap);
        System.out.println(sortedMapDomain.tailMap(".vn"));
        System.out.println(sortedMapDomain.headMap(".au"));

        String first = sortedMapDomain.firstKey();
        System.out.println(first + " " + sortedMapDomain.lastKey());
    }
}
