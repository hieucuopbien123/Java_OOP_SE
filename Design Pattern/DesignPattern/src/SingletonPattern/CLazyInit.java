package SingletonPattern;

public class CLazyInit {
    private static CLazyInit instance;
    
    private CLazyInit(){}
    
    public static CLazyInit getInstance(){
        if(instance == null){
            instance = new CLazyInit();
        }
        return instance;
    }
}
// Dùng tốt trong môi trường đơn luồng nhưng nếu đa luồng sẽ có sự cố nếu nhiều luồng gặp if 1 lúc thì sẽ phá huy 
// mẫu singleton. Vd 2 thread cùng gọi getInstance lần đầu tiên cùng lúc có thể tạo ra 2 biến instance liền, 1 biến new bị thay thế gây
// memleak