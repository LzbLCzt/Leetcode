package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode237 {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode next = node;

        while (next != null){
            cur.val = next.val;
            if(next.next == null) {
                cur.next = null;
                break;
            }
            cur = next;
            next = next;
        }
    }

}
