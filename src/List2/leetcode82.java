package List2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode82 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(5);
        leetcode82 leetcode82 = new leetcode82();
        ListNode result = leetcode82.deleteDuplicates(root);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    //虚拟表头、
    public ListNode deleteDuplicates(ListNode head) {
         if (head == null || head.next == null){
             return head;
         }

         ListNode dummyHead = new ListNode(0);
         dummyHead.next = head;
         ListNode pre = dummyHead;
         ListNode cur = head;
         while (cur != null && cur.next != null){
             if (cur.val == cur.next.val){
                 while (cur.next != null && cur.val == cur.next.val){
                     cur = cur.next;
                 }
                 cur = cur.next;
                 pre.next = cur;
             }else {
                 pre = cur;
                 cur = cur.next;
             }
         }
         return dummyHead.next;
    }

}
