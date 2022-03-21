package greedy_algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-29 19:23
 */
public class leetcode1282 {
    public static void main(String[] args) {
        leetcode1282 leetcode1282 = new leetcode1282();
        int[] arr = {3,3,3,3,3,1,3};
        List<List<Integer>> ans = leetcode1282.groupThePeople(arr);
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> x = ans.get(i);
            for (int j = 0; j < x.size(); j++) {
                System.out.print(x.get(j) + " ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> ans;
    HashMap<Integer, List<Integer>> map;
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        int n = groupSizes.length;

        for (int i = 0; i < n; i++) {
            int key = groupSizes[i];
            if(map.containsKey(key)){
                List<Integer> value = map.get(key);
                value.add(i);
            }else{
                ArrayList<Integer> value = new ArrayList<>();
                value.add(i);
                map.put(groupSizes[i], value);
            }

            //每次添加完一个元素后，判断是否该组已经满人了；
            List<Integer> value = map.get(key);
            if(value.size() >= key){
                ans.add(new ArrayList<>(value));
                value.clear();
            }
        }

        if(map.size() != 0){
            for (List<Integer> x : map.values()) {
                if(x.size() != 0) ans.add(x);
            }
        }
        return ans;
    }
}
