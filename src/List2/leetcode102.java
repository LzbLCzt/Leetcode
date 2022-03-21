package List2;

import MyUtils.TreeNode;

import java.util.*;

public class leetcode102 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res = new ArrayList<>();
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        queue1.addLast(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (!queue1.isEmpty()){
                TreeNode curNode = queue1.pollFirst();
                list.add(curNode.val);
                if (curNode.left != null) queue2.addLast(curNode.left);
                if (curNode.right != null) queue2.addLast(curNode.right);
            }
            res.add(list);
            ArrayList<Integer> list2 = new ArrayList<>();
            while (!queue2.isEmpty()){
                TreeNode curNode = queue2.pollFirst();
                list2.add(curNode.val);
                if (curNode.left != null) queue1.addLast(curNode.left);
                if (curNode.right != null) queue1.addLast(curNode.right);
            }
        }
        return res;
    }
}
