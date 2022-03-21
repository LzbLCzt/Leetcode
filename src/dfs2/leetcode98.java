package dfs2;

import MyUtils.TreeNodeUtils;
import MyUtils.TreeNode;

import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode98 {
    public static void main(String[] args) {
        leetcode98 leetcode98 = new leetcode98();
//        Integer[] arr = new Integer[]{5,1,4,null,null,3,6};
//        Integer[] arr = new Integer[]{2,1,3};
        Integer[] arr = new Integer[]{5,4,6,null,null,3,7};
//        Integer[] arr = new Integer[]{Integer.MAX_VALUE};
        TreeNode root = TreeNodeUtils.arrayToTreeNode(arr);
        TreeNodeUtils.preOrder(root);
        System.out.println(leetcode98.isValidBST(root));
    }

//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean isValidBST(TreeNode root, long min, long max) {
//        if (root == null) return true;
//        if (root.val >= max || root.val <= min) return false;
//        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
//    }

    public boolean isValidBST(TreeNode root) {
        TreeNode tempNode = root;
        TreeNode node;
        TreeNode preNode = null;
        LinkedList<TreeNode> stacks = new LinkedList<>();
        while (tempNode != null || !stacks.isEmpty()){
            while (tempNode != null){
                stacks.addFirst(tempNode);
                tempNode = tempNode.left;
            }
            node = stacks.pollFirst();
            tempNode = node.right;
            if (preNode != null && node.val <= preNode.val){
                return false;
            }
            preNode = node;
        }
        return true;
    }

}
