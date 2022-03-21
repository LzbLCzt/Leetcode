package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode46 {
    public static void main(String[] args) {
        leetcode46 leetcode46 = new leetcode46();
        List<List<Integer>> ans = leetcode46.permute(new int[]{1, 2, 3});
        System.out.println(ans);
    }

    List<List<Integer>> ans;
    boolean[] isVisited;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        isVisited = new boolean[nums.length];
        int n = nums.length;
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int pos, List<Integer> path) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            if (!isVisited[i]){
                isVisited[i] = true;
                dfs(nums, pos + 1, path);
                isVisited[i] = false;
            }
            path.remove(path.size() - 1);
        }
    }
}
