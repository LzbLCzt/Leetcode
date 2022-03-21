package Tree;

import MyUtils.TreeNode;
import MyUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode145 {
    public static void main(String[] args) {
        leetcode145 leetcode145 = new leetcode145();
        TreeNode root = TreeNodeUtils.arrayToTreeNode(new Integer[]{1, null, 2, 3});
        List<Integer> res = leetcode145.postorderTraversal(root);
        System.out.println(res);
    }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root  == null) return new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        TreeNode tempNode = root;
//        TreeNode node;
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        while (tempNode != null || !stack.isEmpty()){
//            while (tempNode != null){
//                stack.addFirst(tempNode);
//                tempNode = tempNode.left;
//            }
//            node = stack.peekFirst();
//            tempNode = node.right;
//            if (tempNode == null){
//                node = stack.pollFirst();
//                res.add(node.val);
//                while (!stack.isEmpty() && stack.peekFirst().right == node){
//                    node = stack.pollFirst();
//                    res.add(node.val);
//                }
//            }
//        }
//        return res;
//    }

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode tmpNode = root;
        TreeNode node;
        Stack<TreeNode> stack = new Stack<>();
        while (tmpNode != null || !stack.isEmpty()){
            while (tmpNode != null){
                stack.push(tmpNode);
                tmpNode = tmpNode.left;
            }
            tmpNode = stack.peek();
            tmpNode = tmpNode.right;
            if (tmpNode == null){
                node = stack.pop();
                res.add(node.val);
                while (!stack.isEmpty() && node == stack.peek().right){
                    node = stack.pop();
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
