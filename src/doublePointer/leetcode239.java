package doublePointer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetcode239 {
    public static void main(String[] args) {
        leetcode239 leetcode239 = new leetcode239();
//        int[] res = leetcode239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] res = leetcode239.maxSlidingWindow(new int[]{7, 2, 4}, 2);
        System.out.println(Arrays.toString(res));
    }

    //方法一：优先队列
//    int[] res;
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if (k >= n) return new int[]{Arrays.stream(nums).max().getAsInt()};
//        res  = new int[n - k + 1];
//        PriorityQueue<int[]> pd = new PriorityQueue<>(new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
//            }
//        });
//        for (int i = 0; i < k; i++) {
//            pd.offer(new int[]{nums[i], i});
//        }
//        res[0] = pd.peek()[0];
//        for (int i = k; i < n; i++) {
//            pd.offer(new int[]{nums[i], i});
//            //*******保证堆顶元素是属于滑动区间的( (i-k,i] )，否则剔除
//            while (pd.peek()[1] <= i - k){
//                pd.poll();
//            }
//            res[i - k + 1] = pd.peek()[0];
//        }
//        return res;
//    }

    //单调队列****
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) return new int[]{Arrays.stream(nums).max().getAsInt()};
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            //保证队列是单调递减的
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            while (deque.peekFirst() <= i - k){ //*****保证队列头部元素是属于滑动区间的 ( (i-k, i] )
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
