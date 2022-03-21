package TraceBack2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode40 {
    public static void main(String[] args) {
        leetcode40 leetcode40 = new leetcode40();
        List<List<Integer>> ans = leetcode40.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(ans);
    }

    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        isVisited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] candidates, int index, int target, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }else if (target < 0 || index >= candidates.length || isVisited[index]){
            return;
        }

        backTrack(candidates, index + 1, target, path);

        //考虑当前点
        if (index > 0 && candidates[index - 1] == candidates[index] && !isVisited[index - 1]) return;
        path.add(candidates[index]);
        isVisited[index] = true;
        backTrack(candidates, index + 1, target - candidates[index], path);
        isVisited[index] = false;
        path.remove(path.size() - 1);
    }
}
