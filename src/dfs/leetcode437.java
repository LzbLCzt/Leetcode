package dfs;

import MyUtils.TreeNode;
import MyUtils.TreeNodeUtils;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode437 {
    public static void main(String[] args) {
        leetcode437 leetcode437 = new leetcode437();
        TreeNode root = TreeNodeUtils.arrayToTreeNode(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        int res = leetcode437.pathSum(root, 8);
        System.out.println(res);
    }


//    int ans;
//    Map<Integer, Integer> map;
//    public int pathSum(TreeNode root, int sum) {
//        ans = 0;
//        map = new HashMap<>();
//        map.put(0,1);
//        dfs(root, sum, 0);
//
//        return ans;
//    }
//
//
//    /**
//     *
//     * @param node
//     * @param target
//     * @param curSum 从根节点到当前节点的前缀和
//     */
//    private void dfs(TreeNode node, int target, int curSum) {
//        if (node == null){
//            return;
//        }
//
//        curSum += node.val;
//        ans += map.getOrDefault(curSum - target, 0);
//        //更新map
//        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
//
//        dfs(node.left, target, curSum);
//        dfs(node.right, target, curSum);
//        //回溯*****
//        map.put(curSum, map.get(curSum) - 1);
//    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}
