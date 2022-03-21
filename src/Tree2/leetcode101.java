package Tree2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
