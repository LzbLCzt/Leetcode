package dfs;

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

    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;

        dfs(nums,new ArrayList(),0);

        return ans;
    }

    private void dfs(int[] nums, List list, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        dfs(nums,list,index+1);
        list.remove(list.size() - 1);
        dfs(nums,list,index+1);
    }

}
