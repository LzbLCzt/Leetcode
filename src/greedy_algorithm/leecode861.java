package greedy_algorithm;

/**
 时间复杂度：O(mn)O(mn)，其中 mm 为矩阵行数，nn 为矩阵列数。
 空间复杂度：O(1)O(1)。
 */
public class leecode861 {
    public int matrixScore(int[][] A){
        int m = A.length, n = A[0].length;

        //计算第一列的字符对应的数字大小
        int ans = m * (1 << (n-1));

        //计算其他列的字符对应的数字大小，考虑是否有过行翻转
        for (int j = 1; j < n; j++) {
            int nOnes = 0;  //记录每列1的次数
            for (int i = 0; i < m; i++) {
                if(A[i][0] == 1){   //说明没有进行过行翻转
                    nOnes += A[i][j];
                }else{
                    nOnes += A[i][j] == 1? 0: 1;
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ans += k * (1 << (n-j-1));
        }

        return ans;
    }
}
