package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode725 {
    public static void main(String[] args) {

    }

    //时间复杂度：O(N + k)O(N+k)。NN 指的是链表的结点数，若 kk 很大，则还需要添加许多空列表。
    //空间复杂度：O(max(N, k))O(max(N,k))，存放答案所需的空间。
    public ListNode[] splitListToParts(ListNode root, int k) {
        //先计算root链表大小
        ListNode cur = root;
        int N = 0;
        while (cur != null){
            ++N;
            cur = cur.next;
        }
        ListNode[] ans = new ListNode[k];

        int width = N / k, rem = N % k;
        cur = root;
        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(0), write = head;  //head对应i的链表表头，write用于遍历

            //***注意：如果N < k，则width = 0，所以当i >= rem的时候，就不会进入下面的for循环，因此数组默认就是null；
            for(int j = 0; j < width + (i < rem? 1: 0); ++j){   //***i小于rem的部分相当于余数，应当比平均多一个元素
                write.next = new ListNode(cur.val);
                write = write.next;
                if(cur != null) cur = cur.next;
            }

            ans[i] = head.next;
        }

        return ans;
    }

}
