package ThreadClass;

// Thread

// Share biến nhưng tự động xử lý conflict k cần lo 2 Thread truy cập vào 1 biến cho ra kết quả sai
// Share var đơn giản bằng cách cho nhiều Thread chạy cùng 1 Runnable

// Cái này nó giống như cái countDown, ta cần thêm synchronized cho nó vì sharevar update có thể bị sai
// 1) Nếu ta muốn bất đồng bộ được tối ưu vì synchronized khiến cả 1 hàm k được gọi bởi các thread khác nhưng thực
// chất ta chỉ muốn điều này xảy ra với biến shareVariable thì nên tách vc += 2 thành 1 hàm riêng và thêm synchronized
// cho hàm đó là đc
// 2) Vc dùng sysout và i nhỏ và shareVariable += 2 trực tiếp như dưới khiến cho bất đồng bộ bị sai khó xảy ra hơn. VD:
// nếu ta truy cập shareVar trực tiếp và update như v có thể với i < 1000 thì kết quả sẽ cho ra luôn đúng vì câu lệnh
// đó đc chạy rất nhanh tức thời gian update rất ngắn nên xác suất các thread khác nhảy vào lúc thread này đang chạy
// càng thấp. Nhưng nếu ta tách câu lệnh đó ra 1 hàm riêng thì gần như lần nào cũng ra kết quả update sai vì câu lệnh đươc
// thực hiện lâu hơn, mỗi lần thực hiện nó phải refer đến địa chỉ hàm ở 1 nơi khác trong bộ nhớ. Nên lúc refer thì 1 thread
// khác kịp chen vào và update shareVariable làm nó ra kq sai => dù sao cx k qtr đến vc xử lý, nếu ta để i tầm 10000 thì
// gần như update sẽ luôn ra sai

public class SharedThread implements Runnable {
    private int shareVariable = 0; // Dùng chung thuộc tính giữa các luồng
    public int getShareVariable() {
        return shareVariable;
    }

    public synchronized void tangCount(){
        shareVariable += 2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("ID:" + Thread.currentThread().getId() + 
                    ", Name: " + Thread.currentThread().getName()
                    + ", shareVariable = " + shareVariable);
            shareVariable += 2;
            // tangCount();
        }
    }

    public static void main(String[] args){
        SharedThread sharedThread = new SharedThread();
        Thread thread0 = new Thread(sharedThread);
        thread0.setName("Luong 1");
        thread0.start();

        Thread thread1 = new Thread(sharedThread);
        thread1.setName("Luong 2");
        thread1.start();

        // 2 thread chạy xong mới cho dùng ở đây
        try {
            thread0.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Gia tri thuoc tinh shareVariable = " + sharedThread.getShareVariable());
    }
}