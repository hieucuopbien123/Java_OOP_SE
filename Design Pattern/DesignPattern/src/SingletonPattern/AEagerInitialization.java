package SingletonPattern;

public class AEagerInitialization {
    private static final AEagerInitialization instance = new AEagerInitialization();
    
    private AEagerInitialization(){
        System.out.println("Constructor");
    }

    public static AEagerInitialization getInstance(){
        return instance;
    }
}
//PP tạo dễ nhất nhưng nó luôn tạo instance dù có thể ta k dùng nó. Nếu lớp k chiếm tài nguyên thì dùng ok
//nhưng thg là singleton được tạo cho các tài nguyên như file, database connection nên cách này chưa ổn, cx
//chưa cung xử lý ngoại lệ