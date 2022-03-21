package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode5 {
    public static void main(String[] args) {
        leetcode5 leetcode5 = new leetcode5();
        String ans = leetcode5.longestPalindrome("cebmbed");
        System.out.println(ans);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int res = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = (i + 1) / 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            if (r - l - 1 > res){
                res = r - l - 1;
                left = l + 1;
            }

        }
        return s.substring(left, left + res);
    }

}
