package wangyihuyu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] tmp = sc.next().split(",");
            int[] arr = new int[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                arr[i] = Integer.parseInt(tmp[i]);
            }
            System.out.println(calculate(arr));
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