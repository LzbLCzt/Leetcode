package Array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode57 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {4,5}, {19,20}, {15,18}};
        leetcode57 leetcode57 = new leetcode57();
        int[][] res = leetcode57.insert(intervals, new int[]{2, 6});
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
      boolean isPlaced = false;
      List<int[]> res = new ArrayList<>();
      int left = newInterval[0];
      int right = newInterval[1];

      for(int[] cur: intervals){
          int L = cur[0];
          int R = cur[1];
          if (right < L){
              if (!isPlaced){
                  res.add(new int[]{left, right});
                  isPlaced = true;
              }
              res.add(cur);
          }else if (R < left){
              res.add(cur);
          }else {
              left = Math.min(left, L);
              right = Math.max(right, R);
          }
      }
      if (!isPlaced){
          res.add(new int[]{left, right});
      }
      return res.toArray(new int[res.size()][2]);
    }
}
