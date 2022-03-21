package Tree2;

import myCode.TreeNode;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode297 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        String[] str = {"1", "2", "3"};
        List<String> list = Arrays.asList(str);
        System.out.println(list.size());
    }
}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root,"");
    }


    private String rSerialize(TreeNode node, String str) {
        if (node == null){
            str += "null,";
        }else {
            str += node.val + ",";
            str = rSerialize(node.left,str);
            str = rSerialize(node.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }

    private TreeNode rDeserialize(List<String> data) {
        if (data.get(0).equals("null")){
            data.remove(0);
            return null;
        }
        int val = Integer.parseInt(data.get(0));
        data.remove(0);
        TreeNode node = new TreeNode(val);
        node.left = rDeserialize(data);
        node.right = rDeserialize(data);
        return node;
    }
}