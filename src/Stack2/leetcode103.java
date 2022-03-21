package Stack2;

import myCode.TreeNode;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode103 {
    public static void main(String[] args) {
        leetcode103 leetcode103 = new leetcode103();
    }

    List<List<Integer>> res;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res = new ArrayList<>();
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.addFirst(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()){
                List<Integer> level = new ArrayList<>();
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pollFirst();
                    level.add(node.val);
                    if (node.left != null) stack2.addFirst(node.left);
                    if (node.right != null) stack2.addFirst(node.right);
                }
                res.add(level);
            }

            if (!stack2.isEmpty()){
                List<Integer> level = new ArrayList<>();
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pollFirst();
                    level.add(node.val);
                    if (node.right != null) stack1.addFirst(node.right);
                    if (node.left != null) stack1.addFirst(node.left);
                }
                res.add(level);
            }
        }
        return res;
    }
}
