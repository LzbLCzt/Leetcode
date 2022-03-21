package dfs2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

    }
}
