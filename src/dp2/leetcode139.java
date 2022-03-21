package dp2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode139 {
    public static void main(String[] args) {
        leetcode139 leetcode139 = new leetcode139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean res = leetcode139.wordBreak("leetcode", list);
        System.out.println(res);
    }

    //动态规划
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int n = s.length();
//        int size = wordDict.size();
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (dp[j] && wordDict.contains(s.substring(j,i + 1))){
//                    dp[i + 1] = true;
//                    break;
//                }
//            }
//        }
//        return dp[n];
//    }

    //动态规划 + 优化 -》dp[i]只需要往前探索到词典里最长的单词即可
    //dp[i]：指s中长度为i的[0,i]的子串能否由wordDict构成
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        int maxW = 0;   //wordDict中最长单词的长度
        for (String word : wordDict) {
            maxW = Math.max(maxW, word.length());
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0 && j >= i - maxW; j--) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
