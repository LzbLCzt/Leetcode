package List2;

import MyUtils.ListNodeUtils;
import MyUtils.ListNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode148 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,5,3,4,0};
//        int[] arr = new int[]{4,2,1,3};
        ListNode root = ListNodeUtils.buildSingleListNode(arr);

        leetcode148 leetcode148 = new leetcode148();
        ListNode newRoot = leetcode148.sortList(root);
        ListNodeUtils.forEach(newRoot);
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            fast = fast.next;
            slow = slow.next;
            if (fast != null) fast = fast.next;
        }
        ListNode head1 = sortList(head, slow);
        ListNode head2 = sortList(slow, fast);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode first = head1, second = head2, cur = dummyHead;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first != null) cur.next = first;
        else cur.next = second;
        return dummyHead.next;
    }



}
