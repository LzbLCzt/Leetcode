package greedy_algorithm;

/**
 * @author shkstart
 * @create 2021-03-29 20:02
 */
public class leetcode1221 {
    public static void main(String[] args) {
        leetcode1221 leetcode1221 = new leetcode1221();
        System.out.println(leetcode1221.balancedStringSplit("LLLLRRRR"));
    }

    public int balancedStringSplit(String s) {
        int ans = 0;
        int n = s.length();
        int R = 0;
        int L = 0;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'L') L++;
            else R++;

            if(L == R){
                ans++;
                L = 0;
                R = 0;
            }
        }
        return ans;
    }
}
