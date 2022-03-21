package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode22 {
    public static void main(String[] args) {
        leetcode22 leetcode22 = new leetcode22();
        List<String> ans = leetcode22.generateParenthesis(3);
        System.out.println(ans);
    }

    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        search(n, 0, 0, new StringBuilder());
        return ans;
    }

    private void search(int max, int open, int close, StringBuilder stringBuilder) {
        if (stringBuilder.length() == max * 2){
            ans.add(stringBuilder.toString());
            return;
        }

        if (open < max){
             stringBuilder.append('(');
             search(max,open + 1, close, stringBuilder);
             stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < open){
            stringBuilder.append(')');
            search(max, open, close + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<String>();
//        backtrack(ans, new StringBuilder(), 0, 0, n);
//        return ans;
//    }
//
//    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
//        if (cur.length() == max * 2) {
//            ans.add(cur.toString());
//            return;
//        }
//        if (open < max) {
//            cur.append('(');
//            backtrack(ans, cur, open + 1, close, max);
//            cur.deleteCharAt(cur.length() - 1);
//        }
//        if (close < open) {
//            cur.append(')');
//            backtrack(ans, cur, open, close + 1, max);
//            cur.deleteCharAt(cur.length() - 1);
//        }
//    }
}
