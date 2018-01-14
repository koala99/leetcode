package common;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwoQ4Stack {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(node);
            return;
        }
        if (queue1.isEmpty()) {
            queue2.add(node);
        }
        if (queue2.isEmpty()) {
            queue1.add(node);
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            try {
                throw new Exception("stack is empty");
            } catch (Exception e) {
            }
        }
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return -1;
    }


    public static void main(String[] args) {
        TwoQ4Stack demo =new TwoQ4Stack();
        demo.push(1);
        demo.push(2);
        demo.push(3);
        demo.push(4);
        System.out.print(demo.pop());
        demo.push(5);
        System.out.print(demo.pop());
        System.out.print(demo.pop());
        System.out.print(demo.pop());
        System.out.print(demo.pop());

    }
}
