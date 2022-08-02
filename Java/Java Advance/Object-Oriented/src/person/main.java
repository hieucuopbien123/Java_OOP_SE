package person;

// Class

public class main {
    public static void main(String[] args){
        Male male = new Male();
        male.learn();
        male = new hsLopToan();
        male.learn();
        male = new hsLopLy();
        male.learn();
        //đối tượng male có tính đa hình là hsLopToan or hsLopLy đều ok, trong ngữ cảnh khác nhau nó có thể đóng
        //vai trò của đối tượng khác nhau mà ta k cần khai báo nhiều biến con cho từng đối tượng
        
        hsLopToan a = new hsLopToan();
        System.out.println(a instanceof Male);
    }
}
