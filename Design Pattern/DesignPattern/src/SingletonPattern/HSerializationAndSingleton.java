package SingletonPattern;

import java.io.Serializable;

// Đôi khi trong các hệ thống phân tán, chúng ta cần triển khai giao diện Serialization trong lớp Singleton để có thể 
//lưu trữ trạng thái của nó trong hệ thống tệp và truy xuất nó vào một thời điểm sau.
public class HSerializationAndSingleton implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;//chưa hiểu cái này làm gì
    private HSerializationAndSingleton(){}
    
    private static class SingletonHelper{
        private static final HSerializationAndSingleton instance = new HSerializationAndSingleton();
    }
    
    public static HSerializationAndSingleton getInstance(){
        return SingletonHelper.instance;
    }

    public int a;
    public void test(){
        System.out.println(++a);
    }
}
