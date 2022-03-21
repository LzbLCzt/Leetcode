package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode673 {
    public static void main(String[] args) {
        leecode673 leecode673 = new leecode673();
        int res = leecode673.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(res);
    }

//    public int findNumberOfLIS(int[] nums) {
//        int n = nums.length, maxLen = 0, ans = 0;
//        int[] dp = new int[n];
//        int[] cnt = new int[n];
//        for (int i = 0; i < n; ++i) {
//            dp[i] = 1;
//            cnt[i] = 1;
//            for (int j = 0; j < i; ++j) {
//                if (nums[i] > nums[j]) {
//                    if (dp[j] + 1 > dp[i]) {
//                        dp[i] = dp[j] + 1;
//                        cnt[i] = cnt[j]; // 重置计数
//                    } else if (dp[j] + 1 == dp[i]) {
//                        cnt[i] += cnt[j];
//                    }
//                }
//            }
//            if (dp[i] > maxLen) {
//                maxLen = dp[i];
//                ans = cnt[i]; // 重置计数
//            } else if (dp[i] == maxLen) {
//                ans += cnt[i];
//            }
//        }
//        return ans;
//    }


    //方法二：贪心 + 树状数组 + 二分
    public int findNumberOfLIS(int[] nums) {
        List<List<Integer>> d = new ArrayList<List<Integer>>();
        List<List<Integer>> cnt = new ArrayList<List<Integer>>();
        for (int v : nums) {
            int i = binarySearch1(d.size(), d, v);
            int c = 1;
            if (i > 0) {
                int k = binarySearch2(d.get(i - 1).size(), d.get(i - 1), v);
                c = cnt.get(i - 1).get(cnt.get(i - 1).size() - 1) - cnt.get(i - 1).get(k);
            }
            if (i == d.size()) {
                List<Integer> dList = new ArrayList<Integer>();
                dList.add(v);
                d.add(dList);
                List<Integer> cntList = new ArrayList<Integer>();
                cntList.add(0);
                cntList.add(c);
                cnt.add(cntList);
            } else {
                d.get(i).add(v);
                int cntSize = cnt.get(i).size();
                cnt.get(i).add(cnt.get(i).get(cntSize - 1) + c);
            }
        }

        int size1 = cnt.size(), size2 = cnt.get(size1 - 1).size();
        return cnt.get(size1 - 1).get(size2 - 1);
    }

    public int binarySearch1(int n, List<List<Integer>> d, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            List<Integer> list = d.get(mid);
            if (list.get(list.size() - 1) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int binarySearch2(int n, List<Integer> list, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
