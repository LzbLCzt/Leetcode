package List2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode141 {
    public static void main(String[] args) {
        leetcode141 leetcode141 = new leetcode141();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        boolean res = leetcode141.hasCycle(head);
        System.out.println(res);
    }

    public boolean hasCycle(ListNode head) {
       if (head == null) return false;
       ListNode fast = head.next, slow = head;
       while (fast != slow){
           if (fast == null || fast.next == null) return false;
           fast = fast.next.next;
           slow = slow.next;
       }
       return true;
    }
}
