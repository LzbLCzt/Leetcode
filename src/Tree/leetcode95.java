package Tree;

import MyUtils.TreeNodeUtils;
import MyUtils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
题目：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树

 算法解析：

 */
public class leetcode95 {
    public static void main(String[] args) {
        leetcode95 t95 = new leetcode95();
        List<TreeNode> resList = t95.generateTrees(3);
        for (TreeNode node : resList) {
            TreeNodeUtils.preOrder(node);
            System.out.println();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
