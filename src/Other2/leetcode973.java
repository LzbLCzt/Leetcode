package Other2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode973 {
    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1];
            }
        });  //int[]: int[0]:points下标i，int[1]:points[i]的平方和
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int sqrt = sqrt(points[i][0], points[i][1]);
            heap.offer(new int[]{i, sqrt});
            if (heap.size() > k) heap.poll();
        }
        while (!heap.isEmpty()) res.add(points[heap.poll()[0]]);
        return res.toArray(new int[k][]);
    }

    private int sqrt(int x, int y) {
        return x * x + y * y;
    }
}
