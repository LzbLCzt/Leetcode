package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        leetcode328 leetcode328 = new leetcode328();
        leetcode328.oddEvenList(head);
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd  = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    //时间复杂度：O(n)
    //空间复杂度：O(1)

}
