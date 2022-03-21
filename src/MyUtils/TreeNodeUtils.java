package MyUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 一纬数组构造二叉树
 */
public class TreeNodeUtils {
    public static void main(String[] args) {
        Integer[] array = {2,null,4,9,8,null,null,4};
        TreeNode root = arrayToTreeNode(array);
//        preOrder(root);
//        preOrderNoRecursive(root);
//        infixOrder(root);
//        infixOrderNoRecursive(root);
//        postOrderNoRecursive(root);
    }
    public static TreeNode arrayToTreeNode(Integer[] array){
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for(int i = 1; i < array.length; i++){
            TreeNode node = queue.peek();
            if(isLeft){
                if(array[i] != null){
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            }else {
                if(array[i] != null){
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static void preOrder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrderNoRecursive(TreeNode root){
        if (root == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode tempNode = root;
        TreeNode curNode = null;
        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.offerFirst(tempNode);
                System.out.println(tempNode.val);
                tempNode = tempNode.left;
            }
            tempNode = stack.pollFirst();
            tempNode = tempNode.right;
        }
    }

    public static void infixOrder(TreeNode root){
        if (root == null) return;
        infixOrder(root.left);
        System.out.println(root.val);
        infixOrder(root.right);
    }

    public static void infixOrderNoRecursive(TreeNode root){
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode tempNode = root;
        TreeNode curNode = null;
        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.offerFirst(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pollFirst();
            System.out.println(tempNode.val);
            tempNode = tempNode.right;
        }
    }

    public static void postOrder(TreeNode root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

//    public static void postOrderNoRecursive(TreeNode root){
//        if (root == null) return;
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode tempNode = root;
//        TreeNode curNode = null;
//        while (tempNode != null || !stack.isEmpty()){
//            while (tempNode != null){
//                stack.offerFirst(tempNode);
//                tempNode = tempNode.left;
//            }
//            tempNode = stack.peekFirst();
//            if (tempNode.right == null){
//                curNode = stack.pollFirst();
//                System.out.println(curNode.val);
//                while (!stack.isEmpty() && stack.peekFirst().right == curNode){
//                    curNode = stack.pollFirst();
//                    System.out.println(curNode.val);
//                }
//                tempNode = stack.pollFirst();
//            }else {
//                tempNode = tempNode.right;
//            }
//
//        }
//    }
}
