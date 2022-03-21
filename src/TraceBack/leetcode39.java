package TraceBack;
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


    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        dfs(candidates,target, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<Integer> list, int i) {
        if (i == candidates.length){
            return;
        }

        if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        //不控制i是否越界，控制target不小于0
        //1.不考虑当前位置元素
        dfs(candidates, target, list, i + 1);
        //2.考虑当前位置元素
        if (target - candidates[i] >= 0){
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }

}
