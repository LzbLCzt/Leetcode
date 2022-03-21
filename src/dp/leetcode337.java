package dp;

import myCode.TreeNode;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode337 {
    public static void main(String[] args) {

    }

    HashMap<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    HashMap<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root){
        dfs(root);

        return Math.max(f.getOrDefault(root,0), g.getOrDefault(root,0));
    }

    private void dfs(TreeNode node) {
        if(node == null) return;

        dfs(node.left);
        dfs(node.right);

        f.put(node, node.val + g.getOrDefault(node.left,0) + g.getOrDefault(node.right,0));
        g.put(node, Math.max(f.getOrDefault(node.left,0), g.getOrDefault(node.left,0)) +
                Math.max(f.getOrDefault(node.right,0), g.getOrDefault(node.right,0))
        );
    }

}
