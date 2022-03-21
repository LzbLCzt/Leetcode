package List;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
       ListNode slow = head;
       ListNode fast = head.next;

       while (slow != fast){

           if(fast == null || fast.next == null) return false;
           fast = fast.next.next;
           slow = slow.next;
       }

       return true;
    }
}
