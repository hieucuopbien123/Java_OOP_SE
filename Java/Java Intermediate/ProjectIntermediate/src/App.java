import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// Collection Framework trong java

//Iterator dùng cả Set, Map, List
//ListIterator chỉ dùng cho List(List Interface, ArrayList, LinkedList,..)
public class App {
    public static void main(String[] args){
        //muốn dùng 1 interface phải khai báo 1 class implement nó. Ở đây test với 2 class phổ biến nhất là
        //ArrayList và LinkedList. 2 cái này khác nhau thế nào tự rõ rồi
        List<Integer> listInteger = new ArrayList<Integer>();
        List<String> listString = new LinkedList<String>();
        List<Float> listFloat = new ArrayList<Float>(1000);//có thể khai báo rõ số lượng phần tử

        listString.add("One");
        for (int i = 0; i < listString.size(); i++) {
            System.out.println(listString.get(i));
        }
        for (String element : listString) {
            System.out.println(element);
        }

        Iterator<String> iterator = null;
        iterator = listString.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }    

        ListIterator<String> listIterator = null;
        listIterator = listString.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        listFloat.add(0, 0.5f);//k thể thêm vào vị trí 2 nếu vị trí 1 chưa được set, nó chèn insert vào

        List<String> listString1 = new LinkedList<String>();
        listString1.add("Two");
        listString.addAll(listString1);//2 collection phải cùng kiểu dữ liệu
        listString.addAll(1, listString);//thêm chính nó vào vị trí số 1 of chính nó
        for (int i = 0; i < listString.size(); i++) {
            System.out.println("Data: " + listString.get(i));
        }
        listString.set(2, "Zero");//update
        listString.remove(0);
        listString.remove("Two");//nếu trùng sẽ xóa phần tử đầu tiên. Trả true nếu tồn tại phần tử đó để xóa
        System.out.print(listString.contains("Six") + "\n");//print k tự xuống dòng như println
        System.out.println(listString.indexOf("Three"));//trả -1 nếu k có. Trả ra index đầu tiên gặp
        // X lastIndexOf(<ele>);
        Collections.sort(listString);//có thể có đối số 2 là comparator boolean function
        // Collections.copy(listString, listString1);//copy 2 vào 1 nhưng kích thước của 1 phải lớn hơn 2 chứ
        //nhỏ hơn thì nó k tự add đâu mà báo lỗi

        Collections.shuffle(listString);//mỗi lần compile sẽ shuffle loạn lên
        for (int i = 0; i < listString.size(); i++) {
            System.out.println("Data: " + listString.get(i));
        }
    }
}
