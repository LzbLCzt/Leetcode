package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode160 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode A = headA;
       ListNode B = headB;

       while (A != B){
           A = A == null? headB: A.next;
           B = B == null? headA: B.next;
       }

       return A;
    }

}
