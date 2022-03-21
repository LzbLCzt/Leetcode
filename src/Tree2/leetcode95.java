package Tree2;
import java.util.ArrayList;
import java.util.List;

import MyUtils.TreeNode;
import MyUtils.TreeNodeUtils;

/**
题目：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树

 算法解析：

 */
public class leetcode95 {
    public static void main(String[] args) {
        leetcode95 t95 = new leetcode95();
        List<TreeNode> resList = t95.generateTrees(3);
        for (TreeNode node : resList) {
            TreeNodeUtils.infixOrder(node);
            System.out.println();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return null;
        return generateTrees(1,n);

    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (left > right){
            allTrees.add(null);
            return allTrees;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftRoots = generateTrees(left, i - 1);
            List<TreeNode> rightRoots = generateTrees(i + 1, right);
            for (TreeNode leftTree : leftRoots) {
                for (TreeNode rightTree : rightRoots) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftTree;
                    cur.right = rightTree;
                    allTrees.add(cur);
                }
            }
        }
        return allTrees;
    }
}
