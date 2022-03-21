package Array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode15 {
    public static void main(String[] args) {
        leetcode15 leetcode15 = new leetcode15();
        List<List<Integer>> ans = leetcode15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ans);
    }

    /*
    思路：双指针
        1. 枚举第一二个数字a，b，再利用while循环找到第三个数字
    时间：O(n^2)
    空间：O(logN)
     */
    List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first-1] == nums[first]){
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n - 1; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]){
                    continue;
                }

                while (third > second && nums[second] + nums[third] >= target) {
                    if (nums[second] + nums[third] == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[third]);
                        res.add(temp);
                        break;
                    }
                    third--;
                }
                if (nums[second] + nums[second + 1] > target){
                    break;
                }
            }
        }
        return res;
    }
}
