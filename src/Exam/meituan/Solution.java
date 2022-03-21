package Exam.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//荣耀第一题
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        String[] temp = bf.readLine().split(" ");
        int[] arr = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(arr);

        calculate(arr, n);

        System.out.println(outcome);
        for (List<Integer> x : ans) {
            for (Integer y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> ans;
    static int outcome;
    static boolean[] isVisited;
    private static void calculate(int[] arr, int n) {
        ans = new ArrayList<>();
        isVisited = new boolean[n];
        outcome = 0;
        dfs(arr,n,0, new ArrayList<>());
    }

    private static void dfs(int[] arr, int n, int index, List<Integer> list) {
        if (index >= n){
            outcome++;
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0 && arr[i-1] == arr[i] && !isVisited[i-1]){
                continue;
            }
            if (!isVisited[i]){
                isVisited[i] = true;
                list.add(arr[i]);

                dfs(arr,n,index + 1,list);

                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


}