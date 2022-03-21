package Other2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode22 {
    public static void main(String[] args) {
        leetcode22 leetcode22 = new leetcode22();
        List<String> ans = leetcode22.generateParenthesis(1);
        System.out.println(ans);
    }

    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n,0,0,new StringBuilder());
        return res;
    }

    private void dfs(int max, int open, int close, StringBuilder path) {
        if (path.length() == 2 * max){
            res.add(new String(path));
            return;
        }
        if (open < max) {
            path.append('(');
            dfs(max, open + 1, close, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (open > close) {
            path.append(')');
            dfs(max, open, close + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
