package TraceBack2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode39 {
    public static void main(String[] args) {
        leetcode39 leetcode39 = new leetcode39();
        List<List<Integer>> ans = leetcode39.combinationSum(new int[]{2,3,5}, 8);
        System.out.println(ans);
    }

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res =  new ArrayList<>();
        backTrack(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] candidates, int index, int target, List<Integer> path) {
        if (index >= candidates.length || target < 0) return;
        else if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        backTrack(candidates, index + 1, target, path);

        //考虑当前点
        path.add(candidates[index]);
        backTrack(candidates, index, target - candidates[index], path);
        path.remove(path.size() - 1);
    }
}
