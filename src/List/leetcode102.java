package List;

import myCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode102 {
    public static void main(String[] args) {

    }

    //方法一：
    List<List<Integer>> resList;
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) return new ArrayList<>();

        resList = new ArrayList<>();
        List<TreeNode> t1 = new ArrayList<>();
        List<TreeNode> t2 = new ArrayList<>();
        t1.add(root);

        while (t1.size() != 0 || t2.size() != 0){

            if(t1.size() != 0){
                ArrayList<Integer> tempList = new ArrayList<>();
                while (t1.size() != 0){
                    TreeNode tempNode = t1.remove(0);
                    tempList.add(tempNode.val);
                    if(tempNode.left != null) t2.add(tempNode.left);
                    if(tempNode.right != null) t2.add(tempNode.right);
                }
                resList.add(new ArrayList<>(tempList));
            }

            if(t2.size() != 0){
                ArrayList<Integer> tempList = new ArrayList<>();
                while (t2.size() != 0){
                    TreeNode tempNode = t2.remove(0);
                    tempList.add(tempNode.val);
                    if(tempNode.left != null) t1.add(tempNode.left);
                    if(tempNode.right != null) t1.add(tempNode.right);
                }
                resList.add(new ArrayList<>(tempList));
            }
        }

        return resList;
    }

    //方法二：
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> resList = new ArrayList<>();
        ArrayList<TreeNode> tempList = new ArrayList<>();

        while (tempList.size() != 0){
            int size = tempList.size();
            ArrayList<Integer> t1 = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = tempList.remove(0);
                t1.add(node.val);
                if(node.left != null) tempList.add(node.left);
                if(node.right != null) tempList.add(node.right);
            }

            resList.add(t1);
        }

        return resList;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> resList = new ArrayList<>();
        List<TreeNode> tempList = new LinkedList<>();
        tempList.add(root);

        while (tempList.size() != 0){
            int size = tempList.size();
            ArrayList<Integer> t1 = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = tempList.remove(0);
                t1.add(node.val);
                if(node.left != null) tempList.add(node.left);
                if(node.right != null) tempList.add(node.right);
            }

            resList.add(t1);
        }

        return resList;
    }
}
