package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode1880 {
    public static void main(String[] args) {

    }

    //方法一：自己写的
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;

        ListNode newHead = new ListNode(0);
        ListNode res = newHead;
        newHead.next = head;
        ListNode front = head;  //待交换节点的第一个节点
        ListNode back = head.next;   //待交换节点的第二个节点

        while (newHead.next != null && newHead.next.next != null){
            newHead.next = back;
            front.next = back.next;
            back.next = front;

            newHead = front;
            if(front.next == null) break;
            front = newHead.next;
            back = front.next;
        }

        return res.next;
    }

    //方法三：递推：对方法一的优化,时间空间一致，只是代码量少一些
    public ListNode swapPairs3(ListNode head) {
        if(head == null) return null;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;

        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next; //将待交换的两个节点定义在while里面
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return newHead.next;
    }

    //方法二：递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = head.next;
        head.next = swapPairs2(newNode.next);
        newNode.next = head;
        return newNode;
    }

}
