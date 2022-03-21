package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode155 {
    public static void main(String[] args) {
        
    }
}

class MinStack {

    Deque<Integer> stackA;
    Deque<Integer> stackB;

    public MinStack() {
        stackA = new ArrayDeque<>();
        stackB = new ArrayDeque<>();
    }

    public void push(int val) {
        stackA.offerFirst(val);
        if (stackB.isEmpty() || val <= stackB.peekFirst()){
            stackB.offerFirst(val);
        }
    }

    public void pop() {
        if (stackA.isEmpty()){
            return;
        }
        int ele = stackA.pollFirst();
        if (!stackB.isEmpty() && ele <= stackB.peekFirst()){
            stackB.pollFirst();
        }
    }

    public int top() {
        return stackA.isEmpty()? -1: stackA.peekFirst();
    }

    public int getMin() {
        return stackB.isEmpty()? -1: stackB.peekFirst();
    }
}