package SingletonPattern;

public class BStaticBlockInitialization {
    private static BStaticBlockInitialization instance;
    
    private BStaticBlockInitialization(){}
    
    static{
        try{
            instance = new BStaticBlockInitialization();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static BStaticBlockInitialization getInstance(){
        return instance;
    }
}
//đã xử lý ngoại lệ nhưng vẫn tự động tạo dù có thể k cần dùng. Cục trong static{<>} sẽ thực hiện khi chạy tới
//như 1 hàm static chỉ thực hiện 1 lần trước khi khởi tạo v. Do chỉ cần thực hiện 1 lần nên ta k cần tên hàm như bth