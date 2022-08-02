import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import testpackage.*;

// Basic - IMPORTANT - bản chất copy

public class App {
	//main => ctrl + space
	//sysout => ctrl + space
	public static void main(String[] args) {

		//3 cách khai báo mảng
		int a1[] = {1,2,3};
		int a2[] = new int[]{1,2,3};
		int a3[] = new int[3];//xong gán từng phần tử được
		
		//cách copy mảng
		//gán = bth thì kp là copy
		int b1[] = a1;
		b1[0] = 10;
		System.out.println(Arrays.toString(a1));
		//copy
		int[] b2 = a1.clone();//copy cả mảng
		int[] b3 = new int[a1.length];
		System.arraycopy(a1, 0, b3, 0, a1.length);//copy từ đâu đến đâu

		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate.getDayOfMonth() + " " + currentDate.getMonthValue() + " " + currentDate.getYear());

		outer: for(int i = 0; i < 10; i++){
			inner: for(int j = 0; j < 5; j++){
				if(i == 2) continue outer;
				if(j == 5) continue;
				if(i == 5) break inner;
				if(i == 7) break outer;
				System.out.println(i + " " + j);
			}
		}
		int[] arr = {1,2};
		// System.out.println(arr[2]);//error ngay
		float[] value = new float[10];//khai báo số lượng phần tử cho primitive array type thì phải như này
		//còn float[] chỉ là báo hiệu type mảng float

		Scanner arrayNonPrimitive[] = {new Scanner(System.in), new Scanner(System.in)};
		//gọi scanner.close() trong 1 hàm con nào đó k tốt có thể lỗi, khi nào nó báo cần close ms dùng thôi

		JOptionPane.showConfirmDialog(null, 
				"Do you want to change to the first class ticket?",
				"",JOptionPane.YES_NO_OPTION);
		Integer sum = 10;
		System.out.println(Double.valueOf(sum)/4);//cast như này mới ra float number

		System.exit(0);
	}
}