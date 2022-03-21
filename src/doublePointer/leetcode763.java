package doublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode763 {
    public static void main(String[] args) {
        leetcode763 leetcode763 = new leetcode763();
        List<Integer> res = leetcode763.partitionLabels("abadacfmcfenknnkwws");
        System.out.println(res);
    }

    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] ends = new int[26];
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ends[chars[i] - 'a'] = i;
        }
        int L = 0, R = 0;
        for(int i = 0; i < n; i++){
            R = Math.max(R, ends[chars[i] - 'a']);
            if(i == R){
                res.add(R - L + 1);
                L = R + 1;
            }
        }
        return res;
    }

}
