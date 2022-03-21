package List;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode142 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    //暴力
//    public ListNode detectCycle(ListNode head) {
//        if(head == null) return null;
//
//        HashMap<ListNode, Integer> map = new HashMap<>();
//        ListNode temp = head;
//        while (temp != null){
//            if(map.get(temp) != null) return temp;
//            map.put(temp, 1);
//            temp = temp.next;
//        }
//        return null;
//    }

    //方法二：
    public ListNode detectCycle(ListNode head)  {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            slow = slow.next;
            //*****将fast的判断条件拆分成两部分，防止空指针
            if (fast.next != null){
                fast = fast.next.next;
            }else { //*****容易忘记
                return null;
            }

            if (slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
