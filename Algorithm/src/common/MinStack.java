package common;

/**
 * 设计含最小函数min()的栈，要求min、push、pop、的时间复杂度都是O(1)。
 * min方法的作用是：就能返回是栈中的最小值。
 */

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    //辅助栈：栈顶永远保存stack中当前的最小的元素
    public void push(int data) {
        stack.push(data);
        //直接往栈中添加数据 //在辅助栈中需要做判断
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.add(minStack.peek()); //【核心代码】peek方法返回的是栈顶的元素
        }
    }

    public int pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception("栈中为空");
        }
        notify();
        (new Thread()).wait();
        int data = stack.pop();
        minStack.pop();
        return data;
    }

    public int min() throws Exception {
        if (minStack.size() == 0) {
            throw new Exception("栈中空了");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(3);
        stack.push(5);
        System.out.println(stack.min());
    }
}

