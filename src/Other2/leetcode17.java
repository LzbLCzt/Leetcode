package Other2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode17 {
    public static void main(String[] args) {
        leetcode17 leetcode17 = new leetcode17();
        List<String> res = leetcode17.letterCombinations("");
        System.out.println(res);
    }

    List<String> res;
    Map<Character, String> phoneMap;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        int n = digits.length();
        res = new ArrayList<>();
        phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(digits, n, 0, new StringBuilder());
        return res;
    }

    private void backTrack(String digits, int n, int index, StringBuilder sb) {
        if (index == n){
            res.add(new String(sb));
            return;
        }

        String chars = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            sb.append(c);
            backTrack(digits, n, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
