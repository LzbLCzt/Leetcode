package Exam.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//荣耀第一题
public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] t1 = bf.readLine().split(" ");
        int n = Integer.parseInt(t1[0]);
        int k = Integer.parseInt(t1[1]);
        String[] t2 = bf.readLine().split(" ");
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = Integer.parseInt(t2[i]);
        }
        
    }

}