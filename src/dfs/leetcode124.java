package dfs;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode124 {
    public static void main(String[] args) {

    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null){
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int curMaxSum = node.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, curMaxSum);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftSum, rightSum);
    }
}
