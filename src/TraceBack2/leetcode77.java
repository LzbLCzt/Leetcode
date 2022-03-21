package TraceBack2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode77 {
    public static void main(String[] args) {
        leetcode77 leetcode77 = new leetcode77();
        List<List<Integer>> ans = leetcode77.combine(4, 2);
        System.out.println(ans);
    }

    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int index, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index > n) {
            return;
        }
        //不考虑当前
        dfs(n, k, index + 1, path);

        //考虑当前
        if (n - index + 1 < k - path.size()) {  //此时剩余元素已经不足以构成k个元素
            return;
        }
        path.add(index);
        dfs(n, k, index + 1, path);
        path.remove(path.size() - 1);
    }
}
