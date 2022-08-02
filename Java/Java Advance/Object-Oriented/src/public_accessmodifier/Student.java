package public_accessmodifier;

import person.Person;

// Class

public class Student {
    void hienThiTenLop() {
        System.out.println("Default access modifier only be called from same package");
    }
    private int pivVar = 10;
    public static void main(String[] args) {
        // Do ClassOfStudent thuộc cùng package mà public nên truy cập được ở mọi lớp, nhưng nếu ClassOfStudent
        //mà thuộc 1 package khác thì dù public ta cx phải import class đó vào class này để dùng
        Person person = new Person();
        person.showInformation();

        ClassOfStudent classOfStudent = new ClassOfStudent();
        classOfStudent.inputYourClass();
        classOfStudent.showInformation();//gọi được hàm protected

        Student stu = new Student();
        stu.hienThiTenLop();
        System.out.println(stu.pivVar);
    }
}

