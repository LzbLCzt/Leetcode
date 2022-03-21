package dfs2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode543 {
    public static void main(String[] args) {

    }

    int ans;    //统计节点个数
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans - 1;
    }

    private int dfs(TreeNode node) {
        if (node == null){
            return 0;
        }
        int lSon = dfs(node.left);
        int rSon = dfs(node.right);
        ans = Math.max(ans, lSon + rSon + 1);

        return 1 + Math.max(lSon, rSon);
    }
}
