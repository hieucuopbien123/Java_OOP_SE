package usingtemplate;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Basic - template wildcard

public class template<T> {
    public T getT(T a){
        return a;
    }
    void printList1(List<? extends Integer> lst){
        Iterator it = lst.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
    void printList2(List<? super Integer> lst){
        Iterator it = lst.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
    void printCollection(Collection<?> c) { 
        for(Object o:c) { 
            System.out.println(o); 
        } 
    } 
    // Cái wildcard ? là mọi type
    //? extends Type là xác định dùng tập hợp các types con of Type(dùng được các Type kế thừa từ Type)
    //? super Type là xác định dùng tập hợp các types cha của Type

}
