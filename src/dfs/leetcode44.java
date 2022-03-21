package dfs;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode44 {
    public static void main(String[] args) {
        leetcode44 leetcode44 = new leetcode44();
//        boolean ans = leetcode44.isMatch("acdcb", "a*c?b");
//        boolean ans = leetcode44.isMatch("adceb", "*a*b");
//        boolean ans = leetcode44.isMatch("cb", "?a");
//        boolean ans = leetcode44.isMatch("aa", "*");
        boolean ans = leetcode44.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*", "\"aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbb" + "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*");

        System.out.println(ans);
    }

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0){
            return true;
        }
        if (p.length() == 0){
            return false;
        }

        return dfs(s,p,0,0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if (i == s.length() && (j == p.length() || judge(p,j))) {
            return true;
        }else if (i == s.length() || j == p.length()){
            return false;
        }

        if (match(s,p,i,j)){
            return dfs(s,p,i+1,j+1);
        }else if (p.charAt(j) == '*'){
            return dfs(s,p,i+1,j) || dfs(s,p,i,j+1);
        }

        return false;
    }

    private boolean match(String s, String p, int i, int j) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return true;
        }
        return false;
    }

    private boolean judge(String p, int j) {
        while (j < p.length() && p.charAt(j) == '*'){
            j++;
        }
        return j == p.length();
    }
}
