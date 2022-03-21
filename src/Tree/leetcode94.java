package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode94 {
    public static void main(String[] args) {

    }

    ///方法一（自己）：
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        TreeNode tempNode = root;
        TreeNode node;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.offerFirst(tempNode);
                tempNode = tempNode.left;
            }

            node = stack.pollFirst();
            ans.add(node.val);
            tempNode = node.right;
        }
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        TreeNode tempNode = root;
        TreeNode node;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.offerFirst(tempNode);
                tempNode = tempNode.left;
            }

            node = stack.peekFirst();
            tempNode = node.right;
            if (tempNode == null){
                node = stack.pollFirst();
                ans.add(node.val);

                while (!stack.isEmpty() && stack.peekFirst().right == node){
                    node = stack.pollFirst();
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
}
