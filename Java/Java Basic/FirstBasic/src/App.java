import java.util.Vector;

import javax.swing.JOptionPane;

public class App {
    // Basic - Show dialog, input, output
    App() {
        this(10);
        System.out.println("Calling default constructor: ");
    }
    App(int a) {
        System.out.println("Calling constructor: " + a);
    }
    public static void call(int a){
        System.out.println("int");
    }
    public static void call(short a){
        System.out.println("short");
    }
    public static void call(long a){
        System.out.println("long");
    }
    public static void main(String[] args) throws Exception {
        float y = (float)(10.2);
        long x = (long)y;
        System.out.println(x);

        call(5);//tự gọi int
        new App();

        Vector<Integer> a = new Vector<Integer>(10);
        Vector<Integer> b = new Vector<Integer>(10,20);//quá capacity tự +20 ptu

        System.out.println("Hello\n World!");//sysout

        String result;
        result = JOptionPane.showInputDialog("Please enter your name: ");
        JOptionPane.showMessageDialog(null, "Hello " + result + "\n");

        String strNum1;
        String strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number", "Input a number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number", "Input a number", JOptionPane.INFORMATION_MESSAGE);
        double d1 = Double.parseDouble(strNum1);
        double d2 = Double.parseDouble(strNum2);
        JOptionPane.showMessageDialog(null, "Show difference: " + ((d1 > d2) ? (d1 - d2) : (d2 - d1)), "Show cal", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}