package List;
import MyUtils.ListNode;
import MyUtils.ListNodeUtils;

public class leetcode147 {

    public static void main(String[] args) {
        leetcode147 leetcode147 = new leetcode147();
        ListNode root = ListNodeUtils.buildSingleListNode(new int[]{-1, 5, 3, 4, 0});
        ListNode res = leetcode147.insertionSortList(root);
        ListNodeUtils.forEach(res);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

}
