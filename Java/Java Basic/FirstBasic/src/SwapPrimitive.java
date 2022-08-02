public class SwapPrimitive {
    // Basic - Other

    public static void swap1(Integer a, Integer b) {
        int temp = a;
        a = b; 
        b = temp;
    }
    //fix tạm thời nhưng nhiều biến thì k được
    public static int swap2(int a, int b) {
        return a;
    }
    public static void main(String[] args){
        //primitive type trong java tự là copy, nếu muốn swap 2 biến tạo trong main k thể làm bth
        Integer a = 1;
        Integer b = 2;
        swap1(a, b);
        System.out.println(a + " " + b);

        a = swap2(b, b = a);//Phải đúng thứ tự vì nó biên dịch từ trái sang phải tức truyền b vào r mới gán b=a
        System.out.println(a + " " + b);

        a = a ^ b ^ (b = a);//swap bằng phép XOR: a^b^a = b. 
        System.out.println(a + " " + b);

        a += (b - (b = a));//swap bằng toán tử bth
        System.out.println(a + " " + b);

        //cách khác là biến a, b k ở trong main nx mà là biến của class này có hàm swap luôn thì đổi được tt
    }
}
