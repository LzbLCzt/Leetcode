package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode986 {
    public static void main(String[] args) {
        leetcode986 leetcode986 = new leetcode986();
        int[][] firstList = new int[][]{{1,7},{8,12}};
        int[][] secondList = new int[][]{{39,434}};
        int[][] res = leetcode986.intervalIntersection(firstList, secondList);
        for (int[] x : res) {
            System.out.println(Arrays.toString(x));
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length, m = secondList.length;
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;   //i：firstList的指针，j：secondList的指针
        while (i < n && j < m) {    //*****i，j只要有一个越界，（例如i越界，说明j后面的区间都不再满足条件）
            int[] num1 = firstList[i];
            int[] num2 = secondList[j];
            int[] intersection = getIntersection(num1, num2);   //获取交集，不存在返回null
            if (intersection != null) {
                res.add(intersection);
            }
            //若i，j都不越界
            if (num1[1] >= num2[1]){
                j++;
            }else {
                i++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    private int[] getIntersection(int[] num1, int[] num2) {
        int L = Math.max(num1[0], num2[0]);
        int R = Math.min(num1[1], num2[1]);
        return L > R? null:new int[]{L,R};
    }
}
