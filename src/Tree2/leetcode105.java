package Tree2;

import myCode.TreeNode;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode105 {
    public static void main(String[] args) {
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if (preorder.length < 1) return null;
       TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]){
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder,i + 1, inorder.length));
            }
        }
        return root;
    }
}
