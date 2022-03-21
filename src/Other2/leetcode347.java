package Other2;

import java.util.*;

public class leetcode347 {
    public static void main(String[] args) {

    }

//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            heap.offer(new int[]{entry.getKey(), entry.getValue()});
//            if (heap.size() > k) heap.poll();
//        }
//        int[] res = new int[k];
//        int i = 0;
//        while (!heap.isEmpty()){
//            res[i++] = heap.poll()[0];
//        }
//        return res;
//    }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
            if (res.size() >= k) break;
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

}
