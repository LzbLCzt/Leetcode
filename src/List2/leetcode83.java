package List2;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
       if (head == null || head.next == null){
           return head;
       }

       ListNode cur = head;
       ListNode next;
       while (cur != null && cur.next != null){
           next = cur.next;
           if (cur.val == next.val){
               while (next != null && cur.val == next.val){
                   cur.next = next.next;
                   next = cur.next;
               }
           }
           cur = cur.next;
       }

       return head;
    }
}
