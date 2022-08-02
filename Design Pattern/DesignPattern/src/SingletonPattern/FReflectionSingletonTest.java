package SingletonPattern;

import java.lang.reflect.Constructor;

// Dùng Reflection để huy singleton pattern

public class FReflectionSingletonTest {
    public static void main(String[] args) {
        AEagerInitialization instanceOne = AEagerInitialization.getInstance();
        AEagerInitialization instanceTwo = null;
        try {
            Constructor[] constructors = AEagerInitialization.class.getDeclaredConstructors();
            System.out.println(constructors.length);
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (AEagerInitialization) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());//hash code khác nhau tức 1 instance khác đã đc tạo
        //Ở đây ta implement là instanceOne là global instance. Xong duyệt tất cả các hàm constructor của class và 
        //lấy các constructors của class AEagerInitialization từng dùng. Sau đó tạo ra 1 instance mới dựa vào 
        //constructor đó. Nhờ v mà singleton bh có thể tạo đến 2 instance. instance 2 này ta đang dùng trong local thôi
        // => Điều này làm mất tc của singleton. Dù ta tưởng đặt constructor là private và 1 static được tạo ra nhưng
        //ở đây ta vẫn tạo ra thêm instance thoải mái. Cách này được dùng nhiều trong các thư viện Spring, Hibernate,..
        //Nó kiểu dùng như v khi tạo ra các thư viện cho người khác dùng thì cấm người đó tạo thêm instance cho class
        //Nhưng thực tế những người tạo thư viện vẫn có thể dùng 2 instance nếu muôn.
    }
}
// Họ nghĩ thêm 1 cách nữa là Enum singleton để cấm vc tạo instance hoàn toàn luôn