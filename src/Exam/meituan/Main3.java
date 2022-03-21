package Exam.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//荣耀第一题
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] temp = bf.readLine().split(" ");
        int[] data = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = Integer.parseInt(temp[i]);
        }
        int timeOfSearch = Integer.parseInt(bf.readLine());
        int[][] arr = new int[timeOfSearch][3];
        for (int i = 0; i < timeOfSearch; i++) {
            String[] t1 = bf.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(t1[j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 1){
                //求和
                long result = getSum(data,arr[i][1] - 1, arr[i][2] - 1);
                System.out.println(result);
            }else if (arr[i][0] == 2){
                //有效值
                Long result = getEffective(data, arr[i][1] - 1, arr[i][2] - 1);
                System.out.println(result);
            }else if (arr[i][0] == 3){
                //最大值
                long result = getMax(data, arr[i][1] - 1, arr[i][2] - 1);
                System.out.println(result);
            }
        }

    }

    private static long getMax(int[] data, int l, int r) {
        long max = data[l];
        for (int i = l; i <= r; i++) {
            max = Math.max(max, data[i]);
        }
        return max;
    }

    private static long getEffective(int[] data, int l, int r) {
        long sum = getSum(data, l, r);
        long ans = 0L;
        for (int i = l; i <= r; i++) {
            ans += (sum - data[i]) * (sum - data[i]);
        }
        return ans;
    }

    private static long getSum(int[] data, int l, int r) {
        long sum = 0;
        for (int i = l; i <= r; i++) {
            sum += data[i];
        }
        return sum;
    }

}