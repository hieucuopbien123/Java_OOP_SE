package hust.soict.globalict.lab01;

import java.util.Scanner;

/**
 * calculate2numbers
 */
public class calculate2numbers {
    public static void main(String[] args) {
        double sum, difference, product, quotient, divisor, num1, num2;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("First number: ");
        num1 = sc.nextDouble();
        System.out.println("Second number: ");
        num2 = sc.nextDouble();
        sc.close();
        int intValue1 = (int) num1;
        int intValue2 = (int) num2;
        System.out.println("Sum of 2 numbers is: " + (num1 + num2));
        System.out.println("Difference of 2 numbers is: " + (num1 - num2));
        System.out.println("Product of 2 numbers is: " + (num1*num2));
        System.out.println("Quotient of 2 numbers is: " + (intValue1/intValue2) + " with the divisor is: " + (intValue1%intValue2));
    }
    
}