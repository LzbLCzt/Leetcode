package dfs2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode78 {
    public static void main(String[] args) {
        leetcode78 leetcode78 = new leetcode78();
        List<List<Integer>> ans = leetcode78.subsets(new int[]{1, 2, 3});
        System.out.println(ans);
    }

    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path) {
        if (index >= nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, index + 1, path);
        path.add(nums[index]);
        dfs(nums, index + 1, path);
        path.remove(path.size() - 1);
    }

}
