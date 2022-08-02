import javax.swing.JOptionPane;

public class SolveMath {
    // Basic - Show dialog, input, output

    public static void main(String[] args) {
        System.out.println("First degree equation");
        /*
        String str1 = JOptionPane.showInputDialog(null, "Input a");
        String str2 = JOptionPane.showInputDialog(null, "Input b");
        double d1 = Double.parseDouble(str1);
        double d2 = Double.parseDouble(str2);
        if(d1 == 0){
            JOptionPane.showMessageDialog(null, "No value of x satisfied", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "x = " + (-d2/d1), "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        */
        System.out.println("First degree equation two vars");
        /*
        String str11 = JOptionPane.showInputDialog(null, "Input a11");
        String str12 = JOptionPane.showInputDialog(null, "Input a12");
        String str1 = JOptionPane.showInputDialog(null, "Input b1");
        String str21 = JOptionPane.showInputDialog(null, "Input a21");
        String str22 = JOptionPane.showInputDialog(null, "Input a22");
        String str2 = JOptionPane.showInputDialog(null, "Input b2");
        double d11 = Double.parseDouble(str11);
        double d12 = Double.parseDouble(str12);
        double d21 = Double.parseDouble(str21);
        double d22 = Double.parseDouble(str22);
        double d1 = Double.parseDouble(str1);
        double d2 = Double.parseDouble(str2);
        double D = d22*d11-d12*d21;
        double Dx = d22*d1-d2*d12;
        double Dy = d11*d2-d1*d21;
        if(Dx == 0){
            System.out.println((Dx == Dy && Dx == 0) ? "Infinity many solution" : "No solution");
        }else{
            System.out.println("Solution: " + Dx/D + " and " + Dy/D);
        }
        */
        System.out.println("Second degree equation one vars");
        String aD = JOptionPane.showInputDialog(null, "Input a");
        String bD = JOptionPane.showInputDialog(null, "Input b");
        String cD = JOptionPane.showInputDialog(null, "Input c");
        double a = Double.parseDouble(aD);
        double b = Double.parseDouble(bD);
        double c = Double.parseDouble(cD);
        double delta = b*b-4*a*c;
        if(delta < 0){
            System.out.println("No Solution");
        }else if(delta == 0){
            System.out.println("x1 = x2 = " + ((-b + Math.sqrt(delta))/2));
        }else{
            System.out.println("x1 = " + ((-b + Math.sqrt(delta))/2) + " and x2 = " + ((-b - Math.sqrt(delta))/2));
        }

        System.exit(0);
    }
}
