// Thread

// package ThreadClass;

// public class CountDownLatchTest {
//     private int count = 2000;
//     public void dem() {
//         Thread thread1 = new Thread(new Runnable() {
//             public void run() {
//                 for (int i = 0; i < 1000; i++) {
//                     count--;
//                 }
//             }
//         });
//         Thread thread2 = new Thread(new Runnable() {
//             public void run() {
//                 for (int i = 0; i < 1000; i++) {
//                     count--;
//                 }
//             }
//         });
//         thread1.start();
//         thread2.start();
//         try {
//             thread1.join();
//             thread2.join();
//         } catch (InterruptedException ignored) { }   
//         System.out.println("Count = " + count);
//     }
//     public static void main(String[] args) {
//         CountDownLatchTest demoNonCountDownLatch = new CountDownLatchTest();
//         demoNonCountDownLatch.dem();
//     }
// }

// package ThreadClass;
// import java.util.concurrent.CountDownLatch;

// public class CountDownLatchTest {
//     public CountDownLatch count = new CountDownLatch(2000);
//     //khởi tạo 1 CountDownLatch đếm ngược từ 2000. Dùng .countDown() để giảm. Còn count.await() sẽ đợi
//     //cho count về 0 r ms cho đi tiếp. Nó chỉ cho đi tiếp nếu: count về 0 do hàm countDown hoặc có 1 tiến trình 
//     //gì đó ngắt cái tiến trình hiện tại. CountDownLatch có sẵn của Java. Cũng chỉ là -- thêm synchornized
//     public void doWork() {
//         Thread thread1 = new Thread(new Runnable() {
//             public void run() {
//                 for (int i = 0; i < 1000; i++) {
//                     count.countDown();  // giảm giá trị của biến count đi 1
//                 }
//             }
//         });
//         Thread thread2 = new Thread(new Runnable() {
//             public void run() {
//                 for (int i = 0; i < 1000; i++) {
//                     count.countDown();
//                 }
//             }
//         });
//         thread1.start();
//         thread2.start();
//         try {
//             count.await();
//         } catch (InterruptedException ignored) { }
//         System.out.println("Count = " + count.getCount());
//     }
//     public static void main(String[] args) {
//         CountDownLatchTest demo = new CountDownLatchTest();
//         demo.doWork();
//     }
// }

//dùng synchronized
package ThreadClass;

public class CountDownLatchTest {
    private int count = 2000;
    private synchronized void giamCount(){
        count--;
    }
    //từ khóa synchronized dùng trong 1 khối(ở đây là 1 hàm) sẽ đảm bảo khối đó chỉ được truy xuất bởi 1 luồng
    //Dùng như này đảm bảo các biến số trong hàm đó chỉ bị truy xuất bởi 1 thread nên tránh được lỗi thay đổi 
    //cùng lúc ở trên. Khi 1 thread muốn gọi 1 hàm synchronized mà hàm đó có thread khác truy cập tới r thì nó chờ
    //cho thread trước gọi xong nó mới đi tiếp
    public void dem() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    giamCount();
                }
            }
        });
        // Vc new Runnable () {} là tạo 1 instance của class Runnable. Mọi thứ viết trong {} là những thứ sẽ override
        // các thứ đã có or thêm vào các thứ mới vào trong class Runnable được định nghĩa từ trươc
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    giamCount();
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();//join thì thread gọi thread này sẽ chờ thread này kết thúc r mới tiếp tục
            thread2.join();
        } catch (InterruptedException ignored) { }   
        System.out.println("Count = " + count);
    }
    public static void main(String[] args) {
        CountDownLatchTest demoNonCountDownLatch = new CountDownLatchTest();
        demoNonCountDownLatch.dem();
    }
}