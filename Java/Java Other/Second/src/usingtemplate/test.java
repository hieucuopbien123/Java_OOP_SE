package usingtemplate;

import java.util.ArrayList;
import java.util.List;

// Basic - template - wildcard

public class test<T> extends template<T>{
    public static void main(String args[]) {
        template<Integer> t = new template<>();
        System.out.println(t.getT(10));

        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        t.printCollection(a);
        t.printList2(a);
        t.printList1(a);
    }
}
