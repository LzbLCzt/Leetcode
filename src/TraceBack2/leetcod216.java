package TraceBack2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcod216 {
    public static void main(String[] args) {
        leetcod216 leetcod216 = new leetcod216();
        List<List<Integer>> ans = leetcod216.combinationSum3(3, 9);
        System.out.println(ans);
    }

    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        isVisited = new boolean[9];
        backTrack(1, k, n, new ArrayList<>());
        return res;
    }

    /**
     *
     * @param index 元素1-9，对应isVisited的下标为index - 1
     * @param k
     * @param n
     * @param path
     */
    private void backTrack(int index, int k, int n, List<Integer> path) {
        if (path.size() == k && n == 0){
            res.add(new ArrayList<>(path));
            return;
        }else if (path.size() >= k || n <= 0 || index > 9 || isVisited[index - 1]){
            return;
        }

        //不考虑当前点
        backTrack(index + 1, k, n, path);

        //考虑当前点
        path.add(index);
        isVisited[index - 1] = true;
        backTrack(index + 1, k, n - index, path);
        path.remove(path.size() - 1);
        isVisited[index - 1] = false;
    }


}
