package SingletonPattern;

public class EBillPughSingleton {
    private EBillPughSingleton(){
        System.out.println("Call constructor");
    }
    
    private static class SingletonHelper{
        public static final EBillPughSingleton INSTANCE = new EBillPughSingleton();
        //khi gọi getInstance thì BillPughSingleton() mới được gọi
    }
    
    public static EBillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
//Khi có quá nhiều luồng lấy data thì các cách tiếp cận trước không tốt cho hiệu năng
//BillPugh tạo singleton băng cách sử dụng 1 lớp trợ tĩnh bên trong
//Bên trong SingletonHelper có 1 biến Instance là khởi tạo của class. Để tăng hiệu suất rất đơn giản
//ta chỉ cần khiến cho mỗi khi gọi getInstance thì biến mới được tạo ra khi mới gọi lần đầu tiên. Còn các lần
//sau lấy cái đã từng tạo ra sẵn kèm với 1 điều kiện là mọi luồng truy cập được thoải mái