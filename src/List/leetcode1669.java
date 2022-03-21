package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode1669 {
    public static void main(String[] args) {

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list1;
        ListNode t3 = list2;

        for(int i = 1; i < a; i++) t1 = t1.next;
        for(int i = 0; i <= b; i++) t2 = t2.next;

        t1.next = list2;
        while (t3.next != null) t3 = t3.next;
        t3.next = t2;

        return list1;
    }
}
