package Tree2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode472 {
    public static void main(String[] args) {
        leetcode472 leetcode472 = new leetcode472();
        List<String> res = leetcode472.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});
        System.out.println(res);
    }

    List<String> res;
    Trie trie = new Trie();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        res = new ArrayList<>();
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        for (String word : words) {
            if (word.length() < 1) continue;
            boolean[] isVisited = new boolean[word.length()];
            if (dfs(word, 0, isVisited)){
                res.add(word);
            }else insert(word);
        }
        return res;
    }

    private boolean dfs(String word, int start, boolean[] isVisited) {
        if (start == word.length()){
            return true;
        }
        if (isVisited[start]) return false;
        isVisited[start] = true;
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            node = node.children[idx];
            if (node == null) return false;
            if (node.isEnd){
                if (dfs(word, i + 1, isVisited)) return true;
            }
        }
        return false;
    }

    private void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) node.children[idx] = new Trie();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    static class Trie{
        Trie[] children;
        boolean isEnd;

        private Trie(){
            children = new Trie[26];
            isEnd = false;
        }
    }

}

