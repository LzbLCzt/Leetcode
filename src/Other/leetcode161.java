package Other;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode161 {
    public static void main(String[] args) {
        leetcode161 leetcode161 = new leetcode161();
        boolean res = leetcode161.isOneEditDistance("ab", "acb");
        System.out.println(res);
    }

    public boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        if (n > m){
            return isOneEditDistance(t, s); //保证 n <= m
        }
        if (Math.abs(n - m) > 1) return false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)){
                if (n == m){
                    return s.substring(i + 1, n).equals(t.substring(i + 1, m));
                }else {
                    return s.substring(i, n).equals(t.substring(i + 1, m));
                }
            }
        }
        return n + 1 == m;
    }
}
