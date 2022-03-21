package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shkstart
 * @create 2021-03-26 13:52
 */
public class wangyiDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int n = str.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;         // 最后一个字符肯定只能是一种翻译
        // 从后往前遍历字符
        for(int i = n - 1; i >= 0; i--){
            dp[i] = dp[i + 1];     // 单字符码的情况
            if(str[i] == '1'){      // 对于"1"，还有双字符码和三字符码的情况
                if(i + 2 <= n) dp[i] += dp[i + 2];
                if(i + 3 <= n) dp[i] += dp[i + 3];
            }
        }
        System.out.println(dp[0]);
    }

    public static int count(int x, int[] arr){
        if(arr.length < 1 || arr == null) return 0;

        int sum  = 0;
        for(int ele: arr){
            sum += ele;
        }

        int ans = sum / x + ((sum % x == 0)? 0: 1);
        return ans;
    }

    public static int decode(String str){
        if(str.length() < 1) return 0;

        int n = str.length();
        int[] dp = new int[n];
        int max = str.charAt(0), min = str.charAt(0), ans = 0, start = 0;

        for (int i = 1; i < n; i++) {
            //更新max、min
            max = Math.max(str.charAt(i), max);
            min = Math.min(str.charAt(i), min);

            //判断差值
            int diff = max - min;
            if(diff > 1){
                dp[i] = 0;
                start++;
                i = start;
                max = str.charAt(i);
                min = str.charAt(i);

            }else if(diff == 1){
                dp[i] = i - start + 1;
            }else if(diff == 0){
                dp[i] = 0;
            }

            ans = Math.max(dp[i], ans);
        }

        return ans;
    }


    static int ans;
    public static int daFuWeng(int x, int[] arr){
        if(arr.length < 1 || arr == null) return x;

        ans = 0;
        next(x, arr, -1);
        return ans;
    }

    /*
    x:此时剩下多少金币
    i：走到那个下标了
    返回值表示走到此步剩下多少钱
     */
    private static int next(int x, int[] arr, int i) {
        if(i > arr.length - 1) return x;

        if(i >= 0) x += arr[i];
        ans = Math.max(x, ans);
        if(x - 2 >= 0) next(x-2,arr,i+1);
        if(x - 3 >= 0) next(x-3, arr, i+2);

        return x;
    }
}
