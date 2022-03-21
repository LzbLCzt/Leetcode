package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode86 {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x){
        if(head == null) return null;

        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small  = smallHead;
        ListNode big = bigHead;
        ListNode cur = head;

        while (cur != null){
            if(cur.val < x){
                small.next = cur;
                small = small.next;
            }else{
                big.next = cur;
                big = big.next;
            }
            cur = cur.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }


}
