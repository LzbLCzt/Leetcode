package List2;

import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode445 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        leetcode445 leetcode445 = new leetcode445();
        ListNode ans = leetcode445.addTwoNumbers(l1, l2);

        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode t1 = l1;
       ListNode t2 = l2;
       LinkedList<Integer> s1 = new LinkedList<>();
       LinkedList<Integer> s2 = new LinkedList<>();
        while (t1 != null) {
            s1.offerFirst(t1.val);
            t1 = t1.next;
        }
        while (t2 != null) {
            s2.offerFirst(t2.val);
            t2 = t2.next;
        }
        ListNode head = null;
        ListNode tail = null;
        int remain = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty()? 0: s1.pollFirst();
            int b = s2.isEmpty()? 0: s2.pollFirst();
            int sum = a + b + remain;
            if (head == null) {
                head = new ListNode(sum % 10);
            }else {
                ListNode temp = new ListNode(sum % 10);
                temp.next = head;
                head = temp;

            }
            remain = sum / 10;
        }
        if (remain == 1) {
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }

}
