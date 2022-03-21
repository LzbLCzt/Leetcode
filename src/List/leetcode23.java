package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode23 {
    public static void main(String[] args) {

    }

    //分治思想，时间：O(kn×logk)， 空间：O(logk)
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];
        if(left > right) return null;

        int mid = (left + right) >> 1;
        return merge(mergeLists(lists, left, mid), mergeLists(lists, mid+1, right));
    }

    //合并两个链表
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head1 = left;
        ListNode head2 = right;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (head1 != null && head2 != null){
            if(head1.val <= head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        while (head1 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }
        while (head2 != null) {
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }

        return dummyHead.next;
    }

}
