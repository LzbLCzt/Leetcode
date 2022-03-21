package doublePointer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode763 {
    public static void main(String[] args) {
        leetcode763 leetcode763 = new leetcode763();
        List<Integer> res = leetcode763.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(res);
    }

    public List<Integer> partitionLabels(String s) {
      Map<Character, Integer> lastIndex = new HashMap<>();
      List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastIndex.put(c, i);
        }

        int r = lastIndex.get(s.charAt(0));
        int L = 0;
        for (int l = 0; l < s.length(); l++) {
            char c = s.charAt(l);
            r = Math.max(r, lastIndex.get(c));

            if (l == r){
                res.add(l - L + 1);
                L = l + 1;
                if (l + 1 < s.length()){
                    r = lastIndex.get(s.charAt(l + 1));
                }
            }
        }
        return res;
    }

}
