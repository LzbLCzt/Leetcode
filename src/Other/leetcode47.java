package Other;


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
        List<List<Integer>> ans = leetcode47.permuteUnique(new int[]{1,1,2});
        System.out.println(ans);

    }
    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        isVisited = new boolean[n];
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]){
                continue;
            }else if (i > 0 && nums[i-1] == nums[i] && !isVisited[i-1]){    //如果i-1访问过，说明是第一次添加，
                continue;
            }
            path.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, path, index + 1);
            path.remove(path.size() - 1);
            isVisited[i] = false;
        }
    }
}
