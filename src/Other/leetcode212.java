package Other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode212 {
    public static void main(String[] args) {
        leetcode212 leetcode212 = new leetcode212();
        List<String> res = leetcode212.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});
//        List<String> res = leetcode212.findWords(new char[][]{{'a'}}, new String[]{"a"});
        System.out.println(res);
    }

    Set<String> res;
    boolean[][] isVisited;
    Trie2 trie;
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length, m = board[0].length;
        res = new HashSet<>();
        isVisited = new boolean[n][m];
        trie = new Trie2();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                backTrack(board, i, j,trie);
            }
        }
        return new ArrayList<>(res);
    }

    private void backTrack(char[][] board, int i, int j, Trie2 node) {
        if (node.word != ""){
            res.add(node.word);
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || isVisited[i][j]) return;
        char c = board[i][j];
        int index = c- 'a';
        if (node.children[index] == null) return;
        isVisited[i][j] = true;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            backTrack(board, newI, newJ, node.children[index]);
        }
        isVisited[i][j] = false;

    }
}

class Trie2{
    String word;    //关键点！！！记录当前插入的字符串
    Trie2[] children;
    boolean isEnd;

    public Trie2(){
        word = "";
        children = new Trie2[26];
        isEnd = false;
    }

    public void insert(String word){
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie2();
            }
            node = node.children[index];
        }
        node.isEnd = true;
        node.word = word;   //******关键点！！！记录当前插入的字符串
    }
}
