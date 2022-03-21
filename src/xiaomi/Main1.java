package xiaomi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(",");
        int m = Integer.parseInt(arr[0].substring(2,3));
        int n = Integer.parseInt(arr[1].substring(2,3));
        int[] a = new int[m];
        int[] b = new int[n];
        System.out.println(m);
        System.out.println(n);
        String[] str1 = br.readLine().split(",");
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(str1[i]);
        }
        String[] str2 = br.readLine().split(",");
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(str2[i]);
        }


        calculate(a,b);
    }

    private static void calculate(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        merge(a,b);
    }

    private static void merge(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        int i = 0, j = 0, t = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]){
                ans[t++] = a[i++];
            }else {
                ans[t++] = b[j++];
            }
        }
        while (i < a.length) {
            ans[t++] = a[i++];
        }
        while (j < b.length) {
            ans[t++] = b[j++];
        }

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }


}