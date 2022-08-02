package SingletonPattern;

public enum GEnumSingleton {
    //khai báo hàng loạt giá trị của enum trước 
    INSTANCE;

    public static void doSomething(){
        //do something
    }
}
//Java đảm bảo mọi giá trị enum chỉ được khởi tạo 1 lần trong CT và có thể truy cập toàn cục nhờ public.
//Nhưng nó k linh hoạt. Vd k cho phép khởi tạo eager init