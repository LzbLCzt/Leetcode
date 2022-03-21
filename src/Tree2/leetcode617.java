package Tree2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode617 {
    public static void main(String[] args) {
        
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;
    }

}
