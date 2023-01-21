package ThreadClass;

// Thread

// Dùng wait và notify để đánh thức 1 thread đang sleep. Chú ý hàm gọi wait phải có synchronized
public class Synchronous {
	private int taiKhoan = 10000;
	public Synchronous() {
		System.out.println("So du = " + taiKhoan);
	}

	private synchronized void rutTien (int soTienRut) {
		System.out.println("Dang thuc hien giao dich rut " + soTienRut);
		if(taiKhoan < soTienRut) {
			System.out.println("Not enough money, waiting for notify function call");
			try {
				wait(); // Phương thức wait sẽ đưa Thread rơi vào trạng thái sleeping. Và chỉ đánh thức được khi 
                // 1 thread nào đó khác gọi hàm notify. Khi gọi notify nó mặc định là chạy tiếp xuống dưới chứ 
                // éo check j nx nên ở TH này dùng chưa tốt. Dùng while sẽ tốt hơn
            } catch (InterruptedException ie) {//bắt lỗi
                System.out.println(ie.toString());
            }
		}
		taiKhoan -= soTienRut;
		System.out.println("Rut tien thanh cong. So tien hien tai la = " + taiKhoan);
	}

	private synchronized void nopTien(int soTienNop) {
		System.out.println("Nap tien vao: " + soTienNop);
		taiKhoan += soTienNop;
		System.out.println("Nap thanh cong. H có " + taiKhoan + ". Let's call notify");
		notify();
	}
	public static void main(String[] args) {
		final Synchronous customer = new Synchronous();
        // final trong biến mang ý nghĩa là hằng số
		
		Thread t1 = new Thread(){ // Khai báo nhanh thread với run bị override
			public void run() {
				customer.rutTien(20000);
			}
		};
		t1.start();

		Thread t2 = new Thread(){
			public void run() {
				customer.nopTien(30000);
            }
		};
		t2.start();
	} // Chương trình sẽ k kết thúc khi 1 thread nào đó của Ct còn chạy
	
}