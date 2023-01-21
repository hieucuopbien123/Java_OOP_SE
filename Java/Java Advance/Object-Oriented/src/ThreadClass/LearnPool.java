package ThreadClass;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

// Thread

// Dùng ThreadPool và ArrayBlockingQueue: cũng chỉ là 1 cách quản lý nhiều Thread tốt hơn

public class LearnPool implements Runnable {
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
    public LearnPool(int id) {
        this.id = id;
    }
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> hangDoi = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 1, TimeUnit.SECONDS, hangDoi);
        // params 1 là corePoolSize là số lượng Thread mặc định trong pool. Ở đây là 5
        // Nếu số lượng thread vượt quá 5 nói ở trên sẽ đưa vào hàng đợi là đối số 5
        // Nếu số lượng hàng đợi full, ở đây là 100 thì bắt đầu tạo thêm thread mới. Số lượng thread mới tạo ra
        // k được vượt quá params 2 là maxPoolSize là 15. Nếu quá mốc đó và hàng đợi cũng đầy thi request bị
        // từ chối => Tức là trong đk bth thì số lượng thread được sử dụng là 5, nhưng nếu server quá tải thì 
        // vẫn có thể handle lên tới 15 request. Nếu hàng đợi chưa full tức là ta chưa bị quá tải
        // 3 là keepAliveTime là thời gian 1 thread rảnh có thể sống, 3 là đơn vị của keepAliveTime. ở đây
        // 1 thread bất kỳ trong pool mà có lúc rảnh rỗi quá 1s thì sẽ bị hủy
        // Điều hay nx là ta dùng ArrayBlockingQueue có sẵn của Java để làm hàng đợi các Runnable

        // Java có ExecutorService làm hộ ta công đoạn thêm ArrayBlockingQueue nhưng vẫn có cái trên để dev có thể
        // custom arrayblockingqueue theo ý mình

        // 10 thread đến dồn dập 1 lúc
        for (int i = 1; i <= 10; i++) {
            // Trong phương thức execute() thì đối số truyền vào buộc phải là một Runnable
            // đó là lý do mà lớp LearnPool phải implements từ interface Runnable
            threadPoolExecutor.execute(new LearnPool(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        scanner.close();
        threadPoolExecutor.shutdown(); // Không cho threadpool nhận thêm nhiệm vụ nào nữa. Nếu k có cái này thì 
        // nó luôn trong trạng thái chờ nhiệm vụ tiếp theo nên chương trình sẽ k kết thúc. Nếu gọi nó chờ xong nốt phần task
        // còn lại r tự động shutdown
        while (!threadPoolExecutor.isTerminated()) {
            System.out.println("Waiting...");
        }
        System.out.println("End");
    }
}