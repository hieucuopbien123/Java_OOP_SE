package person;

public class Male extends Person {
    protected String age = "2";
    public Male() { }
    public Male(int number) {
        super(number);  // gọi hàm tạo của lớp Person có tham số
        age = String.valueOf(number);
    }
    //nếu k có gì thì mặc định cx tự gọi default constructor của cha

    public void showInformation() {
        System.out.println("You are a legend");
        super.showInformation();
        System.out.println(super.age + " _ " + age);
    }

    public void learn(){
        System.out.println("Di hoc nao");
    }

    public static void main(String[] args) {
        Male male = new Male(10);
        male.showInformation();
    }
}
