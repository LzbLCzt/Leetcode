package Graph2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-03-31 22:58
 */
public class leetcode210 {
    public static void main(String[] args) {
        int[][] pre = {{1,0},{0,1}};
        int numCourses = 2;
        leetcode210 leetcode210 = new leetcode210();
        int[] ans = leetcode210.findOrder(5, new int[][]{{2,1},{3,1},{1,4}});
        System.out.println(Arrays.toString(ans));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] nums = new int[numCourses];
        int[] res = new int[numCourses];
        int index = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : prerequisites) {
            graph.get(x[1]).add(x[0]);
            ++nums[x[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()){
            res[index++] = queue.poll();
            for (Integer next : graph.get(res[index - 1])) {
                nums[next]--;
                if (nums[next] == 0) queue.offer(next);
            }
        }
        return index == numCourses? res: new int[0];
    }

}
