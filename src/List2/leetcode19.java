package List2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode19 {
    public static void main(String[] args) {
        
    }

    //方法一：双指针 + 虚拟头节点
    //时间:O(N), 空间：O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p2 = dummyHead;
        ListNode p1 = dummyHead;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        if (p1 == null) {
            return null;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2.next != null) {
            p2.next = p2.next.next;
        }
        return dummyHead.next;
    }
}
