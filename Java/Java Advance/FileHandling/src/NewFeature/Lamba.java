package NewFeature;

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

// Interface

@FunctionalInterface//báo hiệu là cái interface chức năng
interface MyFunctionalInterface {
    //A method with no parameter
    public String sayHello();
}
interface StringConcat {
    public String sconcat(String a, String b);
}

public class Lamba {  
    public static void main(String[] args) {
        MyFunctionalInterface msg = () -> {
            return "Hello";
        };//khai báo FunctionalInterface là 1 hàm số này tự động gán cho sayHello vì nó là hàm duy nhất của interface
        System.out.println(msg.sayHello());//dùng như này

        StringConcat s = (str1, str2) -> str1 + str2;//interface 1 function kiểu này thg dùng nhanh như này
        System.out.println("Result: " + s.sconcat("Hello ", "World"));
        //lamba cx chỉ là 1 function. VD forEach nhận params là 1 function thì truyền đc lamba vào


        Frame frame = new Frame("ActionListener java8");          
        Button b = new Button("Click Here");  
        b.setBounds(50, 100, 80, 50);
        //lamba function dạng: toán tử -> biểu thức => nếu 1 biểu thức thì bỏ {;} đc
        b.addActionListener(e -> {System.out.println("Hello World!"); frame.setVisible(false);}); 
        frame.add(b);
        frame.setSize(200,200);  
        frame.setLayout(null);  
        frame.setVisible(true);   
    }
}