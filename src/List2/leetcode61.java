package List2;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode61 {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
       if (head == null){
           return head;
       }

       ListNode cur,next,tail;
       tail = head;
       int len = 1;
       while (tail.next != null){
           len++;
           tail = tail.next;
       }

       if (k % len == 0){
           return head;
       }
       int steps = len - k % len - 1;

       cur = head;
       while (steps != 0){
           steps--;
           cur = cur.next;
       }
       next = cur.next;
       cur.next = null;
       tail.next = head;

       return next;
    }

}
