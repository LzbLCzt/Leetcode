package Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//荣耀第一题
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String t1 = bf.readLine();
        String t2 = bf.readLine();
        int N = Integer.parseInt(t1);
        int M = Integer.parseInt(t2);

        boolean[][] standard = getStandard(N,M);

//        for (boolean[] x : standard) {
//            System.out.println(Arrays.toString(x));
//        }
//        System.out.println();

        for (int i = N; i <= M; i++) {
            for (int j = i + 1; j <= M; j++) {
                int leftTotal = i * i + j * j;
                for (int k = j + 1; k <= M; k++) {
                    if (leftTotal == k * k){
                        boolean t = zhishu(i-N,j-N,k-N,standard);
                        if (t){
                            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                                @Override
                                public int compare(Integer o1, Integer o2) {
                                    return o1.compareTo(o2);
                                }
                            });
                            heap.add(i);
                            heap.add(j);
                            heap.add(k);
                            while (!heap.isEmpty()){
                                System.out.print(heap.poll() + " ");
                            }
                            System.out.println();

                        }
                    }else if (leftTotal < k * k){
                        break;
                    }
                }
            }
        }
    }

    private static boolean zhishu(int i, int j, int k, boolean[][] standard) {
        if (!standard[i][j] || !standard[i][k] || !standard[j][k]){
            return false;
        }
        return true;
    }

    private static boolean[][] getStandard(int n, int m) {
        boolean[][] res = new boolean[m - n + 1][m - n + 1];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                if (i == j){
                    continue;
                }
                if (judge(i + n, j + n) != 1) {
                    res[i][j] = false;
                }else {
                    res[i][j] = true;
                }
            }
        }
        return res;
    }

    private static int judge(int x, int y) {
        if (x == 0 || y == 0){
            return 1;
        }
        if (x % y == 0){
            return y;
        }else {
            return judge(y, x % y);
        }
    }

}