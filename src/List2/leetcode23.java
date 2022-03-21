package List2;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode23 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        else if (left == right) return lists[left];
        int mid = (left + right) >> 1;
        return merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode, t1 = head1, t2 = head2;
        while (t1 != null && t2 != null){
            if (t1.val <= t2.val){
                cur.next = t1;
                t1 = t1.next;
            }else {
                cur.next = t2;
                t2 = t2.next;
            }
            cur = cur.next;
        }
        if (t1 != null) cur.next = t1;
        else cur.next = t2;
        return dummyNode.next;
    }
}
