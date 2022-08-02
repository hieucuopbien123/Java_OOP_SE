package testcomparable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// Basic - Biến và type:

public class Test {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(100, "TiTV 1");
        SinhVien sv2 = new SinhVien(150, "TiTV 2");
        System.out.println(sv1.compareTo(sv2));

        //tra các class có sẵn trong java docs rất nhiều
        int[] a = new int[]{1, 8, 2, 6, 4, 3, 7, 9};
        Arrays.sort(a);//mảng nguyên thủy trong java muốn sort giảm dần buộc phải viết hàm đảo ngược mảng thủ công
        System.out.println(Arrays.binarySearch(a, 4));//sx r ms dùng đc

        // Thao tác với String

        Arrays.fill(a, 5);
        System.out.println(Arrays.toString(a));

        // sort hàm object bất kỳ
        SinhVien[] arrSV = {sv1, sv2, new SinhVien(199, "Hello")};
        Arrays.sort(arrSV);
        //thật ra sort mặc định dùng compareTo của class. ở đây ta định nghĩa compareTo r nên nó mới dùng như này đc
        System.out.println(Arrays.toString(arrSV));//chỉ in ra list địa chỉ

        // Thao tác với Date
        System.out.println(TimeUnit.DAYS.toSeconds(3000*365) + "s");//đổi đơn vị

        DateFormat df = new SimpleDateFormat("yyyy-MMM-dd HH:mm::ss");
        System.out.println(df.format(new Date(System.currentTimeMillis())));
        //currentTimeMillis giống clock của C++ có thể dùng tính thời gian chạy lệnh
    }
}
