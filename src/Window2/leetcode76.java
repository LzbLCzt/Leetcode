package Window2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode76 {
    public static void main(String[] args) {
        leetcode76 leetcode76 = new leetcode76();
        String ans = leetcode76.minWindow("ABANC", "ABC");
//        String ans = leetcode76.minWindow("a", "a");
        System.out.println(ans);
    }

    public String minWindow(String s, String t) {
       int sLen = s.length(), tLen = t.length();
       int resL = -1, len = Integer.MAX_VALUE;
       if (sLen < tLen) return "";
       int[] cnt = new int[128];
       Set<Integer> set = new HashSet<>();
       for (int i = 0; i < tLen; i++) {
           set.add(t.charAt(i) - 'A');
           ++cnt[s.charAt(i) - 'A'];
           --cnt[t.charAt(i) - 'A'];
       }
       int diff = 0;
       for (int i = 0; i < 128; i++) if (set.contains(i) && cnt[i] < 0) diff++;
       if (diff == 0){
           len = tLen;
           resL = 0;
       }

       int l = 0, r = tLen;
       while (r < sLen){
           int x = s.charAt(r) - 'A';
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
               int y = s.charAt(l) - 'A';
               if (set.contains(y)){
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
