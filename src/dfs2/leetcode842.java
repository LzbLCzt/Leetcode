package dfs2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode842 {
    public static void main(String[] args) {
        leetcode842 leetcode842 = new leetcode842();
//        System.out.println(leetcode842.subDigit(new char[]{'1','2','3'}, 0, 3));
//        List<Integer> res = leetcode842.splitIntoFibonacci("0123");
        List<Integer> res = leetcode842.splitIntoFibonacci("01123581321345589");
        System.out.println(res);
//        System.out.println("abc".substring(0,2));
//        System.out.println(leetcode842.parseStr("1234", 0, 2));
    }

    public List<Integer> splitIntoFibonacci(String num) {
        char[] chars = num.toCharArray();
        List<Integer> res = new ArrayList<>();
        backTrack(chars, 0, res);
        return res;
    }

    private boolean backTrack(char[] chars, int index, List<Integer> path) {
        if (index >= chars.length){
            if (path.size() > 2) return true;
        }
        for (int i = index; i < chars.length; i++) {
            if (chars[index] == '0' && i > index) break;
            long cur = getNum(chars, index, i);
            if (cur > Integer.MAX_VALUE) break;
            int size = path.size();
            if (size < 2 || path.get(size - 1) + path.get(size - 2) == cur){
                path.add((int)cur);
                if (backTrack(chars, i + 1, path)){
                    return true;
                }
                path.remove(path.size() - 1);
            }else if (path.get(size - 1) + path.get(size - 2) < cur) break;

        }
        return false;
    }

    private long getNum(char[] chars, int i, int j) {
        long res = 0;
        for (int k = i; k <= j; k++) {
            res = res * 10 + chars[k] - '0';
        }
        return res;
    }
}
