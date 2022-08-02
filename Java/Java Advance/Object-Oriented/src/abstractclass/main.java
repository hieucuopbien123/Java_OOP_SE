package abstractclass;

public class main {
    // Basic
    public static int testOverloading(int ...x) {
        int sum = 0;
        for (int i : x) 
            sum += i;
        return sum;
    }
    public static void main(String[] args){
        // Abstract class
        Dog dog = new Dog();
        dog.showType();
        Animal animal = new Cat();
        animal.showName();//Éo cần virtual như C++, bản chất khai báo là Cat thì nó gọi hàm của Cat
        testOverloading(1,2,3,4);
        testOverloading(1,2,3);
        //Java hỗ trợ nhận ... vào params hàm sẽ trả ra 1 array 1 chiều các tham số truyền vào. Nên nhớ bản chất
        //ở đây có nghĩa là nó overloading hàm testOverloading với số lượng tham số khác nhau
    }
}
