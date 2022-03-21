package MyUtils;

public class ListNodeUtils {
    public static ListNode buildSingleListNode(int[] arr){
        if (arr.length < 1) return null;
        ListNode root = new ListNode(arr[0]);
        ListNode cur = root;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }
        return root;
    }

    public static void forEach(ListNode node){
        if (node == null) return;
        ListNode cur = node;
        while (cur != null){
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }
    }

}
