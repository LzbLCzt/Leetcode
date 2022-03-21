package dfs2;

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

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        backTrack(root, targetSum, new ArrayList<>());
        return res;
    }

    private void backTrack(TreeNode node, int targetSum, List<Integer> path) {
       if (node == null) return;

       targetSum -= node.val;
       path.add(node.val);
       if (node.left == null && node.right == null){
           if (targetSum == 0){
               res.add(new ArrayList<>(path));
           }
       }
       backTrack(node.left, targetSum, path);
       backTrack(node.right, targetSum, path);
       path.remove(path.size() - 1);
    }
}
