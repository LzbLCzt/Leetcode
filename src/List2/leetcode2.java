package List2;



/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode2 {
    public static void main(String[] args) {

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode cur = head;
        ListNode t1 = l1.next;
        ListNode t2 = l2.next;
        int remain = (l1.val + l2.val) / 10;
        while (t1 != null || t2 != null) {
            int a = t1 == null? 0: t1.val;
            int b = t2 == null? 0: t2.val;
            ListNode next = new ListNode((a + b + remain) % 10);
            cur.next = next;
            cur = next;
            remain = (a + b + remain) / 10;
            t1 = t1 == null? t1: t1.next;
            t2 = t2 == null? t2: t2.next;
        }
        if (remain == 1) {
            cur.next = new ListNode(1);
        }

        return head;
    }
}
