package person;

public class Person {
    private String name = "Freetuts!";
    protected String age = "1";

    public Person() { }//khai báo ở dưới như kia thì constructor mặc định k còn tự có
    public Person(int number) {
        System.out.println("Constructor lop cha: " + number);
    }
        
    public void showInformation() {
        System.out.println("You are " + name);
    }
}