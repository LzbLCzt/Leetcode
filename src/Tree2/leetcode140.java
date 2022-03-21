package Tree2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode140 {
    public static void main(String[] args) {
        leetcode140 leetcode140 = new leetcode140();
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        List<String> res = leetcode140.wordBreak("catsanddog", list);
        System.out.println(res);
    }

    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict){
        int n = s.length();
        int maxW = 1;
        for (String word : wordDict) {
            maxW = Math.max(maxW, word.length());
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && j >= i - maxW; j--) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        res = new ArrayList<>();
        if (!dp[n]) return res;
        backTrack(s, wordDict, n, new ArrayDeque<>(), dp);
        return res;
    }

    private void backTrack(String s, List<String> wordDict, int n, Deque<String> path, boolean[] dp) {
        if (n == 0){
            res.add(String.join(" ", path));
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            String suffix = s.substring(i,n);
            if (dp[i] && wordDict.contains(suffix)){
                path.offerFirst(suffix);
                backTrack(s, wordDict, i, path, dp);
                path.pollFirst();
            }
        }
    }
}
