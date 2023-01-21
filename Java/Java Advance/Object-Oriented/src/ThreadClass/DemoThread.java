package ThreadClass;

// Chả khác gì vd trước chỉ là viết lại class Runnable riêng
public class DemoThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getId() + ":\t" + Thread.currentThread().getName());
        }
        // Thread.currentThread().getId(): lấy id của luồng đang chạy. Nó dùng để phân biệt với các luồng khác cùng
        // tiến trình hoặc cùng tập luồng. Đây là thông số mà máy ảo java tự tạo ra khi ta tạo luồng nên ta không 
        // thể sửa đổi cũng như áp đặt thông số này khi tạo luồng. 
    }
    public static void main(String[] args) {
        DemoThread demoThread0 = new DemoThread();
        Thread thread0 = new Thread(demoThread0);
        thread0.start();
        // Để lấy, phải lấy ra biến kiểu Thread từ biến class implements Runnable
        
        DemoThread demoThread1 = new DemoThread();
        Thread thread1 = new Thread(demoThread1);
        thread1.setName("Luong 1");
        thread1.start();
        
        DemoThread demoThread2 = new DemoThread();
        Thread thread2 = new Thread(demoThread2);
        thread2.start();
    }
}
