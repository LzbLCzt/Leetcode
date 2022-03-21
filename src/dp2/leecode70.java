package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode70 {
    public static void main(String[] args) {
        leecode70 leecode70 = new leecode70();
        int res = leecode70.climbStairs(3);
        System.out.println(res);
    }
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int v1 = 1, v2 = 2;
        for (int i = 3; i <= n; i++) {
            int v2Tmp = v1 + v2;
            v1 = v2;
            v2 = v2Tmp;
        }
        return v2;
    }
}
