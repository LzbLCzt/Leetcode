package List;

import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode445 {
    public static void main(String[] args) {
        System.out.println(10 / 10);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode t1 = l1;
        ListNode t2 = l2;
        while (t1 != null){
            stack1.push(t1.val);
            t1 = t1.next;
        }
        while (t2 != null){
            stack2.push(t2.val);
            t2 = t2.next;
        }

        int flag = 0;   //用于处理进位的问题***
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0){    //这个flag ！= 0***
            int a = (stack1.isEmpty())? 0: stack1.pop();
            int b = (stack2.isEmpty())? 0: stack2.pop();

            int curVal = a + b + flag;
            flag = curVal / 10;
            curVal %= 10;
            ListNode curNode = new ListNode(curVal);
            curNode.next = ans;
            ans = curNode;
        }

        return ans;
    }

}
