package TraceBack2;
import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode51 {
    public static void main(String[] args) {
        leetcode51 leetcode51 = new leetcode51();
        List<List<String>> res = leetcode51.solveNQueens(4);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> con1 = new HashSet<>();
        Set<Integer> con2 = new HashSet<>();
        Set<Integer> con3 = new HashSet<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        backTrack(n, 0, queue, res, con1, con2, con3);
        return res;
    }

    private void backTrack(int n, int i, int[] queue, List<List<String>> res, Set<Integer> con1, Set<Integer> con2, Set<Integer> con3) {
        if (i == n){
            res.add(parse(queue));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (con1.contains(j) || con2.contains(i - j) || con3.contains(i + j)) continue;
            con1.add(j);
            con2.add(i - j);
            con3.add(i + j);
            queue[i] = j;
            backTrack(n, i + 1, queue, res, con1, con2, con3);
            queue[i] = -1;
            con1.remove(j);
            con2.remove(i - j);
            con3.remove(i + j);
        }
    }

    private List<String> parse(int[] arr) {
        List<String> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[arr[i]] = 'Q';
            res.add(new String(row));
        }
        return res;
    }

}
