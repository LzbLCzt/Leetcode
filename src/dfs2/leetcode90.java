package dfs2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode90 {
    public static void main(String[] args) {
        leetcode90 leetcode90 = new leetcode90();
        List<List<Integer>> ans = leetcode90.subsetsWithDup(new int[]{1,2,2});
        System.out.println(ans);
    }

    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        isVisited = new boolean[n];
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }
    private void backTrack(int[] nums, int index, List<Integer> path) {
        if (index >= nums.length){
            res.add(new ArrayList<>(path));
            return;
        }else if (isVisited[index]) return;
        backTrack(nums, index + 1, path);
        if (index > 0 && nums[index] == nums[index - 1] && !isVisited[index - 1]) return;
        path.add(nums[index]);
        isVisited[index] = true;
        backTrack(nums, index + 1, path);
        path.remove(path.size() - 1);
        isVisited[index] = false;
    }
}
