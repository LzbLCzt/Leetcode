package dp2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode45 {
    public static void main(String[] args) {
        leetcode45 leetcode45 = new leetcode45();
        int ans = leetcode45.jump(new int[]{2,3,0,1,4});
        System.out.println(ans);
    }

    public int jump(int[] nums) {
       int n = nums.length;
       int steps = 0, nextStep = 0, maxStep = 0;
        for (int i = 0; i < n - 1; i++) {
            maxStep = Math.max(maxStep, i + nums[i]);
            if (i == nextStep){
                steps++;
                nextStep = maxStep;
            }
        }
        return steps;
    }
}
