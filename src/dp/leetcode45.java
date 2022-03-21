package dp;

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
        int steps = 0;
        int jumpToIndex = 0;    //当前step能调到的index
        int maxIndex = 0;       //当前step范围内[i,jumpToIndex] 能跳到最远的index（这里只是计算，并未真的跳过去了）
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {   //i指当前位置
            maxIndex = i == 0? nums[0]:Math.max(maxIndex, i + nums[i]);

            if (i == jumpToIndex) {
                steps++;
                jumpToIndex = maxIndex;
            }
        }
        return steps;
    }
}
