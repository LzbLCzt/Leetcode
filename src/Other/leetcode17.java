package Other;

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
        List<String> res = leetcode17.letterCombinations("22");
        System.out.println(res);
    }

    //方法一（自己）:递归 + 回溯
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        search(digits, 0, phoneMap, new StringBuilder());   //0：表示digits的下标
        return res;
    }

    private void search(String digits, int i, Map<Character, String> phoneMap, StringBuilder stringBuilder) {
        if (i >= digits.length()){
            res.add(stringBuilder.toString());
            return;
        }

        char key = digits.charAt(i);
        String phones = phoneMap.get(key);
        for (int j = 0; j < phones.length(); j++) {
            char value = phones.charAt(j);
            stringBuilder.append(value);

            search(digits, i+1, phoneMap, new StringBuilder(stringBuilder));

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
