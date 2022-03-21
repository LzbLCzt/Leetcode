package Other;

/**
 * @author shkstart
 * @create 2021-03-12 21:08
 */
public class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }


 @Override
 public String toString() {
  return "ListNode{" +
          "val=" + val +
          '}';
 }
 }

