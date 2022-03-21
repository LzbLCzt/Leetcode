package List;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode109 {
    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        ListNode midNode = getMedian(left, right);
        TreeNode root = new TreeNode(midNode.val);

        root.left = buildTree(left, midNode);
        root.right = buildTree(midNode.next, right);

        return root;
    }

    private ListNode getMedian(ListNode left, ListNode right) {
        ListNode lNode = left;
        ListNode rNode = left;

        while (rNode.next != null || right.next.next != null){
            lNode = left.next;
            rNode = rNode.next.next;
        }

        return lNode;
    }

}
