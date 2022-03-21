package Tree;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode101 {
    public static void main(String[] args) {

    }

    ///方法一（自己）：
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode x, TreeNode y) {
        if (x == null && y == null){
            return true;
        }else if (x == null || y == null){
            return false;
        }

        if (x.val != y.val){
            return false;
        }

        return dfs(x.left, y.right) && dfs(x.right, y.left);
    }
}
