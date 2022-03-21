package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode61 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
       if (head == null) return null;

       //先计算链表长度
        ListNode tail = head;
        int len = 1;
        while (tail.next != null){
            len++;
            tail = tail.next;
        }
        //如果 k % len = 0，说明不需要移动任何指针
        if (k % len == 0){
            return head;
        }
        //计算cur需要走的步数
        int step = len - k % len - 1;

        //移动cur
       ListNode cur = head;
       while (step != 0){
           cur = cur.next;
       }
        ListNode next = cur.next;

       cur.next = null;
       tail.next = head;
       return next;
    }

}
