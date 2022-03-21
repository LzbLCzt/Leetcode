package List2;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode234 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode midNode = getMidNode(head);    //找到前半部分的最后一个node
        reverse(midNode);
        ListNode p1 = head;
        ListNode p2 = midNode.next;
        boolean flag = true;
        while (flag && p2 != null){
            if (p1.val != p2.val){
                flag = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverse(midNode);
        return flag;
    }

    private void reverse(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head.next;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;
        }
        head.next = dummyHead.next;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
