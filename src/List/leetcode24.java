package List;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode24 {
    public static void main(String[] args) {

    }
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;

        while (temp.next != null && temp.next.next != null){
            ListNode n1 = temp.next;
            ListNode n2 = temp.next.next;
            temp.next = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            temp = n1;
        }
        return newHead.next;
    }
}
