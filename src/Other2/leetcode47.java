package Other2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode47 {
    public static void main(String[] args) {
        leetcode47 leetcode47 = new leetcode47();
        List<List<Integer>> ans = leetcode47.permuteUnique(new int[]{3,3,0,3});
        System.out.println(ans);

    }

    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void backTrack(int[] nums, int index, List<Integer> path) {
        if (index >= nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !isVisited[i - 1]){
                continue;
            }
            if (!isVisited[i]){
                isVisited[i] = true;
                path.add(nums[i]);
                backTrack(nums, index + 1, path);
                isVisited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
