package Exception;

import java.util.Scanner;

// Error handling try catch

public class First {
    public static int myMethod()
    {
        try {
            return 112;
        }
        finally {
            System.out.println("break continue return k anh huong finally block");
        }
    }
    public static void main(String args[]) {
        try {
            int num1 = 0;
            int num2 = 62 / num1;
            //ngoại lệ bắt thì nó k đi tiếp trong hàm try đâu mà đi ra ngoài tiếp luôn
            System.out.println("Ket thuc try block.");
        }
        catch (ArithmeticException e) { //bắt ngoại lệ số học
            System.out.println("Loi: So bi chia không the là so 0");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Canh bao: ngoai le ArrayIndexOutOfBoundsException");
        }
        catch (Exception e) {//exception chung khi mà còn TH cái trên k bắt được
            System.out.println("Loi: mot ngoai le da xay ra");
        }
        finally{
            System.out.println("Finally k co cx dc");
        }

        System.out.println(myMethod());

        //chính vì finally block được thực hiện bất chấp try fail nên ta có thể lợi dụng để gọi hàm close các stream
        //của java
        try{ 
            Scanner scanner = new Scanner(System.in);
            try{
                scanner.nextLine();
                throw new ArithmeticException("Error ne"); 
            }
            catch(ArithmeticException e){
                System.out.println(e.getMessage());
            }
            finally{
                scanner.close();
            }
        }finally{ }
    }
}
