package Math;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode264 {
    public static void main(String[] args) {
        leetcode264 leetcode264 = new leetcode264();
        int res = leetcode264.nthUglyNumber(78);
        System.out.println(res);
    }

    public int nthUglyNumber(int n) {
        if(n <= 5) return n;

        int[] arr = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        arr[0] = 1;

        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(Math.min(2 * arr[p2], 3 * arr[p3]), 5 * arr[p5]);
            if(arr[i] == 2 * arr[p2]) p2++;
            if(arr[i] == 3 * arr[p3]) p3++;
            if(arr[i] == 5 * arr[p5]) p5++;
        }

        return arr[n-1];
    }
}
