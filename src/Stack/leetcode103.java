package Stack;

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

    List<List<Integer>> ans;
    Stack<TreeNode> stack1;
    Stack<TreeNode> stack2;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        ans = new ArrayList<>();
        stack1 = new Stack<>();
        stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();

            while (!stack1.isEmpty()){
                TreeNode ele = stack1.pop();
                temp.add(ele.val);
                if(ele.left != null) stack2.push(ele.left);
                if(ele.right != null) stack2.push(ele.right);
            }
            if(temp.size() != 0) ans.add(new ArrayList<>(temp));
            temp.clear();
            while (!stack2.isEmpty()){
                TreeNode ele = stack2.pop();
                temp.add(ele.val);
                if(ele.right != null) stack1.push(ele.right);
                if(ele.left != null) stack1.push(ele.left);
            }

            if(temp.size() != 0) ans.add(new ArrayList<>(temp));
        }

        return ans;
    }
}
