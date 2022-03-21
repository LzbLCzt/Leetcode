package Tree;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode226 {
    public static void main(String[] args) {
        
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }



}
