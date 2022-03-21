package dfs2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode538 {
    public static void main(String[] args) {

    }

//    public TreeNode convertBST(TreeNode root) {
//
//    }

    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null){
            return;
        }
        dfs(node.right);

        int temp = node.val;
        node.val += sum;
        sum += temp;

        dfs(node.left);
    }
}
