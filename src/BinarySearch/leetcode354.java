package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode354 {
    public static void main(String[] args) {
        leetcode354 leetcode354 = new leetcode354();
//        int res = leetcode354.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        int res = leetcode354.maxEnvelopes(new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}});
        System.out.println(res);
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length, m = envelopes[0].length;
        //按照w作为第一关键字升序排序，再按照h作为第二关键字降序排序
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                else return o1[0] - o2[0];
            }
        });
        //问题转化为对h求最长递增子序列问题(Leetcode 300)
        return lengthOfLIS(envelopes);
    }

    private int lengthOfLIS(int[][] envelopes) {
        int n = envelopes.length;
        int[] tails = new int[n];
        int res = 0;
        for (int k = 0; k < n; k++) {
            int h = envelopes[k][1];
            //找h在tails中的位置
            int i = 0, j = res;
            while (i < j){
                int m = (i + j) / 2;
                if (tails[m] < h) i = m + 1;
                else j = m;
            }
            tails[i] = h;
            if (res == j) res++;
        }
        return res;
    }

}
