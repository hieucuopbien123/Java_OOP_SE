package hust.soict.globalict.lab02;

public class Ex7 {
	public static void main(String[] args) {
		int a[][]={{1,3,4},{2,4,3},{3,4,5}};    
		int b[][]={{1,3,4},{2,4,3},{1,2,4}};
		System.out.println("Result: ");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] += b[i][j];
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
