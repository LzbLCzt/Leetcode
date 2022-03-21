package doublePointer2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode16 {
    public static void main(String[] args) {
        leetcode16 leetcode16 = new leetcode16();
        int ans = leetcode16.threeSumClosest(new int[]{1,2,3,4,5,6,7}, 15);
        System.out.println(ans);
    }

    public int threeSumClosest(int[] nums, int target) {
        int best = 10000000;
        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first - 1] == nums[first]){
                continue;
            }
            int a = nums[first];
            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int sum = a + nums[second] + nums[third];
                if (sum == target){
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }

                if (sum > target) {
                    third--;
                }else {
                    second++;
                }
            }
        }
        return best;
    }
}
