package Tree;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode104 {
    public static void main(String[] args) {
        
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
