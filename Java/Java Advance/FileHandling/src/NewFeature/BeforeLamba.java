package NewFeature;
import java.awt.*;  
import java.awt.event.*;  

// awt trong java

public class BeforeLamba {
    public static void main(String[] args) {  
        Frame frame = new Frame("ActionListener Before Java8");//tiêu đề của dialog
    
        Button b = new Button("Click Here");  
        b.setBounds(50, 100, 80, 50);//x, y, width, height

        //addActionListener bắt sự kiện ấn nhận ActionListener là 1 class có 2 hàm số actionPerformed là hàm 
        //được gọi khi có sự kiện xảy ra, nhận vào hàm số sự kiện và làm gì
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                System.out.println("Hello World!"); 
                System.out.println(e);
                frame.setVisible(false);//click thì ẩn nó đi
            }  
        });  
        frame.add(b);//thêm button vào dialog
    
        frame.setSize(500, 300);  
        frame.setLayout(null);//phải có layout, nếu k button sẽ chiếm toàn bộ
        frame.setVisible(true);   
    }  
}