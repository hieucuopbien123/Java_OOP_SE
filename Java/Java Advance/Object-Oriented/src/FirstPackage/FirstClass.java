package FirstPackage;

public class FirstClass {
    // Class
    private String name;
    public FirstClass() { }
    public FirstClass(String name) {
        System.out.println("Your name: " + name);
    }

    // Static
    public static void nhapCoDoiSo(String str) {//gọi trong main phải có static vì gọi đến hàm chính nó
        System.out.println(str);
    }
    public static int tinhTong(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass("Hieu");//main của lớp khởi tạo lớp luôn
        int c = tinhTong(3, 5);
        nhapCoDoiSo(String.valueOf(c));
    }
}