package dfs;

import java.util.ArrayList;
import java.util.List;

public class leetcode784 {
    public static void main(String[] args) {
        leetcode784 leetcode784 = new leetcode784();
        List<String> res = leetcode784.letterCasePermutation("3z4");
        System.out.println(res);
    }

    List<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, new StringBuilder());
        return res;
    }

    private void dfs(char[] str, int index, StringBuilder path) {
        if (index >= str.length){
            res.add(new String(path));
            return;
        }
        char c = str[index];
        if (Character.isDigit(c)){
            path.append(c);
            dfs(str, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }else {
            path.append(Character.toLowerCase(c));
            dfs(str, index + 1, path);
            path.deleteCharAt(path.length() - 1);

            path.append(Character.toUpperCase(c));
            dfs(str, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
