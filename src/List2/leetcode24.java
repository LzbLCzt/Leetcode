package List2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {
            ListNode t1 = cur.next;
            ListNode t2 = cur.next.next;
            cur.next = t2;
            t1.next = t2.next;
            t2.next = t1;
            cur = t1;
        }

        return dummyHead.next;
    }
}
