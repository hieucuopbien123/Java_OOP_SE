package NewFeature;

// Interface

interface Dog{
    default void show(){
        System.out.println("Đây là show Dog");
    }
    void run();
}
interface Bird{
    default void show(){
        System.out.println("Đây là show Bird");
    }
    void fly();
}
//Trong java k hỗ trợ đa kế thừa nhưng interface thì ok hết mà interface có 1 default method nên cũng coi
//là có 1 chút đa kế thừa và đa kế thừa thi luôn dẫn đến lỗi xung đột. Ở đây hàm show ở cả Dog và Bird bị trùng
//nên phải solve nếu k sẽ báo lỗi
public class DefaultMethods2 implements Dog, Bird {
    //Cách 1: gọi show trong class implements và gọi super
    // public void show(){
    //     Dog.super.show();
    // }
    //Cách 2: override
    @Override
    public void show(){
        System.out.println("Dây là show Animal");
        Dog.super.show();
    }

    @Override
    public void run() {
    }

    @Override
    public void fly() {
    }
    public static void main(String[] args) {
        DefaultMethods2 animal = new DefaultMethods2();
        animal.show();
    }
}