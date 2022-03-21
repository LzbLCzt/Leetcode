package List;

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
        ListNode ans = dummyHead;
        ListNode cur = dummyHead;
        //让cur走k步
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }

        //让ans，cur同时走
        while (cur.next != null){
            cur = cur.next;
            ans = ans.next;
        }
        if (ans.next != null){
            ans.next = ans.next.next;
        }
        return dummyHead.next;
    }
}
