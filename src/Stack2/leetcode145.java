package Stack2;

import myCode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode145 {
    public static void main(String[] args) {
        
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode tempNode = root;
        TreeNode node;

        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.offerFirst(tempNode);
                tempNode = tempNode.left;
            }

            node = stack.peekFirst();
            tempNode = node.right;
            if(tempNode == null){
                node = stack.pollFirst();
                ans.add(node.val);

                while (!stack.isEmpty() && stack.peekFirst().right == node){
                    node = stack.pollFirst();
                    ans.add(stack.pollFirst().val);
                }
            }
        }

        return ans;
    }
}
