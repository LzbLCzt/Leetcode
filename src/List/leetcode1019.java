package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode1019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        leetcode1019 leetcode1019 = new leetcode1019();
        int[] arr = leetcode1019.nextLargerNodes(head);
        System.out.println(Arrays.toString(arr));
    }

    //暴力法：时间：O(n^2), 空间：O(n)
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return null;

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        ListNode temp;
        while (cur.next != null){
            temp = cur.next;
            while (true){
                if(temp == null){
                    list.add(0);
                    break;
                }
                if(temp.val > cur.val){
                    list.add(temp.val);
                    break;
                }
                temp = temp.next;
            }

            cur = cur.next;
        }
        list.add(0);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
