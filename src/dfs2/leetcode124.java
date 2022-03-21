package dfs2;

import MyUtils.TreeNodeUtils;
import MyUtils.TreeNode;
/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode124 {
    public static void main(String[] args) {
        leetcode124 leetcode124 = new leetcode124();
        TreeNode root = TreeNodeUtils.arrayToTreeNode(new Integer[]{-10, 9, 20, null, null, 15, 7});
        int res = leetcode124.maxPathSum(root);
        System.out.println(res);
    }

    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftVal = dfs(node.left);
        int rightVal = dfs(node.right);
        int rootVal = Math.max(node.val, Math.max(node.val + leftVal, node.val + rightVal));
        res = Math.max(res,Math.max(rootVal, node.val + leftVal + rightVal));
        return rootVal;
    }

}
