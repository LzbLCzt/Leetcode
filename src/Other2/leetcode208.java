package Other2;//package Other2;
//
//import javax.xml.transform.TransformerException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author shkstart
// * @create 2021-03-05 16:09
// */
//public class leetcode208 {
//    public static void main(String[] args) {
////        Trie root = new Trie();
////        root.insert("apple");
////        root.insert("banana");
////        root.insert("orange");
////        System.out.println(root.search("orange"));
////        System.out.println(root.startsWith("bana"));
////        System.out.println(root.search("pineapple"));
////        List<int> list = new ArrayList<>();
//    }
//}
////时间复杂度：初始化为 O(1)O(1)，其余操作为 O(|S|)O(∣S∣)，其中 |S|∣S∣ 是每次插入或查询的字符串的长度。
////空间复杂度：O(|T|\cdot\Sigma)O(∣T∣⋅Σ)，其中 |T|∣T∣ 为所有插入字符串的长度之和，\SigmaΣ 为字符集的大小，本题 \Sigma=26Σ=26。
//class Trie {
//    Trie[] children;
//    boolean isEnd;
//    public Trie() {
//        children = new Trie[26];
//        isEnd = false;
//    }
//
//    public void insert(String word) {
//        Trie node = this;
//        for (int i = 0; i < word.length(); i++) {
//            int index = word.charAt(i) - 'a';
//            if (node.children[index] == null){
//                node.children[index] = new Trie();
//            }
//            node = node.children[index];
//        }
//        node.isEnd = true;
//    }
//
//    public boolean search(String word) {
//        Trie node = isPrefix(word);
//        return node != null && node.isEnd;
//    }
//
//    public boolean startsWith(String prefix) {
//        return isPrefix(prefix) != null;
//    }
//
//    public Trie isPrefix(String prefix){
//        Trie node = this;
//        for (int i = 0; i < prefix.length(); i++) {
//            int index = prefix.charAt(i) - 'a';
//            if (node.children[index] == null){
//                return null;
//            }
//            node = node.children[index];
//        }
//        return node;
//    }
//}