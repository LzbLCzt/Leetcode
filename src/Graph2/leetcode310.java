package Graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode310 {
    public static void main(String[] args) {

    }

    /*
    bfs + 剪纸
     */

    List<List<Integer>> edges;
    int[] degree;
    List<Integer> res;
    public List<Integer> findMinHeightTrees(int n, int[][] arr) {
        res = new ArrayList<>();
        if(n < 2) return res;

        edges = new ArrayList<>();
        degree = new int[n];

        //1. 初始化
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        //2. 构造图，计算度
        for (int[] x : arr) {
            edges.get(x[0]).add(x[1]);
            edges.get(x[1]).add(x[0]);
            degree[x[0]]++;
            degree[x[1]]++;
        }

        //3. 要bfs，就需要一个队列
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 1) queue.offer(i);
        }

        while (!queue.isEmpty()){
            res = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                res.add(cur);

                List<Integer> neighbors = edges.get(cur);
                for (Integer neighbor : neighbors) {
                    degree[neighbor]--;
                    if(degree[neighbor] == 1) queue.offer(neighbor);
                }
            }
        }

        return res;
    }
}
