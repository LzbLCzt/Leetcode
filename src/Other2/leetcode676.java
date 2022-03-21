package Other2;

public class leetcode676 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        boolean res = magicDictionary.search("hhllo");
        System.out.println(res);
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }
}

class MagicDictionary {
    Trie3 trie;
    public MagicDictionary() {
        trie = new Trie3();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            trie.insert(word);
        }
    }

    public boolean search(String searchWord) {
        int i = 0;  //searchWord的下标
        boolean flag = false;   //是否有一个字母已经被替换
        return backTrack(trie, searchWord, i , flag);
    }

    private boolean backTrack(Trie3 node, String word, int i, boolean flag) {
        if (word.length() == i){
            if (flag) return true;
            return false;
        }
        int index = word.charAt(i) - 'a';
        if (node.children[index] == null){
            if (flag) return false;
            flag = true;
            Trie3[] children = node.children;
            for (int j = 0; j < 26; j++) {
                if (children[j] != null){
                    if (backTrack(children[j], word, i + 1, flag)){
                        return true;
                    }
                }
            }
            flag = false;
            return false;
        }
        if (backTrack(node.children[index], word, i + 1, flag)){
            return true;
        }
        return false;
    }
}

class Trie3{
    Trie3[] children;
    boolean isEnd;
    public Trie3(){
        children = new Trie3[26];
        isEnd = false;
    }
    void insert(String word){
        Trie3 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie3();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}