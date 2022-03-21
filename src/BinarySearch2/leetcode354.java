package BinarySearch2;

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
        int res = leetcode354.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1,1}});
        System.out.println(res);
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length, m = envelopes[0].length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] != o2[0]? o1[0] - o2[0]: o2[1] - o1[1];
            }
        });
        return LengthOfLIS(envelopes);
    }

    private int LengthOfLIS(int[][] nums) {
        int n = nums.length;
        int res = 0;
        int[] tails = new int[n];
        for (int[] tuple : nums) {
            int i = 0, j = res;
            while (i < j){
                int mid = (i + j) / 2;
                if (tuple[1] > tails[mid]) i = mid + 1;
                else j = mid;
            }
            tails[i] = tuple[1];
            if (j == res){
                res++;
            }
        }
        return res;
    }
}
