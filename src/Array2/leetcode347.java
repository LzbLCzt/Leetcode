package Array2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode347 {
    public static void main(String[] args) {
        
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num,0) + 1);
        }

        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(Map.Entry<Integer, Integer> entry: occurrences.entrySet()){
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (heap.size() == k){
                if (count > heap.peek()[1]){
                    heap.poll();
                    heap.offer(new int[]{num,count});
                }
            }else {
                heap.offer(new int[]{num, count});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }
}
