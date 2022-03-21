package dp;

/**
 * @author shkstart
 * @create 2021-03-11 9:15
 */
public class leetcode647 {
    public int countSubstrings(String s){
        if(s.length() == 1) return 1;
        int sum = 0;
        for(int i = 0; i < 2 * s.length() - 1; i++){
            int l = i / 2;
            int r = i / 2 + i % 2; //*****
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                sum++;
                l--;
                r++;
            }
        }

        return sum;
    }
}
