package doublePointer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode266 {
    public static void main(String[] args) {
        leetcode266 leetcode266 = new leetcode266();
        boolean ans = leetcode266.canPermutePalindrome("carerac");
        System.out.println(ans);
    }
    //O(n),O(1)
    public boolean canPermutePalindrome(String s) {
       int res = 0;
       Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) % 2 == 1) {
                res++;
            }else {
                res--;
            }
        }
        return res < 2;
    }
}
