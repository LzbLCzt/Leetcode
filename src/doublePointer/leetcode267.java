package doublePointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode267 {
    public static void main(String[] args) {
        leetcode267 leetcode267 = new leetcode267();
        List<String> ans = leetcode267.generatePalindromes("abc");
        System.out.println(ans);
    }

    Set<String> res;
    char ch;
    public List<String> generatePalindromes(String s) {
        int n = s.length();
        res = new HashSet<String>();
        int[] map = new int[128];
        if (!canGeneratePalindromes(s,map)){
            return new ArrayList<String>();
        }
        char[] halfS = new char[s.length() / 2];
        ch = 0;
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0){
                continue;
            } else if (map[i] % 2 == 1) {
                ch = (char)(i);
            }
            for (int j = 0; j < map[i] / 2; j++) {
                halfS[k++] = (char)(i);
            }
        }
        dfs(halfS,0);
        return new ArrayList<String>(res);
    }

    private void dfs(char[] s, int index) {
        if (index == s.length) {
            String newStr = new String(s);
            res.add(newStr + (ch == 0? "": ch) + new StringBuffer(newStr).reverse());
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (i != index && s[i] == s[index]){
                continue;
            }
            swap(s,i,index);
            dfs(s,index + 1);
            swap(s,i,index);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    private boolean canGeneratePalindromes(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;
            if (map[c] % 2 == 0){
                count--;
            }else {
                count++;
            }
        }
        return count <= 1;
    }
}
