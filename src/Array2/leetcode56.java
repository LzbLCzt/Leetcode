package Array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        leetcode56 leetcode56 = new leetcode56();
        int[][] ans = leetcode56.merge(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }

    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        res.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] first = res.get(res.size() - 1);
            int[] second = intervals[i];
            if (second[0] > first[1]){
                res.add(second);
            }else {
                first[1] = Math.max(first[1], second[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
