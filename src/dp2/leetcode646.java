package dp2;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode646 {
    public static void main(String[] args) {
        leetcode646 leetcode646 = new leetcode646();
//        int res = leetcode646.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}});
        int res = leetcode646.findLongestChain(new int[][]{{1,2},{1,3}, {4,8}, {4,5}});
        System.out.println(res);
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int[] r = pairs[i], l = pairs[j];
                if (r[0] > l[1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
