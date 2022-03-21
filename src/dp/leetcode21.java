package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode21 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode curNode = resNode;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                curNode.next = temp1;
                temp1 = temp1.next;
            }else{
                curNode.next = temp2;
                temp2 = temp2.next;
            }

            curNode = curNode.next;
        }

        while (temp1 != null){
            curNode.next = temp1;
            temp1 = temp1.next;
            curNode = curNode.next;
        }

        while (temp2 != null){
            curNode.next = temp2;
            temp2 = temp2.next;
            curNode = curNode.next;
        }

        return resNode.next;
    }
}
