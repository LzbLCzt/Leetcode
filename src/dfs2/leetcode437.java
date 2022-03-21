package dfs2;
import utils.TreeNode;
import utils.BuildTreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode437 {
    public static void main(String[] args) {
        BuildTreeNode buildTreeNode = new BuildTreeNode(new int[]{1,-2,-3});
        leetcode437 leetcode437 = new leetcode437();
        int ans = leetcode437.pathSum(buildTreeNode.getRoot(), -1);
        System.out.println(ans);
//        buildTreeNode.preOrder(buildTreeNode.getRoot());

    }

    Map<Integer, Integer> map;
    int res;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        map = new HashMap<>();
        map.put(0,1);
        res = 0;
        dfs(root, targetSum, 0);
        return res;
    }

    private void dfs(TreeNode node, int targetSum, int curSum) {
        if (node == null) return;

        curSum += node.val;
        res += map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum,0) + 1);
        dfs(node.left, targetSum, curSum);
        dfs(node.right, targetSum, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }
}
