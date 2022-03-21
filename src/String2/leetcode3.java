package String2;


import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode3 {
    public static void main(String[] args) {
        leetcode3 leetcode3 = new leetcode3();
        int ans = leetcode3.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0, n = s.length();
        int r = -1;
        char c;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i > 0){
                map.remove(s.charAt(i - 1));
            }
            while (r + 1 < n && !map.containsKey(c = s.charAt(r + 1))){
                map.put(c, ' ');
                r++;
            }
            res = Math.max(res, map.size());
        }
        return res;
    }
}
