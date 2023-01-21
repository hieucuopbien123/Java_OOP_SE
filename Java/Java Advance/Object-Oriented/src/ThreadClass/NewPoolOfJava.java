package ThreadClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Trong LearnPool nó chi tiết quá, Java đã làm sẵn ExecuterService xử lý hết mà ta kp làm lâu như v nx
public class NewPoolOfJava implements Runnable {
    int id;

    @Override
    public void run() {
        System.out.println("Dang xu ly tien trình " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Da xu ly tien trình " + id);
    }
    public NewPoolOfJava(int id) {
        this.id = id;
    }
    public static void main(String[] args) {
        // Triển khai ExecutorService chính là thực hiện ThreadPool
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.submit(new NewPoolOfJava(i)); // Là chay ThreadPool, đối số là Runnable
        }
        // Java cung cho ta lớp Executors xử lý và interface của nó là ExecutorService mà ta dùng như trên
        // Ta có thể tạo ThreadPool và add task vào ez như trên:
        // newFixedThreadPool(5) là 5 thread mặc định, cơ chế như ThreadPoolExecutor dùng Blocking Queue đó
        // newSingleThreadExecutor là ThreadPool chỉ có 1 Thread và các task làm tuần tự, vẫn độc lập với main thread
        // newCachedThreadPool tức trong ThreadPool có nhiều Thread và task xử lý song song. Các Thread cũ xử lý
        // xong sẽ dùng lại cho nhiệm vụ mới. Default 1 thread k dùng trong 60s thì Thread đó sẽ bị tắt
        // newScheduledThreadPool tương tự newCachedThreadPool nhưng có thời gian delay giữa các Thread
        // newSingleThreadScheduledExecutor tương tự newSingleThreadExecutor nhưng có delay giữa các Thread
        
        try {
            pool.awaitTermination(5, TimeUnit.SECONDS); // chỉ khi ta cần chờ nó xong
            // set thời gian sống của mỗi Thread là 1 ngày (nếu nó chưa thực thi xong)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }       
        
        pool.shutdown(); // JVM k tự làm điều này nên ta làm
    }
}
