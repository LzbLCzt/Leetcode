package wangyihuyu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        for (int m = 0; m < tmp.length; m++) {
            String str = tmp[m];
            int ans = calculate(str);
            System.out.println(ans);
        }


    }
    static PriorityQueue<Integer> heap1 = new PriorityQueue<>();
    static PriorityQueue<Integer> heap2 = new PriorityQueue<>();
    static int sum1 = 0, sum2 = 0;
    static int steps = 0;;
    private static int calculate(String str) {
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(str.charAt(i) + "");
            if (i % 2 == 0) {
                heap2.add(num);
                sum1 += num;
            }else {
                heap2.add(num);
                sum2 += num;
            }
        }

        if (sum1 == sum2) {
            return 0;
        } else if (sum1 > sum2) {
            PriorityQueue<Integer> tmp = heap1;
            heap1 = heap2;
            heap2 = tmp;
            int tmp2 = sum1;
            sum1 = sum2;
            sum2 = tmp2;
        }

        int diff = sum2 - sum1;
        while (diff > 0) {
            int num = heap1.poll();
            diff -= 9 - num;
            steps++;
        }
        return steps;
    }

}