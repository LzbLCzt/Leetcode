package Tree;

import MyUtils.TreeNode;
import MyUtils.TreeNodeUtils;

import java.util.Arrays;

public class leetcode106 {
    public static void main(String[] args) {
        leetcode106 leetcode106 = new leetcode106();
        int[] arr = {0, 1, 2};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,0)));
        TreeNode root = leetcode106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeNodeUtils.preOrder(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length < 1) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]){
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));

            }
        }
        return root;
    }


}
