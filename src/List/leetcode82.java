package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode82 {
    public static void main(String[] args) {

    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        ListNode next;

        while (cur != null && cur.next != null){

            if (cur.next != null && cur.val == cur.next.val){
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
