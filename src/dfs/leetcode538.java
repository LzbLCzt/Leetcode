package dfs;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode538 {
    public static void main(String[] args) {

    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
