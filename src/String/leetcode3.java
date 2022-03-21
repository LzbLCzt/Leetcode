package String;

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

    //滑动窗口：控制右指针
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        int res = 1;
        int right = 0;
        Set<Character> set = new HashSet<>();
        for (int left = 0; left < n; left++) {
            if (left > 0){
                set.remove(s.charAt(left -1));
            }
            while (right < n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    //方法二：滑动窗口，控制左指针
//    public int lengthOfLongestSubstring(String s) {
//        int[] m = new int[256]; //记录在当前，每个元素出现过的最后一个位置
//        Arrays.fill(m, -1);
//        int res = 0, left = -1; //left指向窗口最左侧的上一个位置
//        for (int i = 0; i < s.length(); ++i) {
//            left = Math.max(left, m[s.charAt(i)]);
//            m[s.charAt(i)] = i;
//            res = Math.max(res, i - left);
//        }
//        return res;
//    }
}
