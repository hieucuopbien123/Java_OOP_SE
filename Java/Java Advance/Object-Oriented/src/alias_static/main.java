package alias_static;

// Class

public class main {
    public static void main(String[] args){
        Customer customer1 = new Customer("Nguyen Van A");
        Customer customer2 = new Customer("Nguyen Van B");
        customer2 = customer1;
        customer2.name = "Nguyen Thi Buoi";
        System.out.println(customer1.name);
        //alias là hiện tượng 1 ô nhớ nhưng có >=2 đối tượng trỏ tới. Ở đây xảy ra hiện tượng alias
        //Java có Garbage collection tự xóa các ô nhớ mà k có j trỏ tới tức là ô nhớ khai báo đầu tiên của customer2
        //tự động bị xóa. Khác với C++ ta phải delete mất tg

        System.out.println(Customer.age);
    }
}
