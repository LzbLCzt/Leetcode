package dp;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode139 {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    //优化
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int len = s.length(), maxw = 0;
//        boolean[] dp = new boolean[len + 1];
//        dp[0] = true;
//        Set<String> set = new HashSet();
//        for(String str : wordDict){
//            set.add(str);
//            maxw = Math.max(maxw, str.length());
//        }
//        for(int i = 1; i < len + 1; i++){
//            for(int j = i; j >= 0 && j >= i - maxw; j--){
//                if(dp[j] && set.contains(s.substring(j, i))){
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[len];
//    }
}
