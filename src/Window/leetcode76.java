package Window;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode76 {
    public static void main(String[] args) {
        leetcode76 leetcode76 = new leetcode76();
        String ans = leetcode76.minWindow("ADOBECODEBANC", "ABC");
//        String ans = leetcode76.minWindow("a", "a");
        System.out.println(ans);
    }

    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (tLen > sLen) return "";
        int[] cnt = new int[128];   //维护每个字母的频数差 = 滑动区间的频数 - 在t中的频数
        Set<Integer> set = new HashSet<>();
        //初始的滑动区间范围 = [0,tLen)
        for (int i = 0; i < tLen; i++) {
            ++cnt[s.charAt(i) - 'A'];
            --cnt[t.charAt(i) - 'A'];
            set.add(t.charAt(i) - 'A');
        }
        int l = 0, r = tLen, resL = -1, len = Integer.MAX_VALUE;
        int diff = 0;   //维护t中字母频数与当前滑动区间频数不同的字母数
        for (int i = 0; i < 128; i++) {
            if (set.contains(i) && cnt[i] < 0) diff++;
        }
        if (diff == 0){
            len = tLen;
            resL = 0;
        }
        while (r < sLen){
            int x = s.charAt(r) - 'A';  //x被加入滑动区间
            if (!set.contains(x)) {
                ++r;
                continue;
            }
            if (cnt[x] == -1) diff--;
            ++cnt[x];
            while (diff == 0 && l <= r){
                if (len > r - l + 1){
                    len = r - l + 1;
                    resL = l;
                }
                //左指针右移
                int y = s.charAt(l) - 'A';  //y从滑动区间移除
                if (set.contains(y)) {
                    if (cnt[y] == 0) diff++;
                    --cnt[y];
                }
                ++l;
            }
            ++r;
        }
        return resL == -1? "": s.substring(resL, resL + len);
    }

}
