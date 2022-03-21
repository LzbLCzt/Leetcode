package tengxun;

public class Main2 {


    public static void main(String[] args) {
        Main2 main2 = new Main2();
    }

    public TreeNode pruneLeaves (TreeNode root) {
        // write code here
        if (judge(root)){
            return null;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null){
            return;
        }
        TreeNode lSon = node.left;
        if (lSon != null){
            if (judge(lSon)){
                node.left = null;
            }
        }
        TreeNode rSon = node.right;
        if (rSon != null){
            if (judge(rSon)){
                node.right = null;
            }
        }
        if (node.left != null){
            dfs(node.left);
        }
        if (node.right != null){
            dfs(node.right);
        }
    }


    //判断当前节点的子节点是否是叶子节点
    private boolean judge(TreeNode node){

        TreeNode lSon = node.left;
        if (lSon != null){
            if (lSon.left == null && lSon.right == null){
                return true;
            }
        }
        TreeNode rSon = node.right;
        if (rSon != null){
            if (rSon.left == null && rSon.right == null){
                return true;
            }
        }
        return false;
    }
}