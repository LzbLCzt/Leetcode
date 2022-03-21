package Other2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode46 {
    public static void main(String[] args) {
        leetcode46 leetcode46 = new leetcode46();
        List<List<Integer>> ans = leetcode46.permute(new int[]{1,2,3});
        System.out.println(ans);
    }
    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> permute(int[] nums) {
        res  = new ArrayList<>();
        isVisited = new boolean[nums.length];
        backTrack(nums,0, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int index, List<Integer> path) {
      if (index >= nums.length){
          res.add(new ArrayList<>(path));
          return;
      }

        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]){
                isVisited[i] = true;
                path.add(nums[i]);
                backTrack(nums, index + 1, path);
                isVisited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

//    public List<List<Integer>> permute(int[] nums) {
//
//    }
}
