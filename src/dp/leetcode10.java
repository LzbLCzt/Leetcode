package dp;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode10 {
    public static void main(String[] args) {
        leetcode10 leetcode10 = new leetcode10();
        boolean ans = leetcode10.isMatch("aab", "c*a*b");
//        boolean ans = leetcode10.isMatch("ab", ".*");
//        boolean ans = leetcode10.isMatch("mississippi", "mis*is*p*.");
        System.out.println(ans);
    }

    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        return dfs(sChars, pChars, 0, 0);
    }

    private boolean dfs(char[] s, char[] p, int i, int j) {
        if (i == s.length && j == p.length){
            return true;
        }
        if (i == s.length){
            if (j == p.length - 1){
                return p[j] == '*';
            }else {
                return judge(p,j);
            }
        }
        if (j == p.length){
            return false;
        }

        if (j + 1 < p.length && p[j+1] == '*'){
            if (match(s,p,i,j)){
                return dfs(s,p,i+1, j) || dfs(s,p,i,j+2);
            }else {
                return dfs(s,p,i,j+2);
            }

        }

        if (match(s,p,i,j)){
            return dfs(s,p,i+1,j+1);
        }

        return false;
    }

    private boolean match(char[] s, char[] p, int i, int j) {
        if (s[i] == p[j] || p[j] == '.'){
            return true;
        }
        return false;
    }

    private boolean judge(char[] p, int j) {
        while (j < p.length){
            if (j + 1 < p.length && p[j + 1] == '*'){
                j += 2;
            }else {
                return false;
            }
        }
        return true;
    }
}
