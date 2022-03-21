package dp2;

/**
 * @author shkstart
 * @create 2021-03-11 9:15
 */
public class leetcode647 {
    public static void main(String[] args) {
        leetcode647 leetcode647 = new leetcode647();
        int ans = leetcode647.countSubstrings("aaa");
        System.out.println(ans);
    }


    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n * 2 - 1; i++) {
            int l = i / 2;
            int r = (i + 1) / 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
}
