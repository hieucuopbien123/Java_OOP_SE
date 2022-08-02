package testfunction;

// Basic - Other - equals

public class TestFunction {
    public void test(int a) {
        a++;
    }
    public void testArr(int[] a){
        a[0]++;
    }
    public void testObject(FirstClass fc) {
        fc.number = 20;
    }

    @Override  
    public boolean equals(Object obj)   
    {  
        if (obj == null)   
        return false;  
        if (obj == this)  
        return true;  
        return true;
    }  
    public static void main(String[] args){
        int a = 1;
        int b = a;
        b++;
        System.out.println(a);

        int arr[] = new int[100];
        int brr[] = arr;
        arr[0] = 2;
        System.out.println(brr[0]);

        TestFunction testFunction = new TestFunction();
        testFunction.test(a);
        System.out.println(a);

        testFunction.testArr(arr);
        System.out.println(brr[0]);
        //như C++ nhưng dường như tham chiếu hay copy nó tự động hết r

        //Trong java các type đều có class kế thừa từ java.lang.Object do đó mọi class ta đều gọi là 1 Object
        //Các type cơ bản khi ta dùng sẽ có 1 số type tự cast sang các class như: string a sẽ thành String a; với 
        //String là 1 class. Lưu ý chỉ 1 số ví dụ int a thì sẽ k tự cast sang Integer a; đâu
        //Khi ở Object ta có thể so sánh tham chiếu với == và so sánh giá trị với equals. Còn các type bình thường
        //thì mặc định như C++ k thay đổi VD ta k thể ép truyền biến vào hàm mà là tham chiếu được 
        int c = 10;
        // System.out.println(c instanceof Object);//sai
        Integer d = 10;
        System.out.println(d instanceof Object);
        
        Integer e = 100;
        Integer f = 100;//lên constant pool
        Integer g = new Integer(100);//lên heap(constant pool trong heap)
        System.out.println(e.equals(100));//true
        System.out.println(e == 100);//true
        System.out.println(e == f);//true
        System.out.println(e.equals(f));//true
        System.out.println(e.equals(g));//true
        System.out.println(e == g);//false
        // => cơ chế giống cách java lưu hằng số string

        FirstClass firstClass = new FirstClass();
        FirstClass firstClass2 = new FirstClass();
        System.out.println(firstClass == firstClass2);
        System.out.println(firstClass.equals(firstClass2));
        //Với các class ta tự tạo nó k còn là kiểu cơ bản. == là tham chiếu chắc chắn false khác nhau rồi
        //nhưng equals là ss giá trị điều hay là nó cx khác nhau vì có rất nhiều thú khác mà nó sinh ra cho biến mà
        //ta k thể trực tiếp thấy được. 2 object tự tạo luôn khác nhau, chỉ khi refer đúng tham chiếu mới bằng nhau
        //Nếu muốn so sánh giá trị giống các trường thì phải custom 1 function riêng. VD: 2 object không bằng nhau là vì
        //hashcode bên trong nó khác nhau

        //truyền object vào hàm thì là truyền tham chiếu -> hiểu hết r
        testFunction.testObject(firstClass);
        System.out.println(firstClass.number);//20
    }
}
