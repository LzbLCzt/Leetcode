package dp2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode337 {
    public static void main(String[] args) {

    }


    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node)
    {
        if (node == null) return new int[]{0,0};
        int a = node.val, b = 0;
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        a += (left[1] + right[1]);
        b += Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{a,b};
    }
}
