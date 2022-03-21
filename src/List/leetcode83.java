package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode resNode = head;
        ListNode cur = head;
        ListNode tempNode = head;

        while (tempNode != null){
            while (tempNode.next != null && tempNode.val == tempNode.next.val){
                tempNode = tempNode.next;
            }

            tempNode = tempNode.next;
            cur.next = tempNode;
            cur = tempNode;
        }

        return resNode;
    }
}
