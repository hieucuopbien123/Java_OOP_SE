package testenum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// Collection Framework trong java

public class Test {
    public static void main(String[] args) {
        System.out.println(Thang.JAN.soNgay());//tạo ra 4 instance

        Stack<String> stackStr = new Stack<String>();
        stackStr.push("Hello");
        System.out.println(stackStr.peek());
        System.out.println(stackStr.size());
        System.out.println(stackStr.contains("Hello"));
        stackStr.pop();
        stackStr.clear();

        Queue<String> queueSV = new LinkedList<String>();//LinkedList implement queue luôn
        queueSV.offer("Hello");
        queueSV.offer("World");
        while(true){
            String ten = queueSV.poll();//còn peek thì k xóa
            if(ten == null) break;
            System.out.println(ten);
        }

        //PriorityQueue tự sắp xếp khi offer, Object phải có comparator và kế thừa comparable
        Queue<String> queueSV1 = new PriorityQueue<String>();
        queueSV1.offer("Hello");
        queueSV1.offer("World");
        while(true){
            String ten = queueSV1.poll();
            if(ten == null) break;
            System.out.println(ten);
        }

        //Dequeue
        Deque<String> queueSV2 = new ArrayDeque<String>();
        queueSV2.offer("Hello");
        queueSV2.offer("World");
        queueSV2.offerLast("World1");
        queueSV2.offerFirst("World2");
        while(true){
            String ten = queueSV2.poll();//còn cả pollFirst, pollLast
            if(ten == null) break;
            System.out.println(ten);
        }
    }
}
