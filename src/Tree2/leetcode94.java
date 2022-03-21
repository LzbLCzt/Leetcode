package Tree2;

import myCode.TreeNode;

import java.util.*;

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

        List<Integer> res = new ArrayList<>();
        TreeNode tempNode = root;
        TreeNode node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.addFirst(tempNode);
                tempNode = tempNode.left;
            }
            node = stack.pollFirst();
            res.add(node.val);
            tempNode = node.right;
        }
        return res;
    }

}
