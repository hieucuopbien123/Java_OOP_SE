import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListClass {
    // Collection Framework trong java
    
    public static void main(String[] args) {
        //đặt mẹ type là class luôn, k cần đặt là interface cx đc
        LinkedList<Double> list = new LinkedList<Double>();
        list.add(2.02);
        list.add(2.01d);
        ListIterator<Double> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "\t");
        }
        System.out.println("\nDuyêt nguoc:");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + "\t");
        }

        list.addFirst((double) 4);//Java chặt ở chỗ, ta thêm int vào hàm nhận double nó éo cho mà phải tự cast nhỏ->lớn
        list.addLast(6d);
        list.addLast(6d);
        System.out.println("\n" + list.getFirst());
        System.out.println(list.getLast());

        System.out.println(Integer.parseInt("90"));
        System.out.println(Integer.parseInt("10", 2));//10 ở cơ số 2 in ra 2 còn gì
        System.out.println(String.valueOf(100));//chuyển cái gì thành chuỗi
        
        //removeFirst(), removeLast(), removeAll(<1 list khác>) để xóa giao 1 tập
        System.out.println(list);
        list.remove(0);//xóa index
        list.remove(6d);//xóa 1 value đầu tiên nếu trùng
        System.out.println(list);

        ArrayList<String> arrListString = new ArrayList<>(100);
        //addAll, remove, contains, indexOf, các thứ k có hàm mới, cung thêm mỗi clear và toArray
        arrListString.clear();
        arrListString.add("Hello");
        Object[] arr = arrListString.toArray();//chuyển sang array nhưng là Object[]
        System.out.println(arr);//ra address kệ mẹ éo quan tâm
        System.out.println(arr.length);//phân biệt class bth dùng .size(); còn array dùng .length;
        System.out.println(arr[0]);
    }
}
