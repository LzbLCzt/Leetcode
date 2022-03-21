package List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode6272 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(1);

        leetcode6272 leetcode6272 = new leetcode6272();
        ListNode ans = leetcode6272.addTwoNumbers(l1, l2);
        while (ans != null){
            System.out.println(ans);
            ans = ans.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        int flag = 0;
        resHead.next = calculate(resHead, 0, l1,l2);
        return resHead.next;
    }

    private ListNode calculate(ListNode pre, int flag, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && flag == 0){
            return null;
        }
        int v1 = l1 == null? 0: l1.val;
        int v2 = l2 == null? 0: l2.val;
        int curVal = 0;
        if (v1 + v2 + flag >= 10){
            curVal = (v1 + v2 + flag) % 10;
            flag = 1;
        }else {
            curVal = v1 + v2 + flag;
            flag = 0;
        }
        ListNode cur = new ListNode(curVal);
        cur.next = calculate(cur,flag,l1==null?l1:l1.next, l2==null?l2:l2.next);
        return cur;
    }
}
