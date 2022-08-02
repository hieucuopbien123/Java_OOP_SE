package SingletonPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.InstantSource;

public class ISerializedSingletonTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        HSerializationAndSingleton instanceOne = HSerializationAndSingleton.getInstance();
        instanceOne.test();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("src/SingletonPattern/zzz.ser"));//write file nào
        //ObjectOutputStream xác định viết vào 1 output stream nào và ở đây là FileOutputStream
        out.writeObject(instanceOne);//write object vào stream nào. Write cái mẹ gì cx được, ở đây là global instance
        //1 class luôn
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("src/SingletonPattern/zzz.ser"));
        HSerializationAndSingleton instanceTwo = (HSerializationAndSingleton)in.readObject();
        in.close();
        //Tưởng gì chứ cx chỉ lưu nd biến vào file r lấy ra. Đó là mục đích của marker interface

        System.out.println("First hashCode: " + instanceOne.hashCode());
        System.out.println("Second hashCode: " + instanceTwo.hashCode());
        instanceTwo.test();
        // 2 biến này cùng giá trị nhưng bộ nhớ lưu khác nhau vì nó tạo new object mà. Nhưng giá trị của instanceTwo 
        //hệt instanceOne. Đây chính là vai trò của marker interface là lưu trạng thái biến vào 1 file và truy cập 
        //dùng nó về sau. Tức instanceOne kể cả bị xóa đi rồi nhưng về sau ta vẫn lấy lại được thành 1 biến có giá
        //trị y hệt là instance Two
    }
}