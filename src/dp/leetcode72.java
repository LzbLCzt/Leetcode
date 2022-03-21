package dp;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode72 {
    public static void main(String[] args) {

    }

    //时间复杂度 ：O(mn)，其中 mm 为 word1 的长度，nn 为 word2 的长度。
    //空间复杂度 ：O(mn)，我们需要大小为 O(mn)O(mn) 的 DD 数组来记录状态值。

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1; //此时给b插入一个字符
                int down = D[i][j - 1] + 1; //此时给a插入一个字符
                int left_down = D[i - 1][j - 1];    //此时采用字符替换策略，若word1.charAt(i - 1) == word2.charAt(j - 1)，不需要做替换
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
