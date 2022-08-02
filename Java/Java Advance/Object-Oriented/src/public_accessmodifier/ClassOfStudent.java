package public_accessmodifier;

import java.util.Scanner;

public class ClassOfStudent {
    private String name;
    public int numberOfPupils;

    void setName(String name) {
        this.name = name;
    }
    String getName(){
        return name;
    }
    
    public void inputYourClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Class name: ");
        name = scanner.nextLine();
        System.out.println("Number of student: ");
        numberOfPupils = scanner.nextInt();
    }

    private void showInfo(){
        System.out.println("Class name is " + name + ", number of students =  " + numberOfPupils + ".");
    }
    
    protected void showInformation() {
        this.showInfo();
    }//con, các lớp cùng package gọi được VD gọi được ở Student
}