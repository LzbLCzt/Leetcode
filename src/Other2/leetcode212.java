package Other2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode212 {
    public static void main(String[] args) {
        leetcode212 leetcode212 = new leetcode212();
        List<String> res = leetcode212.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});
//        List<String> res = leetcode212.
//                findWords(new char[][]{{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}},new String[]{"oa","oaa"});
//        List<String> res = leetcode212.findWords(new char[][]{{'a'}}, new String[]{'a'});
        System.out.println(res);
    }

    Set<String> res;
    boolean[][] isVisited;
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        isVisited = new boolean[board.length][board[0].length];
        Trie2 trie = new Trie2();
        for(String word: words){
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backTrack(board, trie, i , j);
            }
        }
        return new ArrayList<>(res);
    }

    private void backTrack(char[][] board, Trie2 node, int i, int j) {
        if (!"".equals(node.word)){
            res.add(node.word);
        }
        int index;
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || isVisited[i][j] || node.children[(index = board[i][j] - 'a')] == null) return;

        isVisited[i][j] = true;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            backTrack(board, node.children[index], newI, newJ);
        }
        isVisited[i][j] = false;
    }
}

class Trie2{
    Trie2[] children;
    boolean isEnd;
    String word;

    public Trie2(){
        children = new Trie2[26];
        isEnd = false;
        word = "";
    }

    public void insert(String word){
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie2();
            }
            node = node.children[index];
        }
        node.isEnd = true;
        node.word = word;
    }
}



