package Exam.AiQiYi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//荣耀第一题
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(",");
        int[] arr = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        int ans = calculate(arr);
        System.out.println(ans);
    }

    static int ans;
    static int flag;    //记录当前是上升还是下降，1：上升，0：下降
    private static int calculate(int[] arr) {
        ans = 0;
        if (arr.length < 2){
            return 0;
        }
        int start = arr[0];
        flag = (arr[1] > arr[0])? 1: 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]){
                if (flag == 1){
                    ans = Math.max(ans, arr[i] - start);
                }else {
                    start = arr[i-1];
                    ans = Math.max(ans ,Math.abs(arr[i-1] - arr[i]));
                    flag = 1;
                }
            }else {
                if (flag == 0){
                    ans = Math.max(ans, Math.abs(arr[i] - start));
                }else {
                    start = arr[i-1];
                    ans = Math.max(ans, Math.abs(arr[i] - arr[i-1]));
                    flag = 0;
                }
            }
        }
        return ans;
    }

}