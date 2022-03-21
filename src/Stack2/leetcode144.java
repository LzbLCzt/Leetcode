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
public class leetcode144 {
    public static void main(String[] args) {
        
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        TreeNode tempNode = root;
        TreeNode node;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (tempNode != null || !stack.isEmpty()){
            while (tempNode != null){
                stack.offerFirst(tempNode);
                ans.add(tempNode.val);
                tempNode = tempNode.left;
            }

            node = stack.pollFirst();
            tempNode = node.right;
        }

        return ans;
    }
}
