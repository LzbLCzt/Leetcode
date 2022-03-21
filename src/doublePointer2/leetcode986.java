package doublePointer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode986 {
    public static void main(String[] args) {
        leetcode986 leetcode986 = new leetcode986();
        int[][] firstList = new int[][]{{1,7},{8,12}};
        int[][] secondList = new int[][]{{6,9}};
        int[][] res = leetcode986.intervalIntersection(firstList, secondList);
        for (int[] x : res) {
            System.out.println(Arrays.toString(x));
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int l = 0, r = 0;
        while (l < firstList.length && r < secondList.length){
            int[] intervalA = firstList[l];
            int[] intervalB = secondList[r];
            if (intervalA[0] > intervalB[1]){
                r++;
            }else if (intervalB[0] > intervalA[1]){
                l++;
            }else {
                int L = Math.max(intervalA[0], intervalB[0]);
                int R = Math.min(intervalA[1], intervalB[1]);
                res.add(new int[]{L, R});
                if (intervalA[1] < intervalB[1]) l++;
                else r++;
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
