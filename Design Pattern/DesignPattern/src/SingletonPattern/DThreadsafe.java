package SingletonPattern;

public class DThreadsafe {
    private static DThreadsafe instance;
    
    private DThreadsafe(){}

    // public static synchronized DThreadsafe getInstance(){
    //     if(instance == null){
    //         instance = new DThreadsafe();
    //     }
    //     return instance;
    // }

    public static DThreadsafe getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (DThreadsafe.class) {
                if(instance == null){
                    instance = new DThreadsafe();
                }
            }
        }
        return instance;
    }

}
// V1 khắc phục lỗi nhưng nó chậm và tốn hiệu năng vì các thread phải chờ nhau trong cả hàm
// V2 cải tiến bằng cách dùng synchronized cho đoạn code cần thiết thôi chứ kp cả hàm để tăng hiệu năng. VD ban 
// đầu 2 thread cùng gọi getInstance dù 1 cái instance==null, 1 cái instance!=null sẽ phải chờ. Bh 2 thread cùng gọi và
// cùng chạy 1 lúc luôn => chỉ dùng thread safe cho đoạn code quan trọng
// cú pháp: synchronized(<class nào>){<code chỉ được chạy bởi 1 thread trong class đó>} dùng khi k muốn dùng synchronized cho
// cả hàm của class mà chỉ dùng cho 1 phần trong hàm của class