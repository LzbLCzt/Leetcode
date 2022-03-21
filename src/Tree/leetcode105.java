package Tree;

import myCode.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode105 {
    public static void main(String[] args) {
        
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder.length < 1 || inorder.length < 1) return null;
//
//        int rootVal = preorder[0];
//        TreeNode root = new TreeNode(rootVal);
//        for (int i = 0; i < inorder.length; i++) {
//            if(rootVal == inorder[i]){
//                root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1), Arrays.copyOfRange(inorder,0,i));
//                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder,i+1,inorder.length));
//            }
//        }
//
//        return root;
//    }


    //优化：Map<Integer,Integer> indexMap;  //k,v: inorder数组的值， 数组值对应的下标，利用hashmap，去寻找inorder的下标，提高效率
    Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length < 1 || inorder.length < 1) return null;

        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder) {
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int i = indexMap.get(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1), Arrays.copyOfRange(inorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder,i+1,inorder.length));

        return root;
    }
}
