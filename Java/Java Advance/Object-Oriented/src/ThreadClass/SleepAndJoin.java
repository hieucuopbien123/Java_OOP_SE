package ThreadClass;

// Thread

public class SleepAndJoin extends Thread {
    public void run() {
        super.run();
        System.out.println("Start thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // milisec
            Thread.sleep(1000, 999999); // milisec + nanosec(trong khoảng 0-999999)
            // Các hàm như wait, sleep, join nó yêu cầu buộc dung trong try catch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End thread " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        SleepAndJoin thread = new SleepAndJoin();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // dùng join để đảm bảo trong 1 lúc chỉ có mình thread đó được chạy. VD: thread1 và thread0 cùng cho start
        // chạy được 1 lúc cho thread1.join() -> mọi thread khác kể cả thread0 nếu chưa xong thì sẽ dừng lại để
        // thread1 thực hiện xong thì chúng mới thực hiện tiếp

        SleepAndJoin thread2 = new SleepAndJoin();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Người ta còn dùng Thread sleep để thực hiện liên tiếp 1 chuỗi hành động hiển thị tự động cho người dùng
    }
}
