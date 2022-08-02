package hust.soict.globalict.lab01;
import java.util.Scanner;

public class solveEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("Choose your option: ");
        System.out.println("1. The first-degree equation (linear equation) with one variable: ");
        System.out.println("2. The system of first-degree equations (linear system) with two variables: ");
        System.out.println("3. The second-degree equation with one variable: ");
        option = sc.nextInt();
        switch(option) {
            case 1:
                Double a,b;
                System.out.println("Input the coefficient a = " );
                a = sc.nextDouble();
                System.out.println("Input the coefficient b = " );
                b = sc.nextDouble();
                
                System.out.println("The equation has a unique solution x = " + (-b/a));
                break;
            case 2:
                double a11, a12, a21, a22, b1, b2;
                System.out.println("Input the coefficient a11, a12, a21, a22, b1, b2 = " );
                a11 = sc.nextDouble();
                a12 = sc.nextDouble();
                a21 = sc.nextDouble();
                a22 = sc.nextDouble();
                b1 = sc.nextDouble();
                b2 = sc.nextDouble();
                double D = a11 * a22 - a21 * a12;
                double D1 = b1 * a22 - b2 * a12;
                double D2 = a11 * b2 - a21 * b1;
                if (D  != 0) {
                    System.out.println("the equation has a unique solution: x = " + D1/D + " y = " + D2/D);
                
                }
                else if(D1 ==0 && D2 == 0 && D ==0) {
                    System.out.println("The equation has infinitely many solutions" );
                }
                else {
                    System.out.println("The equation has no solution" );
                }
                break;
            case 3:
                double a1,a2,a3;
                System.out.println("Input the coefficient a,b,c = " );
                a1 = sc.nextDouble();
                a2 = sc.nextDouble();
                a3 = sc.nextDouble();
                double denta = a2 * a2 - 4 * a1 * a3;

                if(denta == 0) {
                    System.out.println("the equation has a unique solution: x = " + (-a2/(2*a1)));
                }
                else if (denta >0) {
                    System.out.println("the equation has two solutions: x1 = " + ((-a2 + Math.sqrt(denta))/(2*a1)) + " and x2 = " + ((-a2 - Math.sqrt(denta))/(2*a1)));
                }
                else {
                    System.out.println("The equation has no solution" );
                }
                break;
            
        }
        
    }
}
