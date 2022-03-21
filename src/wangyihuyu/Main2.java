package wangyihuyu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int i = Integer.parseInt(strs[0]);
        int j = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        int[][][] arr = new int[i][j][k];

        int times = Integer.parseInt(br.readLine());
        for (int m = 0; m < times; m++) {
            String[] tmp = br.readLine().split(" ");
            int dimension = Integer.parseInt(tmp[0]);
            int pos = Integer.parseInt(tmp[1]);
            if (dimension == 0){
                int[][] t = arr[pos];
                for (int v = 0; v < t.length; v++) {
                    for (int z = 0; z < t[0].length; z++) {
                        t[v][z]++;
                    }
                }
            }else if (dimension == 1){
                for (int v = 0; v < i; v++) {
                    int[][] t = arr[v];
                    int[] t2 = t[pos];
                    for (int z = 0; z < t2.length; z++) {
                        t2[z]++;
                    }
                }
            } else if (dimension == 2) {
                for (int v = 0; v < i; v++) {
                    int[][] t = arr[v];
                    for (int j2 = 0; j2 < j; j2++) {
                        int[] t2 = t[j2];
                        t2[pos]++;
                    }
                }
            }
        }


        for (int i1 = 0; i1 < i; i1++) {
            for (int j1 = 0; j1 < j; j1++) {
                for (int k1 = 0; k1 < k; k1++) {
                    System.out.print(arr[i1][j1][k1] + " ");
                }
            }
        }
    }

    private static int calculate(int[] arr) {
        int steps = 0, end = 0, positions = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            positions = Math.max(positions, i + arr[i]);
            if (i == end) {
                steps++;
                end = positions;
            }
        }
        return steps;
    }


}