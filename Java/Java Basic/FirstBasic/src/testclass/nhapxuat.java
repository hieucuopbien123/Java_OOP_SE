package testclass;
//định nghĩa class nhapxuat nằm trong package testclass, package testclass phải là 1 thư mục 
//có các file class java bên trong

// Basic - package

import java.util.Scanner;

public class nhapxuat {
    public static void main(String[] args) {
        String ten;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your name: ");
        ten = scanner.nextLine();
        scanner.close();
        System.out.println("\\Welcome " + ten);
    }
}