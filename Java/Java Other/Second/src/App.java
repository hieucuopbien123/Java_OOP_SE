public class App {
    // Thao tác với string

    public static void test(int[] arrInt){
        arrInt[0] = 1;
    }
    public static void main(String[] args) throws Exception {
        //khi truyền vào mảng thì bản chất là đổi giá trị tại địa chỉ nên đổi được
        int[] arrInt = {10,20,30};
        test(arrInt);
        System.out.println(arrInt[0]);

        System.out.println(Boolean.TRUE);
        Byte bBig = Byte.MAX_VALUE;
        byte bSmall = bBig.byteValue();
        System.out.println(bSmall);
        //Tương tự mọi kiểu dữ liệu đều có VD: Double.MIN_VALUE, Double.POSITIVE_INFINITY
        char c1 = '9';
        System.out.println(Character.digit(c1, 10));//trả ra số đó từ char nếu nó nằm trong khoảng 0 -> radix
        //trả ra -1 nếu radix k nằm trong range MIN_RADIX và MAX_RADIX. Or ký tự k là số

        String a = "A123";
        String b = "a23";
        System.out.println(a.equalsIgnoreCase(b));

        //String là cố định và việc cộng các string lại sẽ tạo ra các string mới lưu trong pool rất expensive
        //StringBuffer/StringBuilder là mutable type và object có thể dổi giá trị sau khi được tạo
        String str1 = "Hello ";
        str1 += "WOrld";//đắt
        StringBuffer str2 = new StringBuffer("Hi ");
        str2.append(" World");//rẻ vì k tạo ra các string mới mà đổi trên string cũ

        StringBuffer sb = new StringBuffer("hi");
        StringBuffer tb = sb;
        tb.append("gh");
        tb.insert(2, 'a');
        System.out.println(sb + " " + tb);
        
        System.out.println(Math.E);
    }
}
