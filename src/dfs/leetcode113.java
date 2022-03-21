package dfs;

import myCode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode113 {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        dfs(root,new ArrayList<>(), targetSum);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> list, int target) {
        if (node == null){
            return;
        }

        list.add(node.val);
        target -= node.val;

        if (node.left == null && node.right == null){
            if (target == 0){
                ans.add(new ArrayList<>(list));
            }
        }

        dfs(node.left, list, target);
        dfs(node.right, list, target);

        list.remove(list.size() - 1);
    }
}
