package ThreadClass;

// # Thread

// Custom Thread. Nhưng điều đặc biệt là có 2 cách dùng: 1 là truyền cho Thread biến class Runnable có hàm run và nó
// sẽ tự chạy hàm run đó trong Runnable. 2 là chạy 1 thread mà trong class của Thread đó có sẵn hàm run rồi thì k cần dùng
// Runnable

public class MyThread extends Thread{
    // kế thừa là tạo được đa luồng. Những gì trong hàm override run sẽ thực thi khi luồng bắt đầu chạy
    @Override
    public void run(){
        super.run();
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread().getName(): cho chúng ta biết tên luồng đang chạy dưới dạng bất đồng bộ,
            // ta kb luồng nào chạy trước, sau tùy thuộc vào hệ điều hành, mỗi lần chạy thì kết quả có thể khác nhau
            System.out.println(Thread.currentThread().getName()); // currentThread lấy thread đang chạy hàm này
        }
    }
    public static void main(String[] args) {   
        MyThread myThread0 = new MyThread();
        myThread0.start();  // kích hoạt luồng chạy hàm run bất đồng bộ. Ở đây chỉ in tên luồng
        
        MyThread myThread1 = new MyThread();
        myThread1.start();
        
        MyThread myThread2 = new MyThread();
        myThread2.setName("Luong 2"); // thay đổi tên luồng thành Luồng 2
        myThread2.start();
    }
}
