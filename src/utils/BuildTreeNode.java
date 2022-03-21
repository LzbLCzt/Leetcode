package utils;


/**
 * @author shkstart
 * @create 2021-11-10 18:49
 * 传入一个数组，构造一个二叉树
 * 如果传入的数组存在元素 == Integer.max_Value,表示该点值为null
 */
public class BuildTreeNode {
    public static void main(String[] args) {
        BuildTreeNode buildTreeNode = new BuildTreeNode(new int[]{10,5,-3,3,2,Integer.MAX_VALUE,11,3,-2,Integer.MAX_VALUE,1});
        //获取根节点
//        TreeNode root = buildTreeNode.getRoot();
        //前序遍历
//        root.preOrder();
    }
    TreeNode root;
    int size;
    public BuildTreeNode(int[] arr){
        size = arr.length;
        if (size < 1) {
            root = null;
            return;
        }
        root = dfs(arr, 0);
    }

    private TreeNode dfs(int[] arr, int i) {
        if (arr[i]  == Integer.MAX_VALUE) {
            return null;
        }
        TreeNode node = new TreeNode(arr[i]);
        if (i * 2 + 1 < arr.length){
            node.left = dfs(arr, i * 2 + 1);
        }
        if (i * 2 + 2 < arr.length){
            node.right = dfs(arr, i * 2 + 2);
        }
        return node;
    }

    public TreeNode getRoot(){
        return root;
    }

    public void preOrder(TreeNode node){
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node.val);
        preOrder(node.right);
    }
}
