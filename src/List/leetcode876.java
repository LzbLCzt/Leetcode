package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode876 {
    public static void main(String[] args) {

    }
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        if(head.next.next == null) return head.next;
        ListNode resNode = head;
        ListNode tmpNode = head;

        while (true){
            resNode = resNode.next;
            tmpNode = tmpNode.next.next;

            if(tmpNode.next != null && tmpNode.next.next == null){
                resNode = resNode.next;
                break;
            }
            if(tmpNode.next == null || tmpNode.next.next == null) break;
        }

        return resNode;
    }
}
