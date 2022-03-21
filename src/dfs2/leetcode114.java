package dfs2;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode114 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
       if (root == null) return;
       TreeNode cur = root;
       TreeNode next, pre;
       while (cur != null){
           if (cur.left != null){
               pre = cur.left;
               next = pre;
               while (pre.right != null) pre = pre.right;
               pre.right = cur.right;
               cur.left = null;
               cur.right = next;
           }
           cur = cur.right;
       }
    }
}
