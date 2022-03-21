package dfs2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode236 {
    public static void main(String[] args) {

    }
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        dfs(root, p, q);
        return res;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean lSon = dfs(node.left, p, q);
        boolean rSon = dfs(node.right, p, q);
        int val = node.val;
        if ((lSon && rSon) || ((val == p.val || val == q.val) && (lSon || rSon))){
            res = node;
        }
        return lSon || rSon || val == p.val || val == q.val;
    }
}


