package TraceBack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode40 {
    public static void main(String[] args) {
        leetcode40 leetcode40 = new leetcode40();
        List<List<Integer>> ans = leetcode40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(ans);
    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> combine = new ArrayList<Integer>();
//        dfs(candidates, target, ans, combine, 0);
//        return ans;
//    }
//
//    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
//        if (idx == candidates.length) {
//            return;
//        }
//        if (target == 0) {
//            ans.add(new ArrayList<Integer>(combine));
//            return;
//        }
//        // 直接跳过：不考虑当前元素
//        dfs(candidates, target, ans, combine, idx + 1);
//
//        // 选择当前数：考虑当前元素
//        if (target - candidates[idx] >= 0) {
//            combine.add(candidates[idx]);
//            dfs(candidates, target - candidates[idx], ans, combine, idx);
//            combine.remove(combine.size() - 1);
//        }
//    }


    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        res = new ArrayList<>();
        isVisited = new boolean[n];
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        } else if (target < 0 || index > candidates.length - 1 || isVisited[index]) {
            return;
        }

        //不考虑当前位置
        dfs(candidates, target, index + 1, path);

        //考虑当前位置
        //此时会导致重复
        if (index > 0 && !isVisited[index-1] && candidates[index] == candidates[index-1]){
            return;
        }
        path.add(candidates[index]);
        isVisited[index] = true;
        dfs(candidates, target - candidates[index], index + 1, path);
        path.remove(path.size() - 1);
        isVisited[index] = false;
    }

}
