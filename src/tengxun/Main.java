package tengxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<int[]> ans = main.search(new int[]{0, 0, 0, 0}, 3);
        for (int i = 0; i < ans.size(); i++) {
            int[] arr = ans.get(i);
            System.out.println(Arrays.toString(arr));
        }
    }

    int ans;
    int top;
    List<int[]> list;
    public List<int[]> search(int[] arr, int k){
        ans = 0;
        top = k;
        list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0){

                dfs(arr, i);
                break;
            }
        }
        return list;
    }

    private void dfs(int[] arr, int i) {
        if (i == arr.length){
            ans += 1;
            int[] newArr = Arrays.copyOf(arr, arr.length);
            list.add(newArr);
            return;
        }
        int n = arr.length;
        int min = i == 0? 1: arr[i-1];
        int max = i == n - 1? top: Math.min(arr[i+1] == 0? top: arr[i+1], top);
        if (arr[i] == 0){
            for (int j = min; j <= max; j++) {
                int temp = arr[i];
                arr[i] = j;

                dfs(arr,i+1);

                arr[i] = temp;
            }
        }else {
            dfs(arr, i + 1);
        }
    }
}