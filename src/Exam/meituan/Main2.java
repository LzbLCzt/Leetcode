package Exam.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//荣耀第一题
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] temp = bf.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = temp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(arr[i][0]) == 1){
                str += arr[i][1];
            }else{
                int diff = getPosition(str, Integer.parseInt(arr[i][1]) - 1);
                System.out.println(diff);
            }
        }
    }

    private static int getPosition(String str, int index) {
        if (index > str.length() - 1){
            return -1;
        }
        char target = str.charAt(index);
        int l = index - 1;
        int r = index + 1;
        while (l >= 0){
            if (str.charAt(l) == target){
                break;
            }
            l--;
        }
        while (r < str.length()){
            if (str.charAt(r) == target){
                break;
            }
            r++;
        }
        if (l >= 0 && r < str.length()){
            return Math.min(Math.abs(l - index), Math.abs(r - index));
        }
        if (l >= 0){
            return Math.abs(l - index);
        }
        if (r < str.length()){
            return Math.abs(r - index);
        }
        return -1;
    }


}