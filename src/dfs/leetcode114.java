package dfs;

import myCode.TreeNode;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode114 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        TreeNode next,pre;  //pre:cur.right的前驱节点，next：cur的后继节点
        while (cur != null){
            if (cur.left != null){
                next = cur.left;
                pre = next;
                //让前驱节点走到底
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
