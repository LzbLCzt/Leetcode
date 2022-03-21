package Window2;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,2,2}, {0,2,0}, {2,0,0}};
        int ans = solution.minSailCost(arr);
        System.out.println(ans);
    }

    public int minSailCost (int[][] input) {
        int n = input.length;
        int m = input[0].length;
        int[][] dp = new int[n][m];

        for (int i = 1; i < m; i++) {
            if (input[0][i] == 0){
                dp[0][i] = dp[0][i-1] + 2;
            }else if (input[0][i] == 1){
                dp[0][i] = dp[0][i-1] + 1;
            }else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int j = 1; j < n; j++) {
            if (input[j][0] == 0){
                dp[j][0] = dp[j-1][0] + 2;
            }else if(input[j][0] == 1){
                dp[j][0] = dp[j-1][0] + 1;
            }else {
                dp[j][0] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int add = 0;
                if (dp[i-1][j] == Integer.MAX_VALUE && dp[i][j-1] == Integer.MAX_VALUE){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (input[i][j] == 2){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }else if (input[i][j] == 1){
                    add = 1;
                }else if (input[i][j] == 0){
                    add = 2;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + add;
            }
        }
        if (dp[n-1][m-1] == Integer.MAX_VALUE){
            return -1;
        }else {
            return dp[n-1][m-1];
        }
    }
}
