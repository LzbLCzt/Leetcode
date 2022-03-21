package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode1721 {
    public static void main(String[] args) {

    }

    //方法一：计算出链表长度后，找到正数、倒数两个节点再交换
    public ListNode swapNodes1(ListNode head, int k) {
        if(head == null || k < 1) return head;

        int n = size(head);
        if(k > n) return null;

        ListNode front = head;
        for (int i = 1; i < k; i++){
            front = front.next;
        }

        ListNode back = head;
        for (int i = 0; i < n-k; i++){
            back = back.next;
        }

        int tempVal = front.val;
        front.val = back.val;
        back.val = tempVal;

        return head;
    }

    private int size(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    //方法二：
    public ListNode swapNodes(ListNode head, int k) {
        // 模拟指针，用来遍历链表
        ListNode cur = head;
        // 用来定位正数第k个节点
        ListNode first = head;
        // 用来定位倒数第k个节点
        ListNode last = head;
        // 用于节点的计数，和节点值的交换
        int count = 1;
        while (cur.next != null) {
            // 找到正数第k个节点
            if (count < k) {
                first = first.next;
                // 找到倒数第k个节点
            } else {
                last = last.next;
            }
            count++;
            cur = cur.next;
        }
        // 交换正数第k个节点和倒数第k个节点的值
        count = first.val;
        first.val = last.val;
        last.val = count;
        return head;
    }


    public ListNode swapNodes5(ListNode head, int k) {
        if(head == null) return null;

        ListNode cur = head;
        ListNode first = head;
        ListNode last = head;
        int count = 1;  //记录走多少次找到正数第k个数

        while (cur.next != null){
            if(count < k) {
                count++;
                first = first.next;
            }else last = last.next;

            cur = cur.next;
        }

        int temp = first.val;
        first.val = last.val;
        last.val = temp;

        return head;
    }
}
