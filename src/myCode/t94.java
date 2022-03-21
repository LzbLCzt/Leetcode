package myCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
题目：

 算法解析：

 */
public class t94 {
    public static void main(String[] args) {

    }
    //方法一：递归
//    ArrayList<Integer> resList;
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null) return new ArrayList<Integer>();
//
//        resList = new ArrayList<Integer>();
//        dfs(root);
//
//        return resList;
//    }
//
//    private void dfs(TreeNode node) {
//        if(node.left != null) dfs(node.left);
//
//        resList.add(node.val);
//
//        if(node.right != null) dfs(node.right);
//    }

    //方法二：递推
    ArrayList<Integer> resList;
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        resList = new ArrayList<Integer>();
        TreeNode tempNode = root;
        TreeNode node;
        Stack<TreeNode> stack = new Stack();

        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }

            node = stack.pop();
            resList.add(node.val);
            tempNode = node.right;
        }

        return resList;
    }
}