package myCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode409 {
    public static void main(String[] args) {

    }

    //计算最长子回文穿
    public int longestPalindrome(String s) {
        if(s.length() < 1) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        int ans = 0;
        boolean flag = true;    //奇数个数的字母只能留一个作为中间的数,为true表示还没将这个数算进去
        for(Map.Entry ele: map.entrySet()){
            int value = (int) ele.getValue();
            if(value % 2 == 0) ans += value;
            else if(value % 2 != 0 && flag){
                ans += value;
                flag = false;
            }
            else if(value % 2 != 0 && !flag) ans += value - 1;
        }
        return ans;
    }

    //方法二：
    //个数是奇数个数的只能取n-1，个数是偶数个的取n，所有取 n / 2 * 2
    //如果有奇数个数的话，可以取一个作为回文中间的数，所以当ans为偶数时，ans++
    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

}
