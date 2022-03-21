package dfs2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode301 {
    public static void main(String[] args) {
        leetcode301 leetcode301 = new leetcode301();
        List<String> ans = leetcode301.removeInvalidParentheses("(a)())()");
        System.out.println(ans);
    }

    Set<String> res;
    public List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        res = new HashSet<>();
        int open = 0, close = 0;
        for(char c: chars){
            if ('(' == c) {
                open++;
            }else if (')' == c){
                if (open > 0) open--;
                else close++;
            }
        }
        backTrack(chars, n,0, open, close, 0, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void backTrack(char[] chars, int n,int index, int leftRemove, int rightRemove, int open, int close, StringBuilder sb) {
        if (index >= n){
            if (leftRemove == 0 && rightRemove == 0){
                res.add(new String(sb));
            }
            return;
        }
        char c = chars[index];
        //删除当前char
        if (c == '(' && leftRemove > 0){
            backTrack(chars, n, index + 1, leftRemove - 1, rightRemove, open, close, sb);
        }else if (c == ')' && rightRemove > 0){
            backTrack(chars, n, index + 1, leftRemove, rightRemove - 1, open, close, sb);
        }

        //不删除当前点
        sb.append(c);
        if (c != '(' && c != ')'){
            backTrack(chars, n, index + 1, leftRemove, rightRemove, open, close, sb);
        }else if (c =='('){
            backTrack(chars, n, index + 1, leftRemove, rightRemove, open + 1, close, sb);
        }else if (open > close){
            backTrack(chars, n, index + 1, leftRemove, rightRemove, open, close + 1, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
