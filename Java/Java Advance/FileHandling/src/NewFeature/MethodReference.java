package NewFeature;

import java.util.function.BiFunction;  
import java.util.Arrays;

// Interface

@FunctionalInterface//là interface có đúng 1 function bên trong để lưu function gọi bằng tên function bên trong
interface MyInterface1{  
    Hello display(String say);  
}  
class Hello{  
    public Hello(String say){  
        System.out.print(say);  
    }
}

class Multiplication{  
    public static int multiply(int a, int b){  
        return a*b;  
    }  
}  

@FunctionalInterface
interface MyInterface{
    void display();
}

public class MethodReference {
    public void myMethod() {
        System.out.println("call myMethod");
    }
    public static void main(String[] args) {
        MyInterface1 ref = Hello::new;//cách mà method reference refer đến constructor 1 class. K khởi tạo mà chỉ gán
        ref.display("Hello World!");
        //tức là ref nó lưu constructor

        MethodReference obj = new MethodReference();
        MyInterface ref2 = obj::myMethod;//nhanh hơn lamba or dùng luôn MethodReference::myMethod
        ref2.display();

        // Basic
        // BiFunction lưu function có 2 args trả ra result, lần lượt là type của param1, param2, result
        BiFunction<Integer, Integer, Integer> product = Multiplication::multiply;
        int pr = product.apply(11, 5);  
        System.out.println("Product of given number is: " + pr);  

        // Thao tác với String
        String[] stringArray = { "Steve", "Rick", "Aditya", "Negan", "Lucy", "Sansa", "Jon"};
        //lib Arrays cung các util thao tác với array
        Arrays.sort(stringArray, String::compareToIgnoreCase);//ss thứ tự từ điển bỏ qua lower/uppercase
        //sort List dùng Collections, còn sort array dùng Arrays, sort ArrayList dùng sort của chính nó có
        for(String str: stringArray){
            System.out.print(str + "\t");
        }
    }
}
